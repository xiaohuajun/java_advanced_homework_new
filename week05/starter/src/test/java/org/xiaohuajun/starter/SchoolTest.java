package org.xiaohuajun.starter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.xiaohuajun.starter.bean.School;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 上午7:58
 * @description SchoolTest
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SchoolAutoConfiguration.class)
public class SchoolTest {

  @Autowired
  School mySchool;

  @Test
  public void test() {
    System.out.println(mySchool.toString());
  }
}

