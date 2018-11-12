package com.own.grocery.test.controller;

import com.own.grocery.test.application.UserApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserApplication userApplication;

    @RequestMapping("detail")
    public String detail(){
        log.info("it's user.detail log");
        return userApplication.getUser().toString();
    }

    @RequestMapping("detail2")
    public String detail2(){
        log.info("it's user.detail2 log");
        return userApplication.getUser2().toString();
    }

    @RequestMapping("detail3")
    public String detail3(){
        log.info("it's user.detail3 log");
        return "detail 13 ====";
    }
}
