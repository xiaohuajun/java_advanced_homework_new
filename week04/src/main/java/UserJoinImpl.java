/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/8/29 下午8:01
 * @description Homework03 在main函数启动一个新线程或线程池，异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 */
public class UserJoinImpl {

  public static void main(String[] args) {
    long start=System.currentTimeMillis();
    //创建一个线程
    Runnable task = () -> {
      int result = InvokeMethod.sum();
      //拿到result并输出
      System.out.println("异步计算结果为："+result);
      System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    };
    Thread t = new Thread(task);
    t.start();
    try {
      t.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("主线程退出");
  }


}
