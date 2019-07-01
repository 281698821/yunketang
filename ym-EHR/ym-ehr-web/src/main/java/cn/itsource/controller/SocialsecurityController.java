package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.base.controller.BaseController;
import cn.itsource.excel.UserExcel;
import cn.itsource.model.Socialsecurity;
import cn.itsource.model.User;
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
 * 社保管理控制层
 */
@Controller
@RequestMapping("/socialsecurity")
public class SocialsecurityController extends BaseController {
    // 日志对象
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    SocialsecurityService socialsecurityService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        logger.info("===============进入列表页面==================");
        return "socialsecurity/list";
    }
    @RequestMapping("/ajaxList")
    @ResponseBody
    public String ajaxList(Integer page, Integer limit, Socialsecurity socialsecurity){
        PageTable<List<Socialsecurity>> pageTable = new PageTable<>();
        socialsecurity.setLogictodelete(WebConstant.NODELETECODE);
        PageInfo<Socialsecurity> pageInfo = socialsecurityService.queryPageListByParam(page, limit, socialsecurity);
        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());
        return responseAPI.getJsonString(pageTable);
    }

    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(Socialsecurity socialsecurity) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (socialsecurity.getId() != null) {
            socialsecurityService.updateNoNull(socialsecurity);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {
            socialsecurity.setLogictodelete(1);
            socialsecurityService.insert(socialsecurity);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("添加成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Socialsecurity socialsecurity) {

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (socialsecurity.getId() != null) {
            socialsecurity.setLogictodelete(WebConstant.DELETECODE);
            socialsecurityService.updateDelete(socialsecurity);
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
            socialsecurityService.updateDeletes(ids);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("批量删除成功");
        }
        return responseAPI.getJsonString(jsonReturnData);
    }

    @RequestMapping("/saveUpdatePage")
    public String saveUpdatePage(Integer id, ModelMap modelMap) {
        if (id != null) {
            modelMap.put("socialsecurity", socialsecurityService.queryById(id));
        }
        return "socialsecurity/saveUpdatePage";
    }


}
