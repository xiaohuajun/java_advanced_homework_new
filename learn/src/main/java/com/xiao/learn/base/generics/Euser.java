package com.xiao.learn.base.generics;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2023/2/17 下午1:50
 * @description EUser
 */
public class Euser  {

    public static <E> void printRes(E[] e){
        for (E e1 : e) {
            System.out.println("===" + e1);
        }
    }





}
