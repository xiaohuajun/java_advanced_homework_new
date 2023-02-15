package com.xiao.learn.controller;

import com.xiao.learn.service.ExeProcessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/29 上午9:27
 * @description BaseController
 */
@Slf4j
@RestController
@RequestMapping("/base")
public class BaseController {

    @Resource
    private ExeProcessorService exeProcessorService;

    @GetMapping("/info")
    public String getInfo(){
        return "hello";
    }

    @PostMapping("/exe")
    public String exeProcessor(@RequestBody String type){
        return exeProcessorService.exeProcessor(type);
    }

}
