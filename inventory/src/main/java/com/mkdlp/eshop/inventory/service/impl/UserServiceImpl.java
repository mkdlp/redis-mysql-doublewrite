package com.mkdlp.eshop.inventory.service.impl;

import com.mkdlp.eshop.inventory.mapper.UserMapper;
import com.mkdlp.eshop.inventory.model.User;
import com.mkdlp.eshop.inventory.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> findUserInfo() {
        return userMapper.findUserInfo();
    }
}
