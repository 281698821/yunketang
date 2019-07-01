package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.base.controller.BaseController;
import cn.itsource.excel.*;
import cn.itsource.model.*;
import cn.itsource.service.DeptService;
import cn.itsource.service.EmpService;
import cn.itsource.service.PositionService;
import cn.itsource.utils.JsonReturnData;
import cn.itsource.utils.PageTable;
import cn.itsource.utils.WebConstant;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/empController")
public class EmpController extends BaseController {
    // 日志对象
    Logger logger = LoggerFactory.getLogger(getClass());
   @Autowired
   EmpService empService;

   @Autowired
   DeptService deptService;

   @Autowired
    PositionService positionService;
    /**
     * 功能: 列表页面
     * 代号: 隐无为
     */
    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        logger.info("===============进入列表页面==================");
        return "emp/list";
    }

   /* *
     * 功能: 保存或修改页面
     * 代号: 隐无为
     */
    @RequestMapping("/saveUpdatePage")
    public String saveUpdatePage(Integer id, ModelMap modelMap) {
        //存入部门和职位
        modelMap.put("deptList",deptService.queryAllByDistinct());
        modelMap.put("positionList",positionService.queryAllList());
        if (id != null) {
            modelMap.put("emp", empService.queryByIdWithOther(id));
        }
        return "emp/saveUpdatePage";
    }

   /* *
     * 功能: ajax-获取列表数据
     * 代号: 隐无为
     */
    @RequestMapping("/ajaxList")
    @ResponseBody
    public String ajaxList(Integer page, Integer limit, Emp emp) {
        PageTable<List<Emp>> pageTable = new PageTable<List<Emp>>();
        emp.setLogictodelete(WebConstant.NODELETECODE);
        PageInfo<Emp> pageInfo = empService.queryAllWithOthers(page, limit, emp);
        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());
        return responseAPI.getJsonString(pageTable);

    }


   /* *
     * 功能: 保存或修改操作
     * 代号: 隐无为
     */
    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(Emp emp) {
        System.err.println(emp);
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (emp.getId() != null) {
            empService.updateNoNull(emp);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {
            emp.setLogictodelete(1);
            empService.insert(emp);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("添加成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }

    /**
     * 功能: 删除(假删除)
     * 代号: 隐无为
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Emp emp) {

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (emp.getId() != null) {
            emp.setLogictodelete(WebConstant.DELETECODE);
            empService.updateDelete(emp);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("删除成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }

    /**
     * 功能: 批量删除(假删除)
     * 代号: 隐无为
     */
    @RequestMapping("/deletes")
    @ResponseBody
    public String deletes(String ids) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "批量删除失败");
        if (!StringUtils.isEmpty(ids)) {
            empService.updateDeletes(ids);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("批量删除成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }

    /**
     * 功能: 导出excel
     * 代号: 隐无为
     */
    @RequestMapping("/export")
    public void export(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        List<Emp> list = empService.queryAllWithOthers(new Emp());
        List<EmpExcel> listExcel = new ArrayList<EmpExcel>();
        for (Emp emp : list) {
            EmpExcel empExcel = new EmpExcel();
            BeanUtils.copyProperties(emp, empExcel);

            Dept dept = emp.getDept();
            if(dept!=null){
                DeptNameExcel deptNameExcel = new DeptNameExcel();
                BeanUtils.copyProperties(dept,deptNameExcel);
                empExcel.setDeptNameExcel(deptNameExcel);
            }

            Position position = emp.getPosition();
            if(position!=null){
                PositionNameExcel positionNameExcel = new PositionNameExcel();
                BeanUtils.copyProperties(position,positionNameExcel);
                empExcel.setPositionNameExcel(positionNameExcel);
            }

            Paygrades paygrades = emp.getPaygrades();
            if(paygrades!=null){
                PaygradesNameExcel paygradesNameExcel = new PaygradesNameExcel();
                BeanUtils.copyProperties(paygrades,paygradesNameExcel);
                empExcel.setPaygradesNameExcel(paygradesNameExcel);
            }

            listExcel.add(empExcel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, EmpExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "员工信息"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
