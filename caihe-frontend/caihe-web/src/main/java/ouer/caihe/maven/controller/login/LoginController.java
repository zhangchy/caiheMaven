package ouer.caihe.maven.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class LoginController {
	@RequestMapping(value = "/login")
    public String productsPage(ModelMap model) {
        return "login";
    }
	
	@ResponseBody
	@RequestMapping(value = "/test")
    public String test(ModelMap model) {
        return "test";
    }
}
