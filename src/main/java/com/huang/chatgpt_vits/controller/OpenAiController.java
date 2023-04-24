package com.huang.chatgpt_vits.controller;

import com.huang.chatgpt_vits.dto.OpenAiDto;
import com.huang.chatgpt_vits.service.MessageService;
import com.huang.chatgpt_vits.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "openai")
@RestController
@CrossOrigin
public class OpenAiController {


    private MessageService messageService;

    @Autowired
    public OpenAiController(MessageService messageService) {
        this.messageService = messageService;
    }

    @ApiOperation("发送msg")
    @PostMapping("/sendMsg")
    private Result sendMsg(@RequestBody OpenAiDto openAiDto, HttpServletRequest httpServletRequest) {
        String text = openAiDto.getContent();
        if (text == null || text.length() == 0) {
            return new Result(200, "消息不合格", null);
        }
        String content = messageService.sendMsg(openAiDto, openAiDto.getDiaId(), openAiDto.getRole());
        if (content != null) {
            return new Result(200,"YES",content);
        }
        return new Result(200,"NO",null);
    }
}
