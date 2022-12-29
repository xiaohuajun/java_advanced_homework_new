package com.xiao.learn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/info")
    public String getInfo(){
        return "hello";
    }

}
