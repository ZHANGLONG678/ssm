package com.cs.ssm.dao;

import com.cs.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    boolean insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User findUserByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);

    List<User> select2();

    List<User> dynamicSelect(@Param("tableName") String tableName);

    int createNewTable(@Param("tableName") String tableName);
    int dropTable(@Param("tableName") String tableName);
    int existTable(String tableName);

}