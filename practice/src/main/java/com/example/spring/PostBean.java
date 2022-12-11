package com.example.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/9 下午8:21
 * @description PostBean
 */

public class PostBean implements BeanPostProcessor {


    /**
     * 前置处理
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("==================");
        System.out.println( beanName + "开始前置处理");
        return bean;
    }


    /**
     * 后置处理
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }



}
