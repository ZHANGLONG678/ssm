package com.cs.ssm;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cs on 2017/5/12.
 */
public class Test {
    @org.junit.Test
    public void test1(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        System.out.println(sdf.format(new Date()));
    }
}
