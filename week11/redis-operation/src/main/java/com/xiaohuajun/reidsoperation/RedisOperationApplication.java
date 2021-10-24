package com.xiaohuajun.reidsoperation;

import com.xiaohuajun.reidsoperation.lock.DistributeLock;
import javax.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaohuajun
 * @date 2021-10-23 18:09:11
 *
 */
@SpringBootApplication
public class RedisOperationApplication {

  private final static String LOCK = "redis-lock";

  private final static long EXPIRE = 20L;


  private static int amount = 10;

  public static void count() {
    System.out.println("lock test；start sleep 10");
    boolean lock = DistributeLock.getInstance().getLock(LOCK,LOCK,EXPIRE);
    if (!lock) {
      System.out.println(Thread.currentThread().getId() +"获取锁失败");
      return;
    }
    try {
      System.out.println(Thread.currentThread().getId() +"获取锁成功");
      Thread.sleep(10000);
      amount -= 1;
      System.out.printf("库存减一amount: %d\n", amount);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      boolean b = DistributeLock.getInstance().releaseLock(LOCK, LOCK);
      if(b){
        System.out.println("释放锁" + LOCK + "成功");
      }
    }
  }
  
  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(RedisOperationApplication.class, args);
    Thread thread1 = new Thread(RedisOperationApplication::count);
    Thread thread2 = new Thread(RedisOperationApplication::count);
    thread1.start();
    thread2.start();
    //主线程等待子线程结束才能结束
    thread1.join();
    thread2.join();
    Thread thread3 = new Thread(RedisOperationApplication::count);
    thread3.start();
    thread3.join();
  }
  
}
