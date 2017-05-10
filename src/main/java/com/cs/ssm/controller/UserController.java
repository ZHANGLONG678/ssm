package com.cs.ssm.controller;

import com.cs.ssm.pojo.User;
import com.cs.ssm.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;



/**
 * Created by cs on 2017/4/26.
 */
@Controller
//@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService ;

    @RequestMapping("/loginAdmin")
    public String login(User user, Model model){
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword()) ;
        try {
            subject.login(token);
            return "admin" ;
        }catch (Exception e){
            //这里将异常打印关闭是因为如果登录失败的话会自动抛异常
//            e.printStackTrace();
            model.addAttribute("error","用户名或密码错误") ;
            return "../../login" ;
        }
    }
    @RequestMapping(value = "/ajaxLogin",method = RequestMethod.POST)
        public String ajaxLogin(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject() ;
        System.out.println(user);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword()) ;
        try {
            subject.login(token);
            return "admin" ;
        }catch (Exception e){
            //这里将异常打印关闭是因为如果登录失败的话会自动抛异常
//            e.printStackTrace();
            //model.addAttribute("error","用户名或密码错误") ;
            System.out.println("login error");
            return "../../login" ;
        }
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/student")
    public String student(){
        return "admin" ;
    }

    @RequestMapping("/teacher")
    public String teacher(){
        return "admin" ;
    }

    @RequestMapping("/admin/getUser")
    @ResponseBody
    public User getUser() {
        System.out.println("-----请求json数据--------");
        return userService.findUserByUsername("xxx");

    }
}
