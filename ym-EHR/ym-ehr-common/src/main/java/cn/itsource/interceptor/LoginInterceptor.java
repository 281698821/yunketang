package cn.itsource.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用途：登录拦截
 */
public class LoginInterceptor implements HandlerInterceptor{

	 // 不拦截的controller名称地址
	 String[] noInterceptArray = {"/error","/loginController/loginUI", "/loginController/loginCheck" };
	

    // Handler执行完成之后调用这个方法     //全部完成后处理

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

    // Handler执行之后，ModelAndView返回之前调用这个方法  //拦截后处理
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

     //Handler执行之前调用这个方法
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  Object handler) throws Exception {
		//获取请求的URL  
        String url = request.getRequestURI();
        // 如果是不拦截url地址  就放行
        for (int i = 0; i < noInterceptArray.length; i++) {
        	   if(url.indexOf(noInterceptArray[i])>-1){  
                    return true;  
               } 
		}
       // System.out.println("=====================登录拦截==============================="+url);
        //获取Session  
		return true;
	}
}
