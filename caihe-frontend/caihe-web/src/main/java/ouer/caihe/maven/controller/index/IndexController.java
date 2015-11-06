package ouer.caihe.maven.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ouer.caihe.maven.auth.model.User;

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
	
	@RequestMapping(value="/test1")
	@ResponseBody
	public String test(@ModelAttribute User user){
		System.out.println(user.getUsername());
		return "test";
	}
}
