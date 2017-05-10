package com.cs.ssm;

import com.cs.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
