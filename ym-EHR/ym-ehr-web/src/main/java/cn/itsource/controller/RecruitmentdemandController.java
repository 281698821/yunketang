package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.base.controller.BaseController;
import cn.itsource.dto.RecruitmentdemandDto;
import cn.itsource.excel.RecruitmentdemandExcel;
import cn.itsource.model.Recruitmentdemand;
import cn.itsource.query.RecruitmentdemandQuery;
import cn.itsource.service.EmpService;
import cn.itsource.service.RecruitmentdemandService;
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
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/recruitmentdemandController")
public class RecruitmentdemandController extends BaseController {

    @Autowired
    RecruitmentdemandService recruitmentdemandService;

    @Autowired
    EmpService empService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        return "recruitmentdemand/list";
    }


    /**
     * AJAX跟新列表
     */
    @RequestMapping("/ajaxList")
    @ResponseBody
    public Object ajaxList(Integer page, Integer limit, RecruitmentdemandQuery recruitmentdemandQuery) {
        PageTable<List<RecruitmentdemandDto>> pageTable = new PageTable<List<RecruitmentdemandDto>>();
        PageInfo<RecruitmentdemandDto> pageInfo = recruitmentdemandService.queryListByParam(page, limit, recruitmentdemandQuery);
//        recruitmentdemandDto.setLogictodelete(WebConstant.NODELETECODE);
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
            modelMap.put("recruitmentdemand", recruitmentdemandService.queryById(id));
        }
        return "recruitmentdemand/saveUpdatePage";
    }


    /**
     * 功能: 保存或修改操作
     * 代号: 隐无为
     */
    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(Recruitmentdemand recruitmentdemand) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (recruitmentdemand.getId() != null) {
            recruitmentdemandService.updateNoNull(recruitmentdemand);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {
            recruitmentdemand.setLogictodelete(1);
            recruitmentdemandService.insert(recruitmentdemand);
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
    public String delete(Recruitmentdemand recruitmentdemand) {

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (recruitmentdemand.getId() != null) {
            recruitmentdemand.setLogictodelete(WebConstant.DELETECODE);
            recruitmentdemandService.updateDelete(recruitmentdemand);
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
            recruitmentdemandService.updateDeletes(ids);
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
    public void export(ModelMap map, HttpServletRequest request, HttpServletResponse response, String rdtos) {
        List<RecruitmentdemandDto> list = recruitmentdemandService.queryAll(1);
        List<RecruitmentdemandExcel> listExcel = new ArrayList<RecruitmentdemandExcel>();
        for (RecruitmentdemandDto recruitmentdemandDto : list) {
            RecruitmentdemandExcel recruitmentdemandExcel = new RecruitmentdemandExcel();

            recruitmentdemandExcel.setEmpName(recruitmentdemandDto.getEmp().getName());

            BeanUtils.copyProperties(recruitmentdemandDto, recruitmentdemandExcel);
            listExcel.add(recruitmentdemandExcel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, RecruitmentdemandExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "用户信息"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
