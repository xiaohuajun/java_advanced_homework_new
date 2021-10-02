package beanconfig;

import beanconfig.code.CodeConfigBean;
import beanconfig.code.CodeConfigInfo;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午6:06
 * @description CodeConfigBeanTest
 */
public class CodeConfigBeanTest {



    @Test
    public void codeConfigTest(){
      AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
          CodeConfigBean.class);
      CodeConfigInfo codeConfig = (CodeConfigInfo) applicationContext.getBean("getCodeConfigInfo");
      codeConfig.getInfo();
    }

}
