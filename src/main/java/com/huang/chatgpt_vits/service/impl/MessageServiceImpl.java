package com.huang.chatgpt_vits.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.chatgpt_vits.dto.OpenAiDto;
import com.huang.chatgpt_vits.mapper.MessageMapper;
import com.huang.chatgpt_vits.mapper.OpenAiMapper;
import com.huang.chatgpt_vits.pojo.Message;
import com.huang.chatgpt_vits.pojo.OpenAiResult;
import com.huang.chatgpt_vits.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Value("${openai.serviceUrl}")
    private String serviceUrl;
    @Value("${openai.url}")
    private String url;
    @Value("${openai.model}")
    private String model;
    @Value("${openai.authorization}")
    private String authorization;
    @Value("${openai.stream}")
    private String stream;

    @Autowired
    private MessageMapper messageMapper;
    @Override
    public String sendMsg(OpenAiDto openAiDto,String diaId) {

        //请求头
        HttpHeaders headers = new HttpHeaders();
        //请求体
        JSONObject paramMap = new JSONObject();
        paramMap.put("url",url);
        paramMap.put("model",model);
        paramMap.put("authorization",authorization);
        paramMap.put("max_tokens",openAiDto.getMax_tokens());
        paramMap.put("temperature",openAiDto.getTemperature());
        paramMap.put("top_p",openAiDto.getTop_p());
        paramMap.put("n",openAiDto.getN());
        paramMap.put("stream",stream);

        //构建上下文，有system,user
        List<Message> messages = getMessages(diaId);
        //将新内容加入上下文
        Message temp = new Message();
        temp.setRole(openAiDto.getRole());
        temp.setContent(openAiDto.getContent());
        temp.setDiaId(diaId);
        messages.add(temp);


        paramMap.put("messages",messages);
        //整合请求头和请求参数
        HttpEntity<JSONObject> httpEntity = new HttpEntity<>(paramMap, headers);
        //请求客户端
        RestTemplate rt = new RestTemplate();
        //发起请求
        ResponseEntity<OpenAiResult> result = rt.postForEntity(serviceUrl, httpEntity, OpenAiResult.class);

        if (result.getStatusCodeValue()==200){
            Message message = result.getBody().getChoices().get(0).getMessage();
            message.setDiaId(diaId);
            //显示

            //异步，存储上下文，用户和robot
            addMessage(temp,message);

            return message.getContent();
        }else {
            return null;
        }

    }

    //构建上下文，有system,user
    public List<Message> getMessages(String diaId){
        ArrayList<Message> messages=new ArrayList<>();
        HashMap<String, Object> umap = new HashMap<>();
        HashMap<String, Object> smap = new HashMap<>();
        umap.put("diaId",diaId);
        umap.put("role","user");
        smap.put("diaId",diaId);
        smap.put("role","system");
        List<Message> umsgs = messageMapper.getMessages(umap);
        List<Message> smsgs = messageMapper.getMessages(smap);
        //消息合并
        smsgs.addAll(umsgs);
        return smsgs;
    }

    @Async
    //存储上下文
    public boolean addMessage(Message temp,Message message){
        int t = messageMapper.insert(temp);
        int m = messageMapper.insert(message);
        return t>0&&m>0;
    }


}
