package ouer.caihe.maven.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(value = "/signined")
    public String signined(Model model) {
        return "index";
    }
	@RequestMapping(value = "/signin_fail")
    public String signinFail(Model model) {
        return "login";
    }
}
