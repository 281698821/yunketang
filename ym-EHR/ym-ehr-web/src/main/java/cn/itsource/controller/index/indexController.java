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
    public String videoindex(){
        return "redirect:/module/video/videose.jsp";
    }

    //后台页面
    @RequestMapping("/admin")
    public String mainindex(){
        return "redirect:/adminLogin.jsp";
    }

    @RequestMapping("/loginPage")
    public String loginPagedindex() {
        return "redirect:/loginPage.jsp";
    }

    @RequestMapping("/team")
    public String teamindex(){
        return "redirect:/module/team/team.jsp";
    }


}
