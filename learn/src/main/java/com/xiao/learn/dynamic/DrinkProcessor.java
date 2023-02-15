package com.xiao.learn.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/29 上午10:29
 * @description DrinkProcessor
 */
@Component
@Slf4j
public class DrinkProcessor implements BaseProcessor {


    @Override
    public String getType() {
        return "drink";
    }

    @Override
    public String doHandle(String type) {
        log.info("酒水策略执行完成");
        return "酒水策略执行完成";
    }
}
