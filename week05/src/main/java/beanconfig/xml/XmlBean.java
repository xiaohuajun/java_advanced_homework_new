package beanconfig.xml;

import org.springframework.stereotype.Component;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午4:54
 * @description XmlBeanConfig xml方式装配bean
 */
@Component
public class XmlBean {

  public XmlBean() {
    System.out.println("xml-config-bean");
  }

  public void getInfo(){
    System.out.println("xml-bean-info");
  }
}
