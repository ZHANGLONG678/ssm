package com.cs.ssm.quartz;

import com.cs.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cs on 2017/5/15.
 */
public class Study {
    @Autowired
    private UserService userService;
    private static int i = 0;

    public void doStudy() {
        System.out.println("It is " + new Date());
    }

    public void doCreate() {
        i++;
     /*   SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String tableName = "user_" + sdf.format(new Date());*/
        String tableName = Integer.toString(i);
        System.out.println(tableName);
        userService.createTable("test" + tableName);
        System.out.println("create table " + tableName + " success!");
    }
}
