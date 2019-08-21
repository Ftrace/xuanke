package com.fyh.xuanke.controller;


import com.fyh.xuanke.model.User;
import com.fyh.xuanke.service.UserService;
import com.fyh.xuanke.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class RegisterController {


    private static Logger log = LoggerFactory.getLogger(RegisterController.class);
    @Autowired
    public UserService userService;
    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    public ModelAndView toRegister(ModelMap model){
        User user = new User();
        return new ModelAndView("register").addObject(user);

    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult){
       log.info("username="+user.getUsername()+";password="+user.getPassword());
       if(bindingResult.hasErrors()){
           return new ModelAndView("register");
       }
       String salt = "fyh";
       String newPassword = MD5Util.backToDb(user.getPassword(), "fyh");
       user.setId(2018);
       user.setPassword(newPassword);
       user.setDbflag(salt);
       userService.regist(user);
       return new ModelAndView("register");

    }

}
