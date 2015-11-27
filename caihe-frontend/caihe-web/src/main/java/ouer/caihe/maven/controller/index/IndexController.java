package ouer.caihe.maven.controller.index;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ouer.caihe.maven.auth.model.User;

@Controller
public class IndexController {
	@SuppressWarnings("unused")
	@RequestMapping(value = "/signined")
    public String signined(Model model) {
		model.addAttribute("test", "test");
		User user = new User();
		user.setAge(8);
		model.addAttribute("user",user);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar cal = Calendar.getInstance();
	    model.addAttribute("today", cal.getTime());
        return "index";
    }
	@RequestMapping(value = "/signin_fail")
    public String signinFail(Model model) {
        return "login";
    }
	@RequestMapping(value = "/signin_deny")
	@ResponseBody
    public String signinDeny(Model model) {
        return "deny";
    }
	
	@RequestMapping(value="/test1")
	@ResponseBody
	public String test(@ModelAttribute User user){
		System.out.println(user.getUsername());
		return "test";
	}
	
	@RequestMapping(value="/deny")
	public String test(){
		return "test";
	}
}
