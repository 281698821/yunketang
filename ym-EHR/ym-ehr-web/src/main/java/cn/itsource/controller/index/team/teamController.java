package cn.itsource.controller.index.team;

import cn.itsource.common.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/team")
public class teamController extends BaseController {


    @RequestMapping("/index")
    public String teamList(){
        return "redirect:/module/team/team.jsp";
    }
}
