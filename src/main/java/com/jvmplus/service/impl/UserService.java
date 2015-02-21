package com.jvmplus.service.impl;

import com.jvmplus.dao.UserMapper;
import com.jvmplus.service.IUserService;
import com.jvmplus.vo.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by andy on 2/22/15.
 */
@Component
public class UserService implements IUserService{

    @Resource(name="userDao")
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }
}
