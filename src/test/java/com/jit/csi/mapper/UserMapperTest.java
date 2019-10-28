package com.jit.csi.mapper;

import com.jit.csi.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-28 - 9:06
 */
@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    public User createUser(String userName, String password, Integer regAge, String regSex, String regEmail){
        User user=new User();
        if (userName != null) {
            user.setUserName(userName);
        }if (password != null) {
            user.setPassword(password);
        }if (regAge != null) {
            user.setRegAge(regAge);
        }if (regSex != null) {
            user.setRegSex(regSex);
        }if (regEmail != null) {
            user.setRegEmail(regEmail);
        }
        return user;
    }

    @Test
    void findUserByUserName() {
        System.out.println(userMapper.findUserByUserName("test1"));
    }

    @Test
    void insertUser() {
        User user=createUser("test1","123456",23,
                "0","1209995335@qq.com");
        try {
            userMapper.insertUser(user);
        }catch (DataAccessException e){
            System.out.println("用户名已存在");
            System.out.println(-1);
        }

    }

    @Test
    void getPasswordByUserName() {
        System.out.println(userMapper.getPasswordByUserName("test1"));
    }

    @Test
    void updateUserByUserName() {
        User user=new User();
        user.setUserName("test1");
        user.setPassword("123");
        user.setAdmin("1");
        userMapper.updateUserByUserName(user);
        System.out.println(userMapper.findUserByUserName(user.getUserName()));
    }

    @Test
    void findAllUser() {
        System.out.println(userMapper.findAllUser());
    }

    @Test
    void deleteUserByUserName() {
        System.out.println(userMapper.deleteUserByUserName("test1"));
    }
}