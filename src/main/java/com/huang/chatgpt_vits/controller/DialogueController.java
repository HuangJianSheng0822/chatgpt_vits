package com.huang.chatgpt_vits.controller;

import com.huang.chatgpt_vits.dto.DialogueDto;
import com.huang.chatgpt_vits.pojo.Dialogue;
import com.huang.chatgpt_vits.service.DialogueService;
import com.huang.chatgpt_vits.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(tags = "会话")
public class DialogueController {


    private DialogueService dialogueService;

    @Autowired
    public DialogueController(DialogueService dialogueService) {
        this.dialogueService = dialogueService;
    }

    @ApiOperation("添加会话")
    @PostMapping("/dia/add")
    private Result addDialogue(String title, String desc, HttpServletRequest req) {
        String userId = (String) req.getSession().getAttribute("userId");
        String diaId = dialogueService.addDialogue(title, desc, userId);
        return new Result(200, "OK", diaId);
    }

    @PostMapping("/dia/del")
    @ApiOperation("删除会话")
    Result delDialogue(String diaId) {
        boolean flog = dialogueService.delDialogue(diaId);
        return new Result(200, "OK", flog);
    }

    @ApiOperation("修改会话")
    @PostMapping("/dia/update")
    Result updateDialogue(DialogueDto dialogueDto) {
        boolean flog = dialogueService.updateDialogue(dialogueDto);
        return new Result(200, "OK", flog);
    }

    @ApiOperation("获得全部会话")
    @PostMapping("/dia/getAll")
    Result getDialogueByUserId(HttpServletRequest req) {
        String userId = (String) req.getSession().getAttribute("userId");
        List<DialogueDto> dialogueByUserId = dialogueService.getDialogueByUserId(userId);
        return new Result(200, "OK", dialogueByUserId);
    }
}
