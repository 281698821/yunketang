/**
 * 代号:隐无为
 * 文件名：UserController.java
 * 修改人：
 * 描述：
 */
package cn.itsource.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.base.controller.BaseController;
import cn.itsource.excel.UserExcel;
import cn.itsource.model.User;
import cn.itsource.service.UserService;
import cn.itsource.utils.JsonReturnData;
import cn.itsource.utils.PageTable;
import cn.itsource.utils.WebConstant;

/**
 * 用途：业务模块名称
 * 代号：隐无为
 */
@Controller
@RequestMapping("/userController")
public class UserController extends BaseController {
    // 日志对象
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserService userService;

    /**
     * 功能: 列表页面
     * 代号: 隐无为
     */
    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
       // logger.info("===============进入列表页面==================");
        return "user/list";
    }

    /**
     * 功能: 保存或修改页面
     * 代号: 隐无为
     */
    @RequestMapping("/saveUpdatePage")
    public String saveUpdatePage(Integer id, ModelMap modelMap) {
        if (id != null) {
            modelMap.put("user", userService.queryById(id));
        }
        return "user/saveUpdatePage";
    }

    /**
     * 功能: ajax-获取列表数据
     * 代号: 隐无为
     */
    @RequestMapping("/ajaxList")
    @ResponseBody
    public String ajaxList(Integer page, Integer limit,User user) {
        PageTable<List<User>> pageTable = new PageTable<List<User>>();
        user.setDelFlag(WebConstant.NODELETECODE);
        PageInfo<User> pageInfo = userService.queryPageListByParam(page, limit, user);
        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());
       // System.out.println(responseAPI+"------------------------------");
        return responseAPI.getJsonString(pageTable);

    }


    /**
     * 功能: 保存或修改操作
     * 代号: 隐无为
     *
     */
    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(User user) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (user.getId() != null) {
            userService.updateNoNull(user);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {
            user.setDelFlag(1);
            userService.insert(user);
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
    public String delete(User user) {

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (user.getId() != null) {
            user.setDelFlag(WebConstant.DELETECODE);
            userService.updateDelete(user);
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
            userService.updateDeletes(ids);
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
        List<User> list = userService.queryAllList();
        List<UserExcel> listExcel = new ArrayList<UserExcel>();
        for (User user : list) {
            UserExcel userExcel = new UserExcel();
            BeanUtils.copyProperties(user, userExcel);
            listExcel.add(userExcel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, UserExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "用户信息"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

}
