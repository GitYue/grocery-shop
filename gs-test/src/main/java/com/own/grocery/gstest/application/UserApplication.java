package com.own.grocery.gstest.application;

import com.own.grocery.center.test.domain.User;
import com.own.grocery.center.test.repository.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
@Transactional(rollbackFor = Throwable.class, transactionManager = "testTransactionManager")
public class UserApplication {

    @Resource
    private UserMapper userMapper;

    public User getUser(){
        User detail = userMapper.detail();
        return detail;
    }
}
