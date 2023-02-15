package com.xiao.learn.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/29 上午10:30
 * @description FruitProcess
 */
@Component
@Slf4j
public class FruitProcess implements BaseProcessor {


    @Override
    public String getType() {
        return "fruit";
    }

    @Override
    public String doHandle(String type) {
        log.info("水果策略执行完成");
        return "水果策略执行完成";
    }
}
