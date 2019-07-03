package cn.itsource.controller.index.teacher;

import cn.itsource.common.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class teacherController extends BaseController {

    /*老师信息列表*/
    @RequestMapping("list")
    public String teacherList(){
        return "redirect:/module/video/videoslistclass.jsp";
    }


}
