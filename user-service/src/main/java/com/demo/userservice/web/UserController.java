package com.demo.userservice.web;

import com.demo.userservice.dto.UserLoginDTO;
import com.demo.userservice.entity.JWT;
import com.demo.userservice.entity.User;
import com.demo.userservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User postUser(@RequestParam("username") String username , @RequestParam("password") String password){
       return userService.insertUser(username,password);
    }


    @RequestMapping(value="/login", method = RequestMethod.POST)
    public void login(@RequestParam("username") String username , @RequestParam("password") String password , HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserLoginDTO dto= userService.login(username,password);
        JWT jwt =dto.getJwt();
        Cookie cookie = new Cookie("access_token",jwt.getAccess_token());
        cookie.setMaxAge(3600 * 24);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.sendRedirect("/index");
    }


}
