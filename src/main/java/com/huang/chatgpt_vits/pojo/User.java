package com.huang.chatgpt_vits.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@TableName("user")
@ApiModel("user")
public class User {

  @ApiModelProperty("email")
  @TableId(value = "email")
  private String email;

  @ApiModelProperty("pwd")
  @TableField("pwd")
  private String pwd;

  @ApiModelProperty("created")
  @TableField(value = "created",fill = FieldFill.INSERT)
  private Date created;

  @ApiModelProperty("updated")
  @TableField(value = "updated",fill = FieldFill.INSERT_UPDATE)
  private Date updated;

  @ApiModelProperty("deleted")
  @TableField("deleted")
  private int deleted;

}
