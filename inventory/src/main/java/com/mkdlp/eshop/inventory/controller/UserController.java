package com.mkdlp.eshop.inventory.controller;

import com.mkdlp.eshop.inventory.model.User;
import com.mkdlp.eshop.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public List<User> findUserInfo(){
        return userService.findUserInfo();
    }
}
