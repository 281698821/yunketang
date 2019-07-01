package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.ResponseAPI;
import cn.itsource.excel.RewardPunishExcel;
import cn.itsource.model.Emp;
import cn.itsource.model.RewardPunish;
import cn.itsource.service.EmpService;
import cn.itsource.service.RewardPunishService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rewardPunishController")
public class RewardPunishController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    protected ResponseAPI responseAPI;

    @Autowired
    private EmpService empService;

    @Autowired
    private RewardPunishService rewardPunishService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap){
        return "rewardPunish/list";
    }

    @RequestMapping("/ajaxList")
    @ResponseBody
    public String ajaxList(Integer page, Integer limit, RewardPunish rewardPunish) {
        PageTable<List<RewardPunish>> pageTable = new PageTable<List<RewardPunish>>();
        rewardPunish.setLogictodelete(WebConstant.NODELETECODE);
        PageInfo<RewardPunish> pageInfo = rewardPunishService.queryPageListByParam(page, limit, rewardPunish);
        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());
        System.out.println(responseAPI+"------------------------------");
        return responseAPI.getJsonString(pageTable);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(RewardPunish rewardPunish) {

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (rewardPunish.getId() != null) {
            rewardPunish.setLogictodelete(WebConstant.DELETECODE);
            rewardPunishService.updateDelete(rewardPunish);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("删除成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }
    @RequestMapping("/saveUpdatePage")
    public String saveUpdatePage(Integer id, ModelMap modelMap) {
        if (id != null) {
            modelMap.put("rewardPunish", rewardPunishService.queryById(id));
        }
        return "rewardPunish/saveUpdatePage";
    }

    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(RewardPunish rewardPunish) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (rewardPunish.getId() != null) {
            rewardPunishService.updateNoNull(rewardPunish);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {
            rewardPunish.setLogictodelete(1);
            rewardPunishService.insert(rewardPunish);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("添加成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }


    @RequestMapping("/deletes")
    @ResponseBody
    public String  deletes(String ids) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "批量删除失败");
        if (!StringUtils.isEmpty(ids)) {
            String[] idss = ids.split(",");
            for (int i=0;i<idss.length;i++){

                RewardPunish rewardPunish = rewardPunishService.queryById(Integer.valueOf(idss[i]));
                rewardPunish.setLogictodelete(WebConstant.DELETECODE);
                rewardPunishService.updateDelete(rewardPunish);
            }

            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("批量删除成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }


    @RequestMapping("/export")
    public void export(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        List<RewardPunish> list = rewardPunishService.queryAllList();
        List<RewardPunishExcel> listExcel = new ArrayList<RewardPunishExcel>();
        for (RewardPunish rewardPunish : list) {
            RewardPunishExcel rewardPunishExcel = new RewardPunishExcel();
            System.out.println(rewardPunishExcel);
            BeanUtils.copyProperties(rewardPunish, rewardPunishExcel);
            listExcel.add(rewardPunishExcel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, RewardPunishExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "用户信息"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    @RequestMapping("/getName")
    @ResponseBody
    public Map getEmp(Integer id) {
        Map<String, Object> map = new HashMap<>();
        if (id != null) {
            Emp emp = empService.queryById(id);
            if (emp!=null){
                map.put("name", emp.getName());
                map.put("msg", "success");
            }else {
                map.put("name", "该用户不存在");
            }
        }
        return map;
    }
}
