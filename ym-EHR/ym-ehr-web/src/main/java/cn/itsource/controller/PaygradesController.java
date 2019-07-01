package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.base.controller.BaseController;
import cn.itsource.excel.PaygradesExcel;
import cn.itsource.model.Paygrades;
import cn.itsource.service.PaygradesService;
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
@RequestMapping("/paygrades")
public class PaygradesController extends BaseController{
    // 日志对象
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PaygradesService paygradesService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        logger.info("===============进入列表页面==================");
        return "paygrades/list";
    }

    @RequestMapping("/saveUpdatePage")
    public String saveUpdatePage(Integer id, ModelMap modelMap) {
        if (id != null) {
            modelMap.put("paygrades", paygradesService.queryById(id));
        }
        return "paygrades/saveUpdatePage";
    }

    @RequestMapping("/ajaxList")
    @ResponseBody
    public String ajaxList(Integer page, Integer limit,Paygrades paygrades) {
        PageTable<List<Paygrades>> pageTable = new PageTable<List<Paygrades>>();
        paygrades.setLogictodelete(WebConstant.NODELETECODE);
        PageInfo<Paygrades> pageInfo = paygradesService.queryPageListByParam(page, limit, paygrades);
        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());
        return responseAPI.getJsonString(pageTable);
    }

    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(Paygrades paygrades) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (paygrades.getId() != null) {
            paygradesService.updateNoNull(paygrades);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {
            paygrades.setLogictodelete(1);
            paygradesService.insert(paygrades);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("添加成功");
        }
        return responseAPI.getJsonString(jsonReturnData);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Paygrades paygrades) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (paygrades.getId() != null) {
            paygrades.setLogictodelete(WebConstant.DELETECODE);
            paygradesService.updateDelete(paygrades);
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
            paygradesService.updateDeletes(ids);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("批量删除成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }
    @RequestMapping("/export")
    public void export(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        List<Paygrades> list = paygradesService.queryAllList();
        List<PaygradesExcel> listExcel = new ArrayList<PaygradesExcel>();
        for (Paygrades paygrades : list) {
            PaygradesExcel paygradesExcel = new PaygradesExcel();
            BeanUtils.copyProperties(paygrades, paygradesExcel);
            listExcel.add(paygradesExcel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, PaygradesExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "薪资登记表"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

}
