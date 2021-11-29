package com.sambit.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String main(){
        System.out.println("Sending you to maain page.");
        return "main";
    }

    @RequestMapping("/home")
    public String Home(){
//        System.out.println("Sending you to home page.");
        return "home";
    }

    @RequestMapping("/contact")
    public String Contact(){
//        System.out.println("Sending you to contact page.");
        return "contact";
    }
}
