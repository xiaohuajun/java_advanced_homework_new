/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/8/29 上午7:35
 * @description InvokeMethod
 */
public class InvokeMethod {


  public static int sum() {
    return fibo(36);
  }

  private static int fibo(int a) {
    if ( a < 2){
      return 1;
    }
    return fibo(a-1) + fibo(a-2);
  }
}
