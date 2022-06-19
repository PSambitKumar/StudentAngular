package com.csm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping(value = "/createUser")
	public String createUser(){
		return "CreateUser";
	}

}
