package org.xiaohuajun.starter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.xiaohuajun.starter.bean.MyClass;
import org.xiaohuajun.starter.bean.School;
import org.xiaohuajun.starter.bean.Student;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 上午7:43
 * @description SchoolConfiguration
 */
@Configuration
@ConditionalOnClass(School.class)
@EnableConfigurationProperties(SchoolProperties.class)
@ConditionalOnProperty(prefix = "school", value = "enabled", havingValue = "true")
@PropertySource("classpath:application.properties")
public class SchoolAutoConfiguration {

  @Autowired
  private SchoolProperties schoolProperties;

  @Bean
  public School mySchool() {
    List<Integer> studentIds = schoolProperties.getStudentIds();
    List<String> studentNames = schoolProperties.getStudentNames();
    List<Integer> classIds = schoolProperties.getMyClassIds();
    List<String> classNames = schoolProperties.getMyClassNames();
    List<Map<String, Integer>> studentOfClass = schoolProperties.getStudentOfClass();

    List<Student> students = new ArrayList<>(studentIds.size());
    for (int i=0; i<studentIds.size(); i++) {
      students.add(new Student(studentIds.get(i), studentNames.get(i)));
    }

    List<MyClass> myClasses = new ArrayList<>();
    for (int i=0; i<classIds.size(); i++) {
      myClasses.add(new MyClass(classIds.get(i), classNames.get(i)));
    }
    for (Map info: studentOfClass) {
      myClasses.get((Integer) info.get("myClassId")).addStudent(students.get((Integer) info.get("studentId")));
    }
    System.out.println(studentIds.toString());
    System.out.println(studentNames.toString());
    System.out.println(classIds.toString());
    System.out.println(classNames.toString());
    System.out.println(studentOfClass.toString());
    return new School(myClasses);
  }

}
