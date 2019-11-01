package com.jit.csi.controller;

import com.jit.csi.pojo.User;
import com.jit.csi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:50
 */
@Controller
public class PublicController {
    @Autowired
    UserService userService;






    @GetMapping("/logout")
    public String toLogout(HttpSession session){
        if(session!=null){
            User user= (User) session.getAttribute("user");
            user.setLogin(0);
            userService.updateUser(user);
            session.invalidate();
        }
        return "login";
    }


}
