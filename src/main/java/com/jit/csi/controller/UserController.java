package com.jit.csi.controller;

import com.jit.csi.pojo.User;
import com.jit.csi.service.UserService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:49
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request){
        User user=userService.checkPassword(username,password);
        if(user==null){
            request.setAttribute("msg","用户名或密码错误，请重试！");
            return "login.html";
        }else{
            request.getSession().setAttribute("user",user);
            return"redirect:/menu.html";
        }
    }

    @PostMapping("register")
    @ResponseBody
    public Integer register(String userName,String password,String regSex,Integer regAge,String regEmail){
        User user=new User(userName,password,regAge,regSex,regEmail);
        return userService.register(user);
    }




}
