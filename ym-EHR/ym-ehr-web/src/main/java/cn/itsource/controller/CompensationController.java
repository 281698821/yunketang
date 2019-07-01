package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.base.controller.BaseController;
import cn.itsource.dto.Compensationdto;
import cn.itsource.excel.CompensationExcel;
import cn.itsource.excel.EmpNameExcel;
import cn.itsource.excel.SocialsecurityExcel;
import cn.itsource.model.Compensation;
import cn.itsource.model.Emp;
import cn.itsource.model.Socialsecurity;
import cn.itsource.service.CompensationService;
import cn.itsource.service.EmpService;
import cn.itsource.service.SocialsecurityService;
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

/**
 * 用途：员工薪资
 * 代号：离夜
 */
@Controller
@RequestMapping("/compensation")
public class CompensationController extends BaseController {
    // 日志对象
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    CompensationService compensationService;
    @Autowired
    SocialsecurityService socialsecurityService;
    @Autowired
    EmpService empService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        logger.info("===============进入列表页面==================");
        return "compensation/list";
    }

    @RequestMapping("/saveUpdatePage")
    public String saveUpdatePage(Integer id, ModelMap modelMap) {
        if (id != null) {
            modelMap.put("compensation", compensationService.findById(id));
        }
        List<Socialsecurity> socialsecurities = socialsecurityService.queryAllList();
        modelMap.put("socialsecurities", socialsecurities);
        return "compensation/saveUpdatePage";
    }
    @RequestMapping("/savePage")
    public String savePage(ModelMap modelMap) {
        return "compensation/savePage";
    }

    @RequestMapping("/savePageAjaxList")
    @ResponseBody
    public String savePageAjaxList(Integer page, Integer limit, Emp emp) {
        PageTable<List<Emp>> pageTable = new PageTable<List<Emp>>();
        emp.setLogictodelete(WebConstant.NODELETECODE);
        PageInfo<Emp> pageInfo = empService.queryListByPage(page, limit, emp);
        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());
        return responseAPI.getJsonString(pageTable);

    }


    @RequestMapping("/ajaxList")
    @ResponseBody
    public String ajaxList(Integer page, Integer limit,Compensation compensation,String name) {
        PageTable<List<Compensation>> pageTable = new PageTable<List<Compensation>>();
        compensation.setLogictodelete(WebConstant.NODELETECODE);
        PageInfo<Compensation> pageInfo = compensationService.queryListByPage(page,limit,name);
        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());
        System.out.println(responseAPI+"------------------------------");
        return responseAPI.getJsonString(pageTable);

    }



    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(Compensation compensation) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (compensation.getId() != null) {
            compensationService.updateNoNull(compensation);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {
            System.out.println(compensation);
            compensation.setLogictodelete(1);
            compensationService.insert(compensation);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("添加成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }


    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Compensation compensation) {

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (compensation.getId() != null) {
            compensation.setLogictodelete(WebConstant.DELETECODE);
            compensationService.updateDelete(compensation);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("删除成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }

    @RequestMapping("/deletes")
    @ResponseBody
    public String deletes(String ids) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "批量删除失败");
        if (!StringUtils.isEmpty(ids)) {
            compensationService.updateDeletes(ids);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("批量删除成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }

    /**
     * 功能: 导出excel
     * 代号: 离夜
     */
    @RequestMapping("/export")
    public void export(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        List<Compensation> list = compensationService.findAllList();
        List<CompensationExcel> listExcel = new ArrayList<CompensationExcel>();
        for (Compensation compensation : list) {
            CompensationExcel compensationExcel = new CompensationExcel();
            SocialsecurityExcel socialsecurityExcel = new SocialsecurityExcel();
            EmpNameExcel empExcel = new EmpNameExcel();
            Compensationdto compensationdto =(Compensationdto)compensation;
            Socialsecurity socialsecurity = compensationdto.getSocialsecurity();
            Emp emp = compensationdto.getEmp();
            BeanUtils.copyProperties(compensation, compensationExcel);
            BeanUtils.copyProperties(socialsecurity, socialsecurityExcel);
            BeanUtils.copyProperties(emp,empExcel);
            compensationExcel.setEmpNameExcel(empExcel);
            compensationExcel.setSocialsecurityExcel(socialsecurityExcel);
            listExcel.add(compensationExcel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, CompensationExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "员工薪资信息"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

}
