package com.jit.csi.mapper;

import com.jit.csi.pojo.User;

import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 11:58
 */
public interface UserMapper {

    User findUserByUserName(String username);

    Integer insertUser(User user);

    String getPasswordByUserName(String username);

    Integer updateUserByUserName(User user);

    List<User> findAllUser();

    Integer deleteUserByUserName(String username);
}
