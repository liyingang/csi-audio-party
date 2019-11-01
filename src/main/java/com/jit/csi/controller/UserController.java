package com.jit.csi.controller;

import com.jit.csi.pojo.User;
import com.jit.csi.service.UserService;
import com.jit.csi.util.FileUtil;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:49
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request){
        User user=userService.checkPassword(username,password);
        if(user==null){
            request.setAttribute("msg","用户名或密码错误，请重试！");
            return "login.html";
        }else if(user.getLogin()!=0){
            request.setAttribute("msg","您已经在线");
            return "login.html";
        }
        else{
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

    @PostMapping("changePass")
    @ResponseBody
    public Integer changPass(String password,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        User newUser=new User();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(password);
        return userService.changePass(newUser);
    }

    @GetMapping("user")
    @ResponseBody
    public User findUser(HttpServletRequest request){
        return (User) request.getSession().getAttribute("user");
    }

    @PutMapping("user")
    @ResponseBody
    public Integer updateUser(User user){
        return userService.updateUser(user);
    }

    @PostMapping("photo")
    @ResponseBody
    public Integer uploadPhoto(String file,HttpSession session){
        User user= (User) session.getAttribute("user");
        String name=this.getClass().getClassLoader().getResource("static").getPath()+"/photo/"+user.getUserID()+".jpg";
        int flag=FileUtil.uploadPhoto(file,name);
        if(flag==1){
            user.setRegPhoto("/photo/"+user.getUserID()+".jpg");
            return userService.updateUser(user);
        }
        return 0;
    }




}
