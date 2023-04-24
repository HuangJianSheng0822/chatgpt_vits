package com.huang.chatgpt_vits.controller;


import com.huang.chatgpt_vits.dto.LoginDto;
import com.huang.chatgpt_vits.pojo.User;
import com.huang.chatgpt_vits.service.UserService;
import com.huang.chatgpt_vits.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api("用户相关")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    Result login(@RequestBody LoginDto user, HttpServletRequest req) {
        req.getSession().setAttribute("userId", user.getEmail());
        User temp = new User();
        temp.setEmail(user.getEmail());
        temp.setPwd(user.getPwd());

        boolean login = userService.login(temp);
        if (login) {
            return new Result(200, "success", "YES");
        } else {
            return new Result(200, "登录失败", "NO");
        }
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    Result register(@RequestParam("email") String email, @RequestParam("pwd") String pwd, @RequestParam("code") String code, HttpServletRequest req) {
        String sessionCode = (String) req.getSession().getAttribute("code");
        if (sessionCode.equals(code)) {

            User temp = new User();
            temp.setEmail(email);
            temp.setPwd(pwd);

            boolean register = userService.register(temp);
            if (register) {
                return new Result(200, "success", "YES");
            } else {
                return new Result(200, "注册失败", "NO");
            }
        } else {
            return new Result(200, "验证码错误", "NO");
        }

    }


}
