/**
 * 代号:隐无为
 * 文件名：TalentpoolController.java
 * 修改人：
 * 描述：
 */
package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.base.controller.BaseController;
import cn.itsource.dao.TalentpoolDao;
import cn.itsource.excel.TalentpoolExcel;
import cn.itsource.model.Talentpool;
import cn.itsource.service.TalentpoolService;
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
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 用途：业务模块名称
 * 代号：隐无为
 */
@Controller
@RequestMapping("/talentpoolController")
public class TalentpoolController extends BaseController {
    // 日志对象
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TalentpoolService talentpoolService;

    //注入邮件的工具类
    @Autowired
    EmailUtills emailUtills;

    /**
     * 功能: 列表页面
     * 代号: 隐无为
     */
    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        logger.info("===============进入列表页面==================");
        return "talentpool/list";
    }

    /**
     * 功能: 保存或修改页面
     * 代号: 隐无为
     */
    @RequestMapping("/saveUpdatePage")
    public String saveUpdatePage(Integer id, ModelMap modelMap) {
        if (id != null) {
            modelMap.put("talentpool", talentpoolService.queryById(id));
        }
        return "talentpool/saveUpdatePage";
    }

    /**
     * 功能: ajax-获取列表数据
     * 代号: 隐无为
     */
    @RequestMapping("/ajaxList")
    @ResponseBody
    public String ajaxList(Integer page, Integer limit,Talentpool talentpool) {
        PageTable<List<Talentpool>> pageTable = new PageTable<List<Talentpool>>();
        //talentpool.setDelFlag(WebConstant.NODELETECODE);
        PageInfo<Talentpool> pageInfo = talentpoolService.queryPageListByParam(page, limit, talentpool);
        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());

        return responseAPI.getJsonString(pageTable);

    }


    /**
     * 功能: 保存或修改操作
     * 代号: 隐无为
     */
    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(Talentpool talentpool) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (talentpool.getId() != null) {
            talentpoolService.updateNoNull(talentpool);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {
            //talentpool.setDelFlag(1);
            talentpoolService.insert(talentpool);
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
    public String delete(Talentpool talentpool) {

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (talentpool.getId() != null) {
            //招聘信息发布表没有状态，无法进行假删除,直接真删除
            //talentpool.setDelFlag(WebConstant.DELETECODE);
            talentpoolService.delete(talentpool);
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
            talentpoolService.deleteByIds(ids);
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
        List<Talentpool> list = talentpoolService.queryAllList();
        List<TalentpoolExcel> listExcel = new ArrayList<TalentpoolExcel>();
        for (Talentpool talentpool : list) {
            TalentpoolExcel talentpoolExcel = new TalentpoolExcel();
            BeanUtils.copyProperties(talentpool, talentpoolExcel);
            listExcel.add(talentpoolExcel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, TalentpoolExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "人才储备信息"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    /*
    * 功能：发送邮件
    * */
    @RequestMapping("/offer")
    @ResponseBody
    public void offer(String ids){
            String str="";
            String title="";
            JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "发送失败");
            if (!StringUtils.isEmpty(ids)) {
                //根据ids在数据库中查询数据
                List<Talentpool> talentpools = talentpoolService.queryByIds(ids);
                for (Talentpool e : talentpools) {
                    str="恭喜："+e.getName()+"<hr> 成功加入："+e.getAsthecompany()+"<br> 的大家庭！！！";
                    title = "offer发送";

                    //发送给邮件给表单上添加的邮件
                    emailUtills.sendHtmlMail(e.getEmail(),title,str);
                }
            }
                //发送邮件到指定的账户
                //emailUtills.sendHtmlMail("2990226486@qq.com","aaa","qqq");

                jsonReturnData.setCode(WebConstant.SUCCESSCODE);
                jsonReturnData.setMsg("发送成功");
    }

    //功能：模糊查询
    @RequestMapping("/findName")
    @ResponseBody
    public void findName(Integer id) {

    }

}
