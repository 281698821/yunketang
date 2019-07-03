package cn.itsource.controller.index.video;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/video")
public class videoController {


    /*课程中心*/
    @RequestMapping("/list")
    public String teamList(){
        return "redirect:/module/video/videoslistclass.jsp";
    }

    /*课程推荐*/
    @RequestMapping("/listhot")
    public String hotlist(){
        return "redirect:/module/video/videoshot.jsp";
    }
}
