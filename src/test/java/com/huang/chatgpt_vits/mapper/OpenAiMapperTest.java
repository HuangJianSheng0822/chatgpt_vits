package com.huang.chatgpt_vits.mapper;


import io.swagger.annotations.ApiModelProperty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;


@SpringBootTest
class OpenAiMapperTest {

    @Autowired
    private OpenAiMapper openAiMapper;

    @Test
    void getMessages() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("daiId", "1");
        map.put("role", "user");
        System.out.println(openAiMapper.getMessages(map));
    }
}