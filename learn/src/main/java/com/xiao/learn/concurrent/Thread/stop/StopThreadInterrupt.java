package com.xiao.learn.concurrent.Thread.stop;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2023/2/17 下午7:26
 * @description StopThread 通过interrupt 中断线程执行
 */
public class StopThreadInterrupt implements Runnable {


    @Override
    public void run() {
        int count = 0;
        //线程收到有程序的中断信号后，中断标记位：true
        //线程没有中断且count < 0 继续执行任务
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
            System.out.println("count----》" + count++);
        }
        if(Thread.currentThread().isInterrupted()){
            System.out.println("中断信号");
        }
    }

    /**
     * 正确的中断线程的方式
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(1);
        queue.poll();
        Thread thread = new Thread(new StopThreadInterrupt());
        thread.start();
        //阻塞了5ms，不释放锁，必须传入时间参数，到期自动唤醒
        Thread.sleep(5);
        //线程的中断标记位为true
        thread.interrupt();
    }


}
