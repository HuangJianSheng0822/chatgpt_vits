package com.huang.chatgpt_vits.controller;

import com.huang.chatgpt_vits.dto.VitsDto;
import com.huang.chatgpt_vits.service.VitsService;
import com.huang.chatgpt_vits.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class VitsController {

    @Autowired
    private VitsService vitsService;

    @PostMapping("/getVits")
    private Result getVits(@RequestBody VitsDto vitsDto){
        return vitsService.vitsUrl(vitsDto);
    }
}
