package com.xiao.learn.concurrent.Thread.impl;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2023/2/15 下午7:37
 * @description CallableTask callable call方法 这个任务是带着返回值，理论上这是一个任务
 */
public class CallableTask implements Callable<Integer> {



    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(100);
    }

    public static void main(String[] args) {
        //面对线程池执行任务来说，也可以是执行一个任务
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //使用future接受执行任务的返回值
        Future<Integer> future =  executorService.submit(new CallableTask());
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
