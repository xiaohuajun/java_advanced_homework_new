package com.xiao.learn.dynamic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/29 上午11:13
 * @description RiceProcessor
 */
@Component
@Slf4j
public class RiceProcessor  implements BaseProcessor {


    @Override
    public String getType() {
        return "rice";
    }

    @Override
    public String doHandle(String type) {
        log.info("米饭策略执行完成");
        return "米饭策略执行完成";
    }
}
