package com.xiao.learn.dynamic;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/29 上午10:32
 * @description ProcessorFactory 缓存策略
 */
@Component
@Slf4j
public class ProcessorFactory implements InitializingBean {

    /**
     * 缓存策略
     */
    private static Map<String, BaseProcessor> processorMap = new ConcurrentHashMap<>();

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        cacheProcessor();
    }

    private void cacheProcessor() {
        //获取所有的策略
        Map<String, BaseProcessor> baseProcessorMap = applicationContext.getBeansOfType(BaseProcessor.class);
        if (Objects.nonNull(baseProcessorMap) && !baseProcessorMap.isEmpty()) {
            for (BaseProcessor value : baseProcessorMap.values()) {
                processorMap.put(value.getType(), value);
            }
        }
        log.info("策略加载完成");
    }

    public static BaseProcessor getProcessorByType(String type) {
        if(!processorMap.containsKey(type)){
            return null;
        }
        return processorMap.get(type);
    }

}
