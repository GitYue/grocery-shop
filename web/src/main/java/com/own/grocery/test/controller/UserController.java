package com.own.grocery.test.controller;

import com.own.grocery.test.application.UserApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserApplication userApplication;

    @RequestMapping("detail")
    public String detail(){
        return userApplication.getUser().toString();
    }

    @RequestMapping("detail2")
    public String detail2(){
        return userApplication.getUser2().toString();
    }
}
