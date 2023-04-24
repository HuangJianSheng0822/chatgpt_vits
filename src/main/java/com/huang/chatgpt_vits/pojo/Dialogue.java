package com.huang.chatgpt_vits.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@ApiModel("会话")
@TableName("dialogue")
public class Dialogue {

    @ApiModelProperty("diaId")
    @TableId(value = "`dia_id`", type = IdType.ASSIGN_ID)
    private String diaId;


    @ApiModelProperty("userId")
    @TableField("`user_id`")
    private String userId;

    @ApiModelProperty("title")
    @TableField("`title`")
    private String title;

    @ApiModelProperty("desc")
    @TableField("`desc`")
    private String desc;

    @ApiModelProperty("created")
    @TableField(value = "`created`", fill = FieldFill.INSERT)
    private Date created;

    @ApiModelProperty("updated")
    @TableField(value = "`updated`", fill = FieldFill.INSERT_UPDATE)
    private Date updated;

    @ApiModelProperty("deleted")
    @TableField(value = "`deleted`")
    private int deleted;
}
