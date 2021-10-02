import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/8/29 上午8:23
 * @description ExecutorServiceImpl
 */
public class ExecutorServiceImpl {

  public static void main(String[] args) throws InterruptedException {
    long start=System.currentTimeMillis();
    //创建一个线程池
    ExecutorService es = Executors.newSingleThreadExecutor();
    es.submit(() -> {
      int result = InvokeMethod.sum();
      //拿到result并输出
      System.out.println("异步计算结果为："+result);
      System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    });
    //等待所有子线程结束后，才关闭线程池
    es.shutdown();
    es.awaitTermination(5000, TimeUnit.SECONDS);
    System.out.println("主线程退出");
  }

}
