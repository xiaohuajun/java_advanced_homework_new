import java.util.concurrent.CountDownLatch;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/8/29 上午7:08
 * @description UserCountDownLatch
 */
public class UserCountDownLatchImpl {


  public static void main(String[] args) {
    long start=System.currentTimeMillis();
    CountDownLatch latch = new CountDownLatch(1);
    //创建一个线程
    Runnable task = () -> {
      int result = InvokeMethod.sum();
      //拿到result并输出
      System.out.println("异步计算结果为："+result);
      System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
      latch.countDown();
    };
    Thread t = new Thread(task);
    t.start();
    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("主线程退出");
  }

}
