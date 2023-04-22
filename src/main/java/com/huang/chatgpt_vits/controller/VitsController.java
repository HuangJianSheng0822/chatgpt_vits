package com.huang.chatgpt_vits.controller;

import com.huang.chatgpt_vits.dto.VitsDto;
import com.huang.chatgpt_vits.service.VitsService;
import com.huang.chatgpt_vits.vo.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@Api(tags = "vits")
public class VitsController {

    @Autowired
    private VitsService vitsService;

    @ApiOperation("语音请求")
    @ApiImplicitParam(name = "vitsDto")
    @PostMapping("/getVits")
    private Result getVits( @RequestBody VitsDto vitsDto){
        return vitsService.vitsUrl(vitsDto);
    }
}
