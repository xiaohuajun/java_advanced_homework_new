package com.xiao.learn.concurrent.Thread.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2023/2/15 下午7:21
 * @description ThreadTask 本质上，实现线程的方法只有一种：new Thread();
 */
public class ThreadTask extends Thread {


    @Override
    public void run() {
        System.out.println("通过Thread方式创建的线程");
    }


    public static void main(String[] args) {
        //面对线程池执行任务来说，也可以是执行一个任务
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new ThreadTask());

    }
}
