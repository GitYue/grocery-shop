package com.own.grocery.test2.application;

import com.own.grocery.center.test2.domain.Student;
import com.own.grocery.center.test2.repository.StudentMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
@Transactional(rollbackFor = Throwable.class, transactionManager = "test2TransactionManager")
public class StudentApplication {

    @Resource
    private StudentMapper studentMapper;

    public Student getStudent(){
        Student detail = studentMapper.detail();
        return detail;
    }

    public Student getStudent2(){
        Student detail2 = new Student();
        detail2.setId(2);
        detail2.setName("stu2");
        detail2.setGrade(79);
        return detail2;
    }
}
