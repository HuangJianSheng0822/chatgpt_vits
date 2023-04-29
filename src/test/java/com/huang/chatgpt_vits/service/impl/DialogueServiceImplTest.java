package com.huang.chatgpt_vits.service.impl;

import com.huang.chatgpt_vits.dto.DialogueDto;
import com.huang.chatgpt_vits.service.DialogueService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DialogueServiceImplTest {

    @Autowired
    private DialogueService dialogueService;

    @Test
    void addDialogue() {

        System.out.println(dialogueService.addDialogue("t1", "d1", "u1"));
    }

    @Test
    void delDialogue() {
        DialogueDto dto = new DialogueDto();
        dto.setTitle("t1");
        dto.setDesc("d1");
        dto.setDiaId("");
        System.out.println(dialogueService.delDialogue("16500359232586241"));
    }

    @Test
    void updateDialogue() {
        DialogueDto dto = new DialogueDto();
        dto.setTitle("test");
        dto.setDesc("test");
        dto.setDiaId("16500359232586241");
        System.out.println(dialogueService.updateDialogue(dto));
    }

    @Test
    void getDialogueByUserId() {
        System.out.println(dialogueService.getDialogueByUserId("1"));
    }
}