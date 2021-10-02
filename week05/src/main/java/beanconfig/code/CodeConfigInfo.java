package beanconfig.code;

import org.springframework.stereotype.Component;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午6:03
 * @description CodeConfigInfo
 */
@Component
public class CodeConfigInfo {

  public CodeConfigInfo() {
    System.out.println("code-config-bean");
  }

  public void getInfo(){
    System.out.println("code-bean-info");
  }

}
