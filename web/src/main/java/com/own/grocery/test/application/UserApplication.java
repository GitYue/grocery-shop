package com.own.grocery.test.application;

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

    public User getUser2(){
        User detail2 = new User();
        detail2.setId(2);
        detail2.setName("two");
        detail2.setAge(22);
        return detail2;
    }
}
