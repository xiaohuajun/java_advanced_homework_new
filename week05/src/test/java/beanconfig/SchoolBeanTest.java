package beanconfig;

import beanconfig.bean.School;
import beanconfig.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午6:42
 * @description School
 */
public class SchoolBeanTest {

  @Test
  public void test(){
    ApplicationContext context = new ClassPathXmlApplicationContext("BeanConfig.xml");
    School school = (School) context.getBean("school");
    for (Student student : school.getStudents()) {
      System.out.println(student);
    }

  }

}
