package com.xiao.learn.service.impl;

import com.xiao.learn.dynamic.ProcessorContext;
import com.xiao.learn.service.ExeProcessorService;
import org.springframework.stereotype.Service;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/29 上午11:02
 * @description ExeProcessorServiceImpl
 */
@Service
public class ExeProcessorServiceImpl implements ExeProcessorService {


    @Override
    public String exeProcessor(String type) {
        ProcessorContext processorContext = new ProcessorContext(type);
        return processorContext.exeProcessor(type);
    }
}
