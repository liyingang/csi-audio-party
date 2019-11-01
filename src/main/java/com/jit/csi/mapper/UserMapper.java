package com.jit.csi.mapper;

import com.jit.csi.pojo.User;

import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 11:58
 */
public interface UserMapper {
    List<User> findAllUser();

    User findUserByUserName(String username);

    User findUserByUserId(Integer userId);

    Integer insertUser(User user);

    String getPasswordByUserName(String username);

    Integer updateUserByUserName(User user);

    Integer deleteUserByUserName(String username);
}
