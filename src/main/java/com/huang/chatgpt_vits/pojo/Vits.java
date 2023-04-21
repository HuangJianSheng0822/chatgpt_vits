package com.huang.chatgpt_vits.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("vits")
public class Vits {
    @ApiModelProperty("一次对话id")
    private long id;
    @ApiModelProperty("对话内容")
    private String text;
    @ApiModelProperty("角色音色id")
    private int speakerId;
    @ApiModelProperty("输出格式")
    private String format;
    @ApiModelProperty("文本类型")
    private String lang;
    @ApiModelProperty("语速")
    private String length;
}
