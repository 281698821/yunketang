/**
 * 代号:隐无为
 * 文件名：LoginController.java
 * 修改人：
 * 描述：
 */
package cn.itsource.controller;


import cn.itsource.model.Emp;
import cn.itsource.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itsource.common.base.controller.BaseController;
import cn.itsource.model.User;
import cn.itsource.service.UserService;
import cn.itsource.utils.JsonReturnData;
import cn.itsource.utils.WebConstant;

import javax.servlet.http.HttpServletRequest;

/**
 * 用途：登录模块
 */
@Controller
@RequestMapping("/loginController")
public class LoginController extends BaseController {


	@Autowired
	UserService userService;
	@Autowired
	EmpService empService;

	@RequestMapping("/loginPage")
	public String loginPage() {
		return "loginPage";
	}

	@RequestMapping("/loginCheck")
	@ResponseBody
	public String loginCheck(Emp emp, HttpServletRequest request) {
		JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "登录失败");
		Emp u = empService.queryByParam(emp);
		if (u != null) {
			request.getSession().setAttribute("EMP_IN_SESSION", u);
			jsonReturnData.setCode(WebConstant.SUCCESSCODE);
			jsonReturnData.setMsg("登录成功");
		} 
		return  responseAPI.getJsonString(jsonReturnData);
	}

	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("EMP_IN_SESSION");
		return "forward:/loginController/loginPage";

	}

}
