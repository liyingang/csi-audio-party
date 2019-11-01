package com.jit.csi.service.impl;

import com.jit.csi.mapper.UserMapper;
import com.jit.csi.pojo.User;
import com.jit.csi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public Integer register(User user) {
        User tuser=userMapper.findUserByUserName(user.getUserName());
        if(tuser!=null){
            return -1; //名字已经被注册，返回-1
        }
        try {
           return  userMapper.insertUser(user);
        }catch (DataAccessException e){
            System.out.println("userService error line 30");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }

    @Override
    public User findUserByUserId(Integer userId) {
        return userMapper.findUserByUserId(userId);
    }

    @Override
    public User checkPassword(String username,String password) {
        User user=userMapper.findUserByUserName(username);
        if(user==null){
            return null;//用户名不存在
        }else if(user.getPassword().equals(password)){
            return user;
        }else{
            return null;//密码错误
        }
    }

    public Integer changePass(User user){
        return userMapper.updateUserByUserName(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUserByUserName(user);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public Integer deleteUserByUserName(String userName) {
        return userMapper.deleteUserByUserName(userName);
    }


}
