package com.jit.csi.service;

import com.jit.csi.mapper.UserMapper;
import com.jit.csi.pojo.User;

import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:46
 */
public interface UserService {


    public Integer register(User user);

    public User findUserByUserName(String userName);
    public User findUserByUserId(Integer userId);

    public User checkPassword(String username,String password);

    public Integer changePass(User user);

    public Integer updateUser(User user);

    List<User> findAllUser();

    Integer deleteUserByUserName(String userName);
}
