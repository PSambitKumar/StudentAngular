package com.csm.Controller;

import com.csm.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping(value = "/createUser")
	public String createUser(Model model){
		model.addAttribute("userModel", new User());
		return "CreateUser";
	}

}
