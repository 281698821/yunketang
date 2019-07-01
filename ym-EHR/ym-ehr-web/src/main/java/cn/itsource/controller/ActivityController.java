package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.base.controller.BaseController;
import cn.itsource.excel.ActivityExcel;
import cn.itsource.model.Activity;
import cn.itsource.model.Emp;
import cn.itsource.service.ActivityService;
import cn.itsource.service.EmpService;
import cn.itsource.utils.EmailUtills;
import cn.itsource.utils.JsonReturnData;
import cn.itsource.utils.PageTable;
import cn.itsource.utils.WebConstant;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/activityController")
public class ActivityController extends BaseController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private EmpService empService;

    @Autowired

    private EmailUtills emailUtills;

    @Value("${email.username}")
    private String  username;

    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        return "activity/list";
    }

    /**
     * 添加组织人点击出现一个emp的表格
     */
    @RequestMapping("/empList")
    public String empList(ModelMap modelMap) {
        return "activity/empList";
    }

    @RequestMapping("/ajaxList")
    @ResponseBody
    public String ajaxList(Integer page, Integer limit, Activity activity,String empName) {

        if (empName!=null&&!"".equals(empName)){
            Emp emp = new Emp();
            emp.setName(empName);
            activity.setEmp(emp);
        }

        PageTable<List<Activity>> pageTable = new PageTable<List<Activity>>();
        activity.setLogictodelete(WebConstant.NODELETECODE);
        PageInfo<Activity> pageInfo = activityService.queryPageListByParams(page, limit, activity);
        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());
        return responseAPI.getJsonString(pageTable);

    }

    /**
     * 功能: 删除(假删除)
     * 代号: 隐无为
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Activity activity) {

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (activity.getId() != null) {
            activity.setLogictodelete(WebConstant.DELETECODE);
            activityService.updateDelete(activity );
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("删除成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }

    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(Activity activity,String empId) {
        //通过emp的id查询出组织人
        Emp emp = empService.queryById(empId);
        //把emp放入activity
        activity.setEmp(emp);
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (activity.getId() != null) {
            activityService.updateWithActivity(activity);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {
            activity.setLogictodelete(1);
            activityService.insertWithActivity(activity);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("添加成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }


    @RequestMapping("/saveUpdatePage")
    public String saveUpdatePage(Integer id, ModelMap modelMap) {
        if (id != null) {
            modelMap.put("activity", activityService.queryDeptById(id));
        }
        return "activity/saveUpdatePage";
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
            activityService.updateDeletes(ids);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("批量删除成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }

    /**
     * 功能: 批量删除(假删除)
     * 代号: 隐无为
     */
    @RequestMapping("/inform")
    @ResponseBody
    public String inform(String ids) {
        String str="";
        String introduce="";
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "发送失败");
        if (!StringUtils.isEmpty(ids)) {
            List<Activity> activities = activityService.queryByIds(ids);

            for (Activity e : activities) {
                str="活动详情："+e.getActivitythedetail()+"<hr> 举办时间："+e.getInitatetime()+"<br> 活动地址："+e.getActivityaddress();
                introduce = e.getIntroduce();
                emailUtills.sendHtmlMail("2990226486@qq.com",e.getIntroduce(),str);
            }

           // emailUtills.sendHtmlMail("2990226486@qq.com","aaa","qqq");
            activities.forEach(e-> System.out.println(e.getActivityaddress()));
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("发送成功");
        }


        return responseAPI.getJsonString(jsonReturnData);
    }

    /**
     * 功能: 导出excel
     * 代号: 隐无为
     */
    @RequestMapping("/export")
    public void export(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        List<Activity> list = activityService.queryEmpAllList();
        List<ActivityExcel> listExcel = new ArrayList<ActivityExcel>();
        for (Activity activity : list) {
            ActivityExcel activityExcel = new ActivityExcel();

            BeanUtils.copyProperties(activity, activityExcel);
            System.out.println(activityExcel.toString()+"111111111111111111111"+activity);
            activityExcel.setEmp(activity.getEmp().getName());
            listExcel.add(activityExcel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, ActivityExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "用户信息"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
