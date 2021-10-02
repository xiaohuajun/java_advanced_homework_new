package database.hikari;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 上午6:47
 * @description HikariRunner 数据库运行
 */
@Component
public class HikariRunner implements CommandLineRunner {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void run(String... args) throws Exception {
    String sql = "select * from users";
    List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
    users.forEach(System.out::println);
  }
}
