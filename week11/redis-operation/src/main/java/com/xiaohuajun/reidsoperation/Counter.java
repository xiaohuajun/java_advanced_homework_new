package com.xiaohuajun.reidsoperation;

import com.xiaohuajun.reidsoperation.lock.DistributeLock;
import org.springframework.stereotype.Component;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/24 下午7:28
 * @description Counter 分布式计数器
 */
@Component
public class Counter {

  private static int amount = 10;
  
  public void count(String lockKey,long time) {
    System.out.println("lock test；start sleep 10");
    boolean lock = DistributeLock.getInstance().getLock(lockKey,lockKey,time);
    if (!lock) {
      System.out.println("获取锁失败");
      return;
    }
    try {
      Thread.sleep(10000);
      amount -= 1;
      System.out.printf("库存减一amount: %d\n", amount);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }finally {
        boolean b = DistributeLock.getInstance().releaseLock(lockKey, lockKey);
        if(b){
          System.out.println("释放锁" + lockKey + "成功");
        }
    }
  }

}
