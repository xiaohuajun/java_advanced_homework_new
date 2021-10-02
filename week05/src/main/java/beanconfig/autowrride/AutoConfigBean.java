package beanconfig.autowrride;

import org.springframework.stereotype.Component;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午6:14
 * @description AutoConfigBean 自动装配bean，注解
 */
@Component
public class AutoConfigBean {


  public AutoConfigBean() {
    System.out.println("auto-config-bean");
  }

  public void getInfo(){
    System.out.println("auto-bean-info");
  }

}
