package com.demo.userservice.web;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class PageController {
    @RequestMapping("/")
    public String root(){
        return "redirect:/index";
    }
    @RequestMapping("/index")
    public  String index(){
        return "index";
    }
    @RequestMapping("/register")
    public  String register(){
        return "register";
    }
    @RequestMapping("/login")
    public  String login(){
        return "login";
    }
}
