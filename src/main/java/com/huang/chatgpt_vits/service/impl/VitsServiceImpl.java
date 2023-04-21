package com.huang.chatgpt_vits.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.chatgpt_vits.dto.VitsDto;
import com.huang.chatgpt_vits.mapper.VitsMapper;
import com.huang.chatgpt_vits.pojo.Vits;
import com.huang.chatgpt_vits.service.VitsService;
import com.huang.chatgpt_vits.util.UUIDUtil;
import com.huang.chatgpt_vits.vo.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class VitsServiceImpl extends ServiceImpl<VitsMapper, Vits> implements VitsService {

    @Value("${vits.url}")
    private String url;
    @Value("${vits.format}")
    private String format;
    @Value("${vits.path}")
    private String path;

    @Override
    public Result vitsUrl(VitsDto vitsDto){

        String url=this.url+"?text="+vitsDto.getText()+"&id="
                +vitsDto.getSpeakerId()+"&format="+format
                +"&lang="+vitsDto.getLang()+"&length="+vitsDto.getLength();

        //请求客户端
        RestTemplate rt = new RestTemplate();
        ResponseEntity<byte[]> forEntity = rt.getForEntity(url, byte[].class);
        String fileName= UUIDUtil.fileNameByUUID()+".wav";
        try {
            Files.write(Paths.get(path+fileName), Objects.requireNonNull(forEntity.getBody(),
                    "未获取到下载文件"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(forEntity.getStatusCodeValue(),"YES",fileName);
    }
}
