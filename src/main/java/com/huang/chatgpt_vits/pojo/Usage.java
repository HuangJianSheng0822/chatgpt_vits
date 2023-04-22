package com.huang.chatgpt_vits.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("token相关")
@NoArgsConstructor
public class Usage {
    @ApiModelProperty("提示词")
    private int promptTokens;
    @ApiModelProperty("生成词")
    private int completionTokens;
    @ApiModelProperty("求和")
    private int total_tokens;
}
