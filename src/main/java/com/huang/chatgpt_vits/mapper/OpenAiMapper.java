package com.huang.chatgpt_vits.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.chatgpt_vits.pojo.Message;
import com.huang.chatgpt_vits.pojo.OpenAiResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface OpenAiMapper extends BaseMapper<OpenAiResult> {
    /**
     * 消息上下文查询,只查最新的（时间从大到小），520条
     * @param map daiId,role
     * @return
     */
    List<Message> getMessages(@Param("map") Map<String,Object> map);

}
