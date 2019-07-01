package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.base.controller.BaseController;
import cn.itsource.excel.ReleasesExcel;
import cn.itsource.model.Channel;
import cn.itsource.model.Emp;
import cn.itsource.model.Releases;
import cn.itsource.service.ChannelService;
import cn.itsource.service.EmpService;
import cn.itsource.service.ReleasesService;
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
@RequestMapping("/releasesController")
public class ReleasesController extends BaseController {

    @Autowired
    ReleasesService releasesService;

    @Autowired
    ChannelService channelService;

    @Autowired
    EmpService empService;


    @RequestMapping("/list")
    public String list(ModelMap modelMap){
        return "releases/list";
    }

    /**
     * AJAX跟新列表
     */
    @RequestMapping("/ajaxList")
    @ResponseBody
    public String ajaxList(Integer page, Integer limit, Releases releases) {
        PageTable<List<Releases>> pageTable = new PageTable<List<Releases>>();
        releases.setLogictodelete(WebConstant.NODELETECODE);
        PageInfo<Releases> pageInfo = releasesService.queryPageListByParam(page, limit, releases);
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
            //如果id不为空，就根据id查询出一条数据，把发布管理对象存入modelMap，并把这条数据存入modelMap中，用于回显的时候取值
            modelMap.put("releases", releasesService.queryById(id));
        }

        //存入一个渠道对象到modelMap中
        List<Channel> channels = channelService.queryAllList();
        modelMap.put("channels", channels);
        //存入一个员工对象到modelMap中
        List<Emp> emps = empService.queryAllList();
        modelMap.put("emps", emps);

        return "releases/saveUpdatePage";


    }


    /**
     * 功能: 保存或修改操作
     * 代号: 隐无为
     */
    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(Releases releases) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (releases.getId() != null) {
            releasesService.updateNoNull(releases);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {
            //设置逻辑删除的值为1，因为在添加的时候，逻辑删除不可能是已经删除
            releases.setLogictodelete(1);
            releasesService.insert(releases);
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
    public String delete(Releases releases) {

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (releases.getId() != null) {
            releases.setLogictodelete(WebConstant.DELETECODE);
            releasesService.updateDelete(releases);
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
            releasesService.updateDeletes(ids);
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
        List<Releases> list = releasesService.queryAllList();
        List<ReleasesExcel> listExcel = new ArrayList<ReleasesExcel>();
        for (Releases releases : list) {
            ReleasesExcel releasesExcel = new ReleasesExcel();
            Emp emp = empService.queryById(releases.getEmpId());
            Channel channel = channelService.queryById(releases.getChannelId());

            if(releases.getEmpId()!=null &&releases.getEmpId()>0 && releases.getEmpId()<=6){
                String empName = emp.getName();
                releasesExcel.setEmpName(empName);
            }
            if(releases.getChannelId()!= null && releases.getChannelId()>0 && releases.getChannelId()<=8){
                String channelName = channel.getName();
                releasesExcel.setChanneName(channelName);
            }

            //把信息表与excel表格相同的字段拷贝到excel表格
            BeanUtils.copyProperties(releases, releasesExcel);

            listExcel.add(releasesExcel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, ReleasesExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "用户信息"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    //根据员工id获得员工的用户名
    @RequestMapping("/getEmpName")
    @ResponseBody
    public Emp getEmpName(Integer id){
        Emp emp = empService.queryById(id);
        return emp;
    }

    //根据id获得对应渠道的名称
    @RequestMapping("/getchannelName")
    @ResponseBody
    public Channel getChaName(Integer id){
        Channel channel = channelService.queryById(id);
        return channel;
    }
}
