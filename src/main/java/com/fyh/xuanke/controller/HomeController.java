package com.fyh.xuanke.controller;


import com.fyh.xuanke.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(Model model, User user){

        System.out.println("----------------------"+user.getUsername());
        model.addAttribute("user",new User());
        return "home";
    }
}
