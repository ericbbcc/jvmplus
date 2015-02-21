package com.jvmplus.front.controller;

import com.jvmplus.service.IUserService;
import com.jvmplus.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


/**
 * Created by andy on 2/22/15.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("add")
    public String add(){
        User user = new User();
        user.setUserId("111111");
        user.setNickName("doc");
        userService.add(user);
        return "";
    }

}
