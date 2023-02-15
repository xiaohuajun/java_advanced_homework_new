package com.xiao.learn.dynamic;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/29 上午10:17
 * @description BaseProcessor
 */
public interface BaseProcessor {

    /**
     * 获取策略类型
     *
     * @return 策略类型
     */
    String getType();

    /**
     * 设置策略
     *
     * @param type 策略类型
     * @return
     */
    String doHandle(String type);


}
