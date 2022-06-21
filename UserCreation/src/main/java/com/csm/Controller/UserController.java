package com.csm.Controller;

import com.csm.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@GetMapping(value = "/createUser")
	public String createUser(Model model){
		model.addAttribute("userModel", new User());
		return "CreateUser";
	}

	@PostMapping(value = "createUser")
	public String createUser(@ModelAttribute("userModel")User user){
		System.out.println("User : " + user);
		return "CreateUser";
	}

}
