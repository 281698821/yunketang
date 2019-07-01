package cn.itsource.controller.index.video;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/video")
public class videoController {

    @RequestMapping("list")
    public String teamList(){
        return "";
    }
}
