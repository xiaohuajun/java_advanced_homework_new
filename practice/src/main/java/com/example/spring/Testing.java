package com.example.spring;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/10 上午9:44
 * @description Testing
 */
public class Testing {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWord obj = (HelloWord) context.getBean("helloWorld");
        obj.getMessage();
    }

}
