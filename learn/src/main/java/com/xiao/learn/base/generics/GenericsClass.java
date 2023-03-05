package com.xiao.learn.base.generics;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2023/2/17 下午1:58
 * @description GenericsClass 泛型类
 */
public class GenericsClass<T> {


    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }



    public String getInfo(String pa){
        GenericsClass<String> t = new GenericsClass<>();
        t.setT("ss");
        return t.getT();
    }
}
