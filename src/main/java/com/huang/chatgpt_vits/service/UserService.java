package com.huang.chatgpt_vits.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.chatgpt_vits.pojo.User;


public interface UserService extends IService<User> {
    boolean login(User user);

    boolean register(User user);
}
