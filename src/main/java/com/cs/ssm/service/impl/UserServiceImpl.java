package com.cs.ssm.service.impl;

import com.cs.ssm.dao.UserMapper;
import com.cs.ssm.pojo.User;
import com.cs.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * Created by cs on 2017/4/26.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        User user = userMapper.findUserByUsername(username);
        return user;
    }

    @Override
    public Set<String> findRoles(String username) {
        return userMapper.findRoles(username);
    }

    @Override
    public Set<String> findPermissions(String username) {
        return userMapper.findPermissions(username);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    @Transactional
    public int insert(User user) {
        if(userMapper.insert(user)){
            System.out.println("insert success");
            return 1;
        }
        return 0;
    }

    @Override
    public List<User> find2() {
        return userMapper.select2();
    }

    @Override
    public List<User> dynamicFind(String tableName) {
        return userMapper.dynamicSelect(tableName);
    }

    @Override
    public void createTable(String tableName) {
       /* if (userMapper.existTable(tableName) == 1) {
            userMapper.dropTable(tableName);
        }*/
        userMapper.createNewTable(tableName);
    }
}
