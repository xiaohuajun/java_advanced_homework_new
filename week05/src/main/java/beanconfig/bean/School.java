package beanconfig.bean;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午5:01
 * @description School 学校
 */
@Data
public class School implements Serializable {

  private List<Student> students;

  private List<Course> courses;

  private String address;


  @Override
  public String toString() {
    return "School{" +
        "students=" + students +
        ", courses=" + courses +
        ", address='" + address + '\'' +
        '}';
  }
}
