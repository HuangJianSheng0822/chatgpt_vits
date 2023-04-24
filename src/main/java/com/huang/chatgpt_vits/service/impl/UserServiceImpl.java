package com.huang.chatgpt_vits.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.chatgpt_vits.mapper.UserMapper;
import com.huang.chatgpt_vits.pojo.User;
import com.huang.chatgpt_vits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(User user) {
        boolean flag = false;
        User sqlUser = userMapper.selectById(user.getEmail());
        if (sqlUser != null) {
            if (user.getPwd().equals(sqlUser.getPwd())) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean register(User user) {
        boolean flag = false;
        //查询用户是否存在
        User sqlUser = userMapper.selectById(user.getEmail());
        if (sqlUser == null) {
            flag = userMapper.insert(user) > 0;
        }
        return flag;
    }
}
