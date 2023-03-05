package com.xiao.learn.concurrent.Thread.stop;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2023/2/18 下午4:15
 * @description VolatileCanStop 使用volatile 来处理停止线程，能够停止的情况
 *
 * 如果线程可能长期被阻塞的情况，使用volatile，在没有被唤醒之前，无法感受到中断
 */
public class VolatileCanStop implements Runnable {

    /**
     * 代替中断方法 interrupt 中断线程
     */
    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num = 0;
        try {
            while (!canceled && num <= 1000000) {
                if (num % 10 == 0) {
                    System.out.println("10的倍数" + num);
                }
                num++;
            }
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        VolatileCanStop volatileCanStop = new VolatileCanStop();
        Thread thread = new Thread(volatileCanStop);
        thread.start();
        Thread.sleep(1000);
        volatileCanStop.canceled = true;
    }
}
