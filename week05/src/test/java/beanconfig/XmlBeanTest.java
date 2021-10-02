package beanconfig;

import beanconfig.xml.XmlBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午5:19
 * @description XmlBeanTest
 */
public class XmlBeanTest {

  @Test
  public void testConfigBean(){
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("BeanConfig.xml");
    XmlBean xmlBean =  (XmlBean) context.getBean("xmlBean");
    xmlBean.getInfo();
  }

}
