package org.xiaohuajun.starter.bean;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 上午7:14
 * @description Student
 */
public class Student {

  private int id;

  private String name;

  public Student(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
