package com.huang.chatgpt_vits.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.chatgpt_vits.dto.DialogueDto;
import com.huang.chatgpt_vits.mapper.DialogueMapper;
import com.huang.chatgpt_vits.pojo.Dialogue;
import com.huang.chatgpt_vits.service.DialogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DialogueServiceImpl extends ServiceImpl<DialogueMapper, Dialogue> implements DialogueService {

    private DialogueMapper dialogueMapper;

    @Autowired
    public DialogueServiceImpl(DialogueMapper dialogueMapper) {
        this.dialogueMapper = dialogueMapper;
    }

    //增加
    @Override
    public String addDialogue(String title, String desc, String userId) {
        int insert = dialogueMapper.insert(strToPo(title, desc, userId));
        Dialogue lastOne = dialogueMapper.getLastOne(userId);
        return lastOne.getDiaId();
    }

    //删除
    @Override
    public boolean delDialogue(String diaId) {
        int i = dialogueMapper.deleteById(diaId);
        return i > 0;
    }

    //修改
    @Override
    public boolean updateDialogue(DialogueDto dialogueDto) {
        int i = dialogueMapper.updateById(dtoToPo(dialogueDto));
        return i > 0;
    }

    //查询
    @Override
    public List<DialogueDto> getDialogueByUserId(String userId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        List<Dialogue> dialogues = dialogueMapper.selectByMap(map);
        ArrayList<DialogueDto> dtos = new ArrayList<>();
        for (int i = 0; i < dialogues.size(); i++) {
            dtos.add(poToDto(dialogues.get(i)));
        }
        return dtos;
    }

    //dto转pojo
    private Dialogue dtoToPo(DialogueDto dialogueDto) {
        Dialogue dialogue = new Dialogue();
        dialogue.setTitle(dialogueDto.getTitle());
        dialogue.setDesc(dialogueDto.getDesc());
        return dialogue;
    }

    //pojo转dto
    private DialogueDto poToDto(Dialogue dialogue) {
        DialogueDto dialogueDto = new DialogueDto();
        dialogueDto.setDiaId(dialogue.getDiaId());
        dialogueDto.setTitle(dialogue.getTitle());
        dialogueDto.setDesc(dialogue.getDesc());
        return dialogueDto;
    }

    //str转pojo
    private Dialogue strToPo(String title, String desc, String userId) {
        Dialogue dialogue = new Dialogue();
        dialogue.setTitle(title);
        dialogue.setDesc(desc);
        dialogue.setUserId(userId);
        return dialogue;
    }


}
