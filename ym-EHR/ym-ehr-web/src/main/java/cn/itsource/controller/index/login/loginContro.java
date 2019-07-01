package cn.itsource.controller.index.login;

import cn.itsource.common.base.controller.BaseController;
import cn.itsource.model.Emp;
import cn.itsource.service.EmpService;
import cn.itsource.service.UserService;
import cn.itsource.utils.JsonReturnData;
import cn.itsource.utils.WebConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class loginContro extends BaseController {
    @Autowired
    UserService userService;
    @Autowired
    EmpService empService;
    /*前端登录登录*/
    @RequestMapping("/loginCon")
    @ResponseBody
    public String loginContro(Emp emp, HttpServletRequest request) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "登录失败");
        Emp u = empService.queryByParam(emp);
        if (u != null) {
            request.getSession().setAttribute("EMP_IN_SESSION", u);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("登录成功");
        }
        return  responseAPI.getJsonString(jsonReturnData);
    }


}
