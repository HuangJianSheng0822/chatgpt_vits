package com.huang.chatgpt_vits.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenAiServiceImplTest {

    @Autowired
    MessageServiceImpl openAiServiceImpl;

    @Test
    void getMessages() {
    }
}