package com.xiao.learn.concurrent.Thread.stop;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2023/2/18 上午10:37
 * @description StopDuringSleep 中断睡眠期间的线程
 * 线程在阻塞（sleep，wait）期间是能收到中断通知的，并且会抛出异常
 * 抛出异常后，把中断标志改为false
 * 实际开发中不能盲目吞掉中断异常，否则线程将无法停止
 */
public class StopDuringSleep implements Runnable {


    @Override
    public void run() {
        try {
            int num = 0;
            while (!Thread.currentThread().isInterrupted() && num <= 1000) {
                System.out.println("======" + num);
                num++;
                Thread.sleep(1000000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 最佳处理方式1:方法签名上抛出异常，需要让调用方去处理异常
     */
    public static void taskOne() throws InterruptedException {
        Thread thread = new Thread(new StopDuringSleep());
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }

    /**
     * 最佳处理方式2：在catch中不能隐藏异常，必须要处理异常，再次中断
     * 因为线程在睡眠期间，如果检测有中断通知，会消除中断标记位，并且清楚中断标记位
     * 所以需要再次中断，让调用方知道发生过中断
     */
    public static void taskTwo() {
        try {
            Thread thread = new Thread(new StopDuringSleep());
            thread.start();
            Thread.sleep(5);
            thread.interrupt();
        } catch (InterruptedException e) {
            //再次中断，才能停止线程
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        taskTwo();
    }
}
