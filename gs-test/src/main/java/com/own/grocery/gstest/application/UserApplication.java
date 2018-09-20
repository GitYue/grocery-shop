package com.own.grocery.gstest.application;

import com.own.grocery.test.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(rollbackFor = Throwable.class, transactionManager = "testTransactionManager")
public class UserApplication {

    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setAge(22);
        return user;
    }
}
