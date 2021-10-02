package beanconfig.code;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午6:00
 * @description CodeConfigBean 通过代码方式配置bean
 */
@Configuration
public class CodeConfigBean {

  @Bean
  public CodeConfigInfo getCodeConfigInfo(){
      return new CodeConfigInfo();
  }

}
