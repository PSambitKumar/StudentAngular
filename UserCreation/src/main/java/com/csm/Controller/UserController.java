package com.csm.Controller;

import com.csm.Model.User;
import com.csm.Utils.CommonFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UserController {

	@GetMapping(value = "/createUser")
	public String createUser(Model model){
		model.addAttribute("userModel", new User());
		return "CreateUser";
	}

	@PostMapping(value = "createUser")
	public String createUser(@ModelAttribute("userModel")User user, @RequestParam("imageData")MultipartFile imageData) throws IOException {
		String filePath = CommonFileUpload.singleFileUplaod(imageData, user.getUserId());
		user.setImagePath(filePath);
		System.out.println("User Details : " + user);
		return "CreateUser";
	}

}
