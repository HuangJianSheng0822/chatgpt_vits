package com.huang.chatgpt_vits.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@ApiModel("消息内容")
@TableName("message")
public class Message{
    public static final String SYSTEM="system";
    public static final String USER="user";
    public static final String ASSISTANT="assistant";

    @ApiModelProperty("msgId")
    @TableId(value = "msg_id",type = IdType.ASSIGN_ID)
    private String msgId;

    @ApiModelProperty("diaId")
    @TableField("dia_id")
    private String diaId;

    @ApiModelProperty("role")
    @TableField("role")
    private String role;

    @ApiModelProperty("content")
    @TableField("content")
    private String content;

    @ApiModelProperty("created")
    @TableField(fill = FieldFill.INSERT)
    private Date created;
}
