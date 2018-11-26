package com.example.controller;

import com.example.service.LoginSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录逻辑跳转
 */
@Controller
public class LoginCtl {

    @Autowired
    LoginSer loginSer;

    @GetMapping("/mainPage")
    public String main(Model model){
        model.addAttribute("username","admin");
        System.out.println("激发页面跳转");
        return "index";
    }
}
