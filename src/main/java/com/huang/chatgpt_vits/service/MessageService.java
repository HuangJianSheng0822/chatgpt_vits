package com.huang.chatgpt_vits.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.chatgpt_vits.dto.OpenAiDto;
import com.huang.chatgpt_vits.pojo.Message;
import com.huang.chatgpt_vits.pojo.OpenAiResult;

public interface MessageService extends IService<Message> {
    String sendMsg(OpenAiDto openAiDto, String diaId, String role);
}
