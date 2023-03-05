package com.xiao.learn.base.generics;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2023/2/17 下午2:26
 * @description WenHao
 */
public class WenHao {

    final ReentrantLock lock = new ReentrantLock();

    private Condition s = lock.newCondition();

    public void getData(List<? extends Integer> da) {

    }


    public static void main(String[] args) throws InterruptedException {
        long time = 2;
        long sa = TimeUnit.SECONDS.toNanos(time);
        System.out.println("===" + sa);

    }

}
