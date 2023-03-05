package com.xiao.learn.concurrent.Thread.impl;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2023/2/15 下午7:20
 * @description RunnableTask 本质上，实现线程的方法只有一种：new Thread(); 可以传入Runnable 任务
 */
public class RunnableTask implements Runnable{

    @Override
    public void run() {
        System.out.println("这是通过Runnable方式创建线程");
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableTask());
        thread.start();
    }
}
