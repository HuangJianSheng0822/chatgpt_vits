package com.huang.chatgpt_vits.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@ApiModel("会话")
public class DialogueDto {
    @ApiModelProperty("diaId")
    private String diaId;
    @ApiModelProperty("title")
    private String title;
    @ApiModelProperty("desc")
    private String desc;
}
