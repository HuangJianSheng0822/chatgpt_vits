package com.huang.chatgpt_vits.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel("选择")
public class Choices {
    @ApiModelProperty("完成推理")
    private String finish_reason;
    @ApiModelProperty("下标")
    private int index;
    @ApiModelProperty("xiaox内容")
    private Message message;
}
