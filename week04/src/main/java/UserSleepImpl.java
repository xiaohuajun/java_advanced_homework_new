
/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/8/30 上午7:47
 * @description UserSleepImpl
 */
public class UserSleepImpl {


  public static void main(String[] args) throws InterruptedException {
    long start=System.currentTimeMillis();
    //创建一个线程
    Runnable task = () -> {
      try {
        Thread.sleep(1500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      int result = InvokeMethod.sum();
      //拿到result并输出
      System.out.println("异步计算结果为："+result);
      System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    };
    Thread t = new Thread(task);
    t.start();
    Thread.sleep(2000);
    System.out.println("主线程退出");
  }

}
