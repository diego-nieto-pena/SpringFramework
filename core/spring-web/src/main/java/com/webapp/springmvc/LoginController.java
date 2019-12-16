package com.webapp.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping(value="/login")
	public String showLoginPage() {
		return "welcome";
	}
	
	/*@RequestMapping(value="/login", method=RequestMethod.POST)
	public String handleLoginRequest() {
		return "welcome";
	}*/
}
