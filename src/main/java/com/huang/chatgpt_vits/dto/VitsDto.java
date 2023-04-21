package com.huang.chatgpt_vits.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("vits_dto")
public class VitsDto {
    @ApiModelProperty("对话内容")
    private String text;
    @ApiModelProperty("角色音色id")
    private int speakerId;
    @ApiModelProperty("文本类型")
    private String lang;
    @ApiModelProperty("语速")
    private double length;
}
