package com.cs.ssm.service;

import com.cs.ssm.pojo.User;

import java.util.Set;

/**
 * Created by cs on 2017/4/26.
 */
public interface UserService {
    /**
     * Shiro的登录验证，通过用户名查询用户信息
     * @param username
     * @return
     */
    public User findUserByUsername(String username) ;

    /**
     * 根据账号查找角色名称
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) ;

    /**
     * 根据账号查找权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) ;

}
