package com.huang.chatgpt_vits.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.chatgpt_vits.dto.DialogueDto;
import com.huang.chatgpt_vits.mapper.DialogueMapper;
import com.huang.chatgpt_vits.pojo.Dialogue;

import java.util.List;

public interface DialogueService extends IService<Dialogue> {


    String addDialogue(String title, String desc, String userId);

    boolean delDialogue(String diaId);

    boolean updateDialogue(DialogueDto dialogueDto);

    List<DialogueDto> getDialogueByUserId(String userId);

}
