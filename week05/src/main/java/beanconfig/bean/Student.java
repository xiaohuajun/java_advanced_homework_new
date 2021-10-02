package beanconfig.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午4:59
 * @description Student 学生
 */
@Data
public class Student implements Serializable {

  private String id;

  private String name;

  private String sex;

  @Override
  public String toString() {
    return "Student{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", sex='" + sex + '\'' +
        '}';
  }
}
