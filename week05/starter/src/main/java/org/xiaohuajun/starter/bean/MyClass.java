package org.xiaohuajun.starter.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 上午7:14
 * @description MyClass
 */
public class MyClass {

  private int id;

  private String name;

  private List<Student> students;

  public MyClass(int id, String name) {
    this.id = id;
    this.name = name;
  }


  public void addStudent(Student student) {
    students.add(student);
  }

}
