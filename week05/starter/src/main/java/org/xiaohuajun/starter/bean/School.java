package org.xiaohuajun.starter.bean;

import java.util.List;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 上午7:14
 * @description School
 */
public class School {

  private List<MyClass> myClasses;

  public School(List<MyClass> myClasses) {
    this.myClasses = myClasses;
  }

  @Override
  public String toString() {
    return "School{" +
        "myClasses=" + myClasses +
        '}';
  }
}
