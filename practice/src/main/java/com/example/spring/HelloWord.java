package com.example.spring;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/10 上午9:40
 * @description HelloWord
 */
public class HelloWord {


    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("My Message : " + message);
    }


}
