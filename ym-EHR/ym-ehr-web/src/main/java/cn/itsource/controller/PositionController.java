package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.ResponseAPI;
import cn.itsource.excel.DeptNameExcel;
import cn.itsource.excel.PositionExcel;
import cn.itsource.model.Dept;
import cn.itsource.model.Position;
import cn.itsource.service.DeptService;
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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/positionController")
public class PositionController {

    // 日志对象
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    PositionService positionService;

    @Autowired
    ResponseAPI responseAPI;

    @Autowired
    DeptService deptService;

    /**
     * 功能: 列表页面
     * 代号: 隐无为
     */
    @RequestMapping("/list")
    public String list(Model model) {
        List<Position> positionNames = positionService.queryAllListWithDept();
        //得到部门
        List<Dept> depts = deptService.queryAllByDistinct();
        model.addAttribute("positionNames", positionNames);
        model.addAttribute("depts", depts);
        logger.info("===============进入列表页面==================");
        return "position/list";
    }
    /**
     * 功能: 保存或修改页面
     */
    @RequestMapping("/saveUpdatePage")

    public String saveUpdatePage(Long id, ModelMap modelMap) {
        //得到所有的部门
        if (id != null) {
            modelMap.put("position", positionService.queryPositionById(id));
        }
        modelMap.put("deptList",deptService.queryAllByDistinct());
        return "position/saveUpdatePage";
    }

    /**
     * 功能: ajax-获取列表数据
     * 代号: 隐无为
     */
    @RequestMapping("/ajaxList")
    @ResponseBody
    public String ajaxList(Integer page, Integer limit, Position position, String DeptName) {
        PageTable<List<Position>> pageTable = new PageTable<List<Position>>();

        position.setLogictodelete(WebConstant.NODELETECODE);
        //根据部门名称获得部门
        List<Dept> depts = deptService.queryDeptByName(DeptName);
        if(depts.size()>0) {
            position.setDept(depts.get(0));
        }
        PageInfo<Position> pageInfo = positionService.queryPageListByParams(page, limit, position);

        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());
        System.out.println(responseAPI+"------------------------------");
        return responseAPI.getJsonString(pageTable);
    }
    /**
     * 功能: 保存或修改操作
     * 代号: 隐无为
     */
    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(Position position, String DeptName) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        //根据部门名称获得部门
        List<Dept> depts = deptService.queryDeptByName(DeptName);
        if(depts.size()>0){
            position.setDept(depts.get(0));
        }
        //修改
        if (position.getId() != null) {
            positionService.updateWithDept(position);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {//保存
            position.setLogictodelete(1);
            positionService.insertWithDept(position);
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
    public String delete(Position position) {

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (position.getId() != null) {
            position.setLogictodelete(WebConstant.DELETECODE);
            positionService.updateDelete(position);
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
            positionService.updateDeletes(ids);
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
        List<Position> list = positionService.queryAllListWithDept();
        List<PositionExcel> listExcel = new ArrayList<PositionExcel>();
        for (Position position : list) {
            PositionExcel positionExcel = new PositionExcel();
            BeanUtils.copyProperties(position, positionExcel);

            Dept dept = position.getDept();

            DeptNameExcel deptNameExcel = new DeptNameExcel();

            BeanUtils.copyProperties(dept, deptNameExcel);

            positionExcel.setDeptNameExcel(deptNameExcel);

            listExcel.add(positionExcel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, PositionExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "职位信息"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

}
