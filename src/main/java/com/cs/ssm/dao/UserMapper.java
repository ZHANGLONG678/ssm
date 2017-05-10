package com.cs.ssm.dao;

import com.cs.ssm.pojo.User;
import java.util.Set;

public interface UserMapper {
    User findUserByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}