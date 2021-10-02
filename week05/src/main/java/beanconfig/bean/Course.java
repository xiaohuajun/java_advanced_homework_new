package beanconfig.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午5:00
 * @description Course 课程
 */
@Data
public class Course implements Serializable {

  private String id;

  private String name;

  @Override
  public String toString() {
    return "Course{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
