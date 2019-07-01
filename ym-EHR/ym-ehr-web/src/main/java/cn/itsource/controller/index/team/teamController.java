package cn.itsource.controller.index.team;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/team")
public class teamController {


    @RequestMapping("/list")
    public String teamList(){
        return null;
    }
}
