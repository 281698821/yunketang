package cn.itsource.common.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itsource.common.ResponseAPI;
import cn.itsource.utils.JsonReturnData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
	@Autowired
	protected ResponseAPI responseAPI;

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String ERRORCODE = "500";


	/**
	 * 功能: 异常统一捕获
	 * 作者: 柯栋 @代号:隐无为
	 */
	@ExceptionHandler
	@ResponseBody
	public String exceptionProcess(HttpServletRequest request, HttpServletResponse response, RuntimeException ex) {
		JsonReturnData<String> jsonReturnData = new JsonReturnData<String>(500, "系统出错");
		ex.printStackTrace();
		return responseAPI.getJsonString(jsonReturnData);
	}
	
}
