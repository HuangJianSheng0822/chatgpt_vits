package com.huang.chatgpt_vits.dto;

import com.huang.chatgpt_vits.pojo.Message;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@ApiModel("用户发送消息")
@Data
@NoArgsConstructor
public class OpenAiDto {
    @ApiModelProperty("diaId")
    private String diaId;
    @ApiModelProperty("role")
    private String role;
    @ApiModelProperty("会话最大token数")
    private int max_tokens;
    @ApiModelProperty("会话temperature")
    private double temperature;
    @ApiModelProperty("会话top_p")
    private int top_p;
    @ApiModelProperty("会话n")
    private int n;
    @ApiModelProperty("消息")
    private String content;
}
