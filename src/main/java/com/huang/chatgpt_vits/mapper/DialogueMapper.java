package com.huang.chatgpt_vits.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.chatgpt_vits.pojo.Dialogue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DialogueMapper extends BaseMapper<Dialogue> {
    Dialogue getLastOne(String userId);
}
