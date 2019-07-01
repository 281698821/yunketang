package cn.itsource.controller.index;

import cn.itsource.common.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class indexController extends BaseController {

    /**
     * 代号:隐无为
     * 文件名：LoginController.java
     * 修改人：
     * 描述：
     */
    /*首页*/
    @RequestMapping("/index")
    public String index() {
        return "redirect:/index.jsp";
    }

    /*视频页*/
    @RequestMapping("/video")
    public String video(){
        return "redirect:/src/video/videos.jsp";
    }

    //后台页面
    @RequestMapping("/admin")
    public String main(){
        return "redirect:/adminLogin.jsp";
    }

    @RequestMapping("/loginPage")
    public String loginPagedvo() {
        return "redirect:/loginPage.jsp";
    }



}
