package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.base.controller.BaseController;
import cn.itsource.dto.Oferr;
import cn.itsource.excel.ApplicantExcel;
import cn.itsource.model.Applicant;
import cn.itsource.model.Emp;
import cn.itsource.service.ApplicantService;
import cn.itsource.service.EmpService;
import cn.itsource.utils.EmailUtills;
import cn.itsource.utils.JsonReturnData;
import cn.itsource.utils.PageTable;
import cn.itsource.utils.WebConstant;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/applicantController")
public class ApplicantController extends BaseController {

    @Autowired
    ApplicantService applicantService;


    @Autowired
    EmailUtills emailUtills;

    @Autowired
    EmpService empService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        return "applicant/list";
    }

    /**
     * AJAX跟新列表
     */
    @RequestMapping("/ajaxList")
    @ResponseBody
    public String ajaxList(Integer page, Integer limit, Applicant applicant) {
        PageTable<List<Applicant>> pageTable = new PageTable<List<Applicant>>();
        applicant.setLogictodelete(WebConstant.NODELETECODE);
        PageInfo<Applicant> pageInfo = applicantService.queryPageListByParam(page, limit, applicant);
        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());
        return responseAPI.getJsonString(pageTable);
    }


    /**
     * 功能: 保存或修改页面
     * 代号: 隐无为
     */
    @RequestMapping("/saveUpdatePage")
    public String saveUpdatePage(Integer id, ModelMap modelMap) {
        if (id != null) {
            modelMap.put("applicant", applicantService.queryById(id));
        }
        return "applicant/saveUpdatePage";
    }


    /**
     * 功能: 保存或修改操作
     * 代号: 隐无为
     */
    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(Applicant applicant) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (applicant.getId() != null) {
            applicantService.updateNoNull(applicant);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {
            applicant.setLogictodelete(1);
            applicantService.insert(applicant);
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
    public String delete(Applicant applicant) {

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (applicant.getId() != null) {
            applicant.setLogictodelete(WebConstant.DELETECODE);
            applicantService.updateDelete(applicant);
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
            applicantService.updateDeletes(ids);
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
        List<Applicant> list = applicantService.findAll(1);
        List<ApplicantExcel> listExcel = new ArrayList<ApplicantExcel>();
        for (Applicant applicant : list) {
            ApplicantExcel applicantExcel = new ApplicantExcel();
            BeanUtils.copyProperties(applicant, applicantExcel);
            listExcel.add(applicantExcel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, ApplicantExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "用户信息"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    /**
     * 功能: 发邮件
     * 代号: 隐无为
     */
    @RequestMapping("/email")
    @ResponseBody
    public String email(String[] email,String[] nameArr) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "邮件发送失败");

        //获取明天上午10点时间
        final GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(GregorianCalendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sf.format(calendar.getTime());

        if (!StringUtils.isEmpty(email)) {
            for (int i = 0; i < email.length; i++) {
                Oferr oferr = new Oferr(nameArr[i],format,"3","2","8000");
                //发邮件
                try {
                    emailUtills.sendHtmlMail(email[i], "来自远方的信",oferr.getContent(oferr));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("邮件发送成功!");
        }
        return responseAPI.getJsonString(jsonReturnData);
    }

    /**
     * 功能: 录入员工
     * 代号: 隐无为
     */
    @RequestMapping("/enrollEmp")
    @ResponseBody
    public String enrollEmp(String appId) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "录入失败");

        if (!StringUtils.isEmpty(appId)) {
            Applicant applicant = applicantService.queryById(appId);
            //删除
            applicantService.delete(appId);
            Emp emp = new Emp();

            emp.setUserid(null);
            emp.setSign(null);
            emp.setAvatar(null);
            emp.setName(applicant.getName());
            emp.setPassword("123456");
            emp.setImg(null);
            emp.setBirthday(new Date());
            if (applicant.getSex() == 1 && applicant.getSex() != null) {
                emp.setSex("男");
            } else {
                emp.setSex("女");
            }
            emp.setPhone(applicant.getPhone());
            emp.setQq(applicant.getQq());
            emp.setEmail(applicant.getEmail());
            emp.setAge(applicant.getAge());
            emp.setCurrentaddress(applicant.getCurrentaddress());
            emp.setInductiontime(new Date());
            emp.setState(1);
            emp.setSpecialty(applicant.getSpecialty());
            emp.setMark(applicant.getMark());
            emp.setIslogin(0);
            emp.setDeptId(1);
            emp.setPaygradesId(1);
            emp.setPositionId(14);
            emp.setLogictodelete(1);
            //添加
            empService.insert(emp);

            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("添加成功!");
        }
        return responseAPI.getJsonString(jsonReturnData);
    }

}
