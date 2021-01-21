package com.jy.sms.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value="短信模块", tags = {"短信"})
@RequestMapping(value = "/sms")
@RestController
public class SmsController {

    @ApiOperation("发短信")
    @GetMapping("/{phoneNumber}/verify")
    public String getSms(@PathVariable("phoneNumber") String phoneNumber){
        return phoneNumber;
    }
}
