package com.own.grocery.test2.controller;

import com.own.grocery.test2.application.StudentApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentApplication studentApplication;

    @RequestMapping("detail")
    public String detail(){
        return studentApplication.getStudent().toString();
    }

    @RequestMapping("detail2")
    public String detail2(){
        return studentApplication.getStudent2().toString();
    }
}
