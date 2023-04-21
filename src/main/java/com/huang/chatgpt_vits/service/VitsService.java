package com.huang.chatgpt_vits.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.chatgpt_vits.dto.VitsDto;
import com.huang.chatgpt_vits.pojo.Vits;
import com.huang.chatgpt_vits.vo.Result;

public interface VitsService extends IService<Vits> {
    Result vitsUrl(VitsDto vitsDto);
}
