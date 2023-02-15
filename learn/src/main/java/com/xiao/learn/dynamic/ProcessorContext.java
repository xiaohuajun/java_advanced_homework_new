package com.xiao.learn.dynamic;


/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/29 上午10:51
 * @description ProcessorContext
 */

public class ProcessorContext {


    private BaseProcessor baseProcessor;


   public ProcessorContext(String type){
      this.baseProcessor = ProcessorFactory.getProcessorByType(type);
   }

   public String exeProcessor(String type){
       if(baseProcessor != null){
           return baseProcessor.doHandle(type);
       }
       return "没有对应的策略类型";
   }

}
