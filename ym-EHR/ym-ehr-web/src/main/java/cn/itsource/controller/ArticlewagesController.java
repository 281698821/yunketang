package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.base.controller.BaseController;
import cn.itsource.excel.ArticlewagesExcel;
import cn.itsource.model.Articlewages;
import cn.itsource.service.ArticlewagesService;
import cn.itsource.utils.EmailUtills;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/articlewages")
public class ArticlewagesController extends BaseController {
    // 日志对象
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ArticlewagesService articlewagesService;
    @Autowired
    private EmailUtills emailUtills;
    @RequestMapping("/list")
    public String list(Model model){
        logger.info("===============进入列表页面==================");
        return "articlewages/list";
    }
    @RequestMapping("/ajaxList")
    @ResponseBody
    public String ajaxList(Integer page, Integer limit, Articlewages articlewages) {
        PageTable<List<Articlewages>> pageTable = new PageTable<List<Articlewages>>();
        articlewages.setLogictodelete(WebConstant.NODELETECODE);
        PageInfo<Articlewages> pageInfo = articlewagesService.queryPageListByParam(page, limit, articlewages);
        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());
        return responseAPI.getJsonString(pageTable);
    }
    @RequestMapping("/findall")
    @ResponseBody
    public Object findall(Integer page, Integer limit){
        PageTable<List<Articlewages>> pageTable = new PageTable<List<Articlewages>>();
        PageInfo<Articlewages> pageInfo = articlewagesService.queryAll(page, limit);
        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(21L);
        return responseAPI.getJsonString(pageTable);
    }
    @RequestMapping("/saveUpdatePage")
    public String saveUpdatePage(Integer id, ModelMap modelMap) {
        if (id != null) {
            modelMap.put("paygrades", articlewagesService.queryById(id));
        }
        return "articlewages/saveUpdatePage";
    }

    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(Articlewages articlewages) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (articlewages.getId() != null) {
            articlewagesService.updateNoNull(articlewages);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {
            articlewages.setLogictodelete(1);
            articlewagesService.insert(articlewages);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("添加成功");
        }
        return responseAPI.getJsonString(jsonReturnData);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Articlewages articlewages) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (articlewages.getId() != null) {
            articlewages.setLogictodelete(WebConstant.DELETECODE);
            articlewagesService.updateDelete(articlewages);
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
            articlewagesService.updateDeletes(ids);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("批量删除成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }
    //这个还没做
    @RequestMapping("/export")
    public void export(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        List<Articlewages> list = articlewagesService.queryAllList();
        List<ArticlewagesExcel> listExcel = new ArrayList<ArticlewagesExcel>();
        for (Articlewages articlewages : list) {
            ArticlewagesExcel articlewagesExcel = new ArticlewagesExcel();
            BeanUtils.copyProperties(articlewages, articlewagesExcel);
            listExcel.add(articlewagesExcel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, Articlewages.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "薪资登记表"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @RequestMapping("/sent")
    @ResponseBody
    public Map<String,Object> sent(){
        Map<String,Object> map = new HashMap<>();
        List<Articlewages> articlewages = articlewagesService.findbyname();
        articlewages.forEach(e->{
            if(e.getEmp().getEmail()!=null&&!e.getEmp().getEmail().equals("")) {
                String html = "<table border=\"1\">\n" +
                        "\t\t\t<tr>\n" +
                        "\t\t\t\t<th>编号</th>\n" +
                        "\t\t\t\t<th>姓名</th>\n" +
                        "\t\t\t\t<th>应发工资</th>\n" +
                        "\t\t\t\t<th>奖金</th>\n" +
                        "\t\t\t\t<th>罚款</th>\n" +
                        "\t\t\t\t<th>投保</th>\n" +
                        "\t\t\t\t<th>发放时间</th>\n" +
                        "\t\t\t\t<th>实发工资</th>\n" +
                        "\t\t\t</tr>\n" +
                        "\t\t\t<tr>\n" +
                        "\t\t\t\t<td>" + e.getId() + "</td>\n" +
                        "\t\t\t\t<td>" + e.getEmp().getName() + "</td>\n" +
                        "\t\t\t\t<td>" + e.getShouldsend() + "</td>\n" +
                        "\t\t\t\t<td>" + e.getBonus() + "</td>\n" +
                        "\t\t\t\t<td>" + e.getFine() + "</td>\n" +
                        "\t\t\t\t<td>" + e.getInsured() + "</td>\n" +
                        "\t\t\t\t<td>" + e.getTime() + "</td>\n" +
                        "\t\t\t\t<td>" + e.getRealhair() + "</td>\n" +
                        "\t\t\t</tr>\n" +
                        "\t\t</table>";
                emailUtills.sendHtmlMail(e.getEmp().getEmail(), "工资条", html);
            }
        });
        map.put("success", true);
        return map;
    }
}
