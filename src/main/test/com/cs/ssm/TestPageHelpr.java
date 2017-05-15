package com.cs.ssm;

import com.cs.ssm.pojo.User;
import com.cs.ssm.service.UserService;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by cs on 2017/4/26.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)   //测试运行器
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})   //加载配置文件
public class TestPageHelpr {
    @Autowired
    private UserService userService;
    @Test
    public void test(){
        PageHelper.startPage(2, 20); // 核心分页代码
        List<User> users = (List<User>) userService.findAll();
        for (User user: users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void test2(){
        List<User> users = (List<User>) userService.find2();
        for (User user: users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void test3(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String tableName = "user_" + sdf.format(new Date());
        System.out.println(tableName);
        List<User> users = (List<User>) userService.dynamicFind(tableName);
        for (User user: users) {
            System.out.println(user.toString());
        }
    }

}
