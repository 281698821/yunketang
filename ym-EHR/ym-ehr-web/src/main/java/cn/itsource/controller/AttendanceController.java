package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.base.controller.BaseController;
import cn.itsource.converter.DateConverter;
import cn.itsource.excel.AttEmpViewExcel;
import cn.itsource.excel.UserExcel;
import cn.itsource.model.*;
import cn.itsource.service.*;
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
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/attendance")
public class AttendanceController extends BaseController {
    // 日志对象
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private EmpService empService;
    @Autowired
    AttEmpViewService attEmpViewService;
    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        logger.info("===============进入列表页面==================");
        return "attendance/list";
    }

   @RequestMapping("/ajaxList")
   @ResponseBody
   public String ajaxList(Integer page, Integer limit, AttEmpView attEmpView) {
       PageTable<List<AttEmpView>> pageTable = new PageTable<List<AttEmpView>>();
       attEmpView.setLogictodelete(WebConstant.NODELETECODE);
       PageInfo<AttEmpView> pageInfo = attEmpViewService.queryPageListByParam(page, limit, attEmpView);
       pageTable.setCode(WebConstant.PAGESUCCESSCODE);
       pageTable.setMsg("获取成功");
       pageTable.setData(pageInfo.getList());
       pageTable.setCount(pageInfo.getTotal());
       return responseAPI.getJsonString(pageTable);
   }
    //根据id查询用户名
    @RequestMapping("/getName")
    @ResponseBody
    public Emp getName(Integer id){
        Emp emp = empService.queryById(id);
        return emp;
    }
    /**
     * 功能: 保存或修改页面
     * 代号: 隐无为
     */
    @RequestMapping("/saveUpdatePage")
    public String saveUpdatePage(Integer id, ModelMap modelMap) {
        if (id != null) {
            modelMap.put("attendance", attendanceService.queryById(id));
        }
        return "attendance/saveUpdatePage";
    }
    /**
     * 功能: 修改操作
     * 代号: 隐无为
     */
    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(Attendance attendance) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (attendance.getId() != null) {
            attendanceService.updateNoNull(attendance);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        }
        return responseAPI.getJsonString(jsonReturnData);
    }
    //删除(假删除)
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Attendance attendance){
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (attendance.getId() != null) {
            attendance.setLogictodelete(WebConstant.DELETECODE);
            attendanceService.updateDelete(attendance);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("删除成功");
        }
        return responseAPI.getJsonString(jsonReturnData);
    }
    @RequestMapping("/export")
    public void export(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        List<AttEmpView> list = attEmpViewService.queryAllList();
        List<AttEmpViewExcel> listExcel = new ArrayList<AttEmpViewExcel>();
        for (AttEmpView attEmpView : list) {
            AttEmpViewExcel excel = new AttEmpViewExcel();
            BeanUtils.copyProperties(attEmpView, excel);
            listExcel.add(excel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, AttEmpViewExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "考勤表"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    /*批量删除（假删除）*/
    @RequestMapping("/deletes")
    @ResponseBody
    public String deletes(String ids) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "批量删除失败");
        if (!StringUtils.isEmpty(ids)) {
            attendanceService.updateByIds(ids);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("批量删除成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }

}
