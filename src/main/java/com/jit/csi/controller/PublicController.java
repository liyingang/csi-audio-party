package com.jit.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:50
 */
@Controller
public class PublicController {
    @GetMapping("/login")
    public String toLogin(){
        return "login";
    }




}
