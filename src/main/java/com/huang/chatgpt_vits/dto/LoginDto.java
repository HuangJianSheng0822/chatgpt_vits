package com.huang.chatgpt_vits.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String email;
    private String pwd;
    //cookie
    private boolean remember;
}