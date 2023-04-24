package com.huang.chatgpt_vits.controller;

import com.huang.chatgpt_vits.service.MailService;
import com.huang.chatgpt_vits.util.VerCodeGenerateUtil;
import com.huang.chatgpt_vits.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "mail相关")
@RestController
public class MailController {


    MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @ApiOperation("邮件发送")
    @ApiImplicitParam(name = "email", value = "邮箱")
    @PostMapping("/code")
    Result sendCode(String email, HttpServletRequest req) {
        String code = VerCodeGenerateUtil.generateVerCode();
        req.getSession().setAttribute("code", code);
        boolean reg = mailService.sendSimpleCode(email, "REG", code);
        System.out.println(code);
        System.out.println("session1:" + req.getSession().getAttribute("code"));
        return new Result(200, null, reg);
    }
}
