package database.hikari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午10:47
 * @description HikariApplication
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "database.hikari")
public class HikariApplication {

  public static void main(String[] args) {
    SpringApplication.run(HikariApplication.class, args);
  }

}
