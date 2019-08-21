package com.fyh.xuanke.controller;

import com.fyh.xuanke.model.User;
import com.fyh.xuanke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    public UserService userService;

//
//    @RequestMapping(value = "/register")
//    private  boolean register(){
//        User user1= new User("傅豪","123456");
//        userService.regist(user1);
//        return true;
//    }

//    @RequestMapping(value = "/find")
//    private  boolean find(String u,String p){
//
//        return userService.findUserByUsernameAndPassword(u,p);
//
//    }




}
