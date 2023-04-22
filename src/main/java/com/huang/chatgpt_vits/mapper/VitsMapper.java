package com.huang.chatgpt_vits.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.chatgpt_vits.pojo.Vits;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface  VitsMapper extends BaseMapper<Vits> {
}
