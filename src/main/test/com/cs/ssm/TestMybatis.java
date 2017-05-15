package com.cs.ssm;

import com.cs.ssm.pojo.User;
import com.cs.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cs on 2017/4/26.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)   //测试运行器
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})   //加载配置文件
public class TestMybatis {
    @Autowired
    private UserService userService;

    @Test
    public void test() {
        System.err.println(userService.findUserByUsername("cs"));
    }

    @Test
    public void testAdd() {
        for(int i=0;i<50;i ++){
            User user = new User();
            user.setUsername("username" + i);
            user.setPassword("password" + i);
            user.setRoleId(1);
            userService.insert(user);
        }
    }

    @Test
    public void testCreate() {
        userService.createTable("test");
        System.out.println("create success!");
    }

}
