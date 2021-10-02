package beanconfig;

import beanconfig.autowrride.AutoConfigBean;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午6:17
 * @description AutoConfigBean
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AutoConfigBean.class)
public class AutoConfigBeanTest {

  @Autowired
  private AutoConfigBean autoConfigBean;

  @Test
  public void autoConfigBean(){
    autoConfigBean.getInfo();
  }



}
