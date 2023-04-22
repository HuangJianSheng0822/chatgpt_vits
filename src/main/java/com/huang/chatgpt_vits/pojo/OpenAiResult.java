package com.huang.chatgpt_vits.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@ApiModel("openai返回")
public class OpenAiResult {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("会话id")
    private String diaId;


    @ApiModelProperty("object")
    private String object;

    @ApiModelProperty("创建时间")
    private Date created;

    @ApiModelProperty("model")
    private String model;


    @ApiModelProperty("tokens")
    private Usage usage;

    @ApiModelProperty("选择")
    private List<Choices> choices;


}
