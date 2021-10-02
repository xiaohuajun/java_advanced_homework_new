package database.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午9:09
 * @description HikariConfig 数据库连接池
 */
@Configuration
public class HikariConfigSelf {

  @Bean(destroyMethod = "close")
  public DataSource dataSource() throws SQLException {
    HikariConfig config = new HikariConfig("/hikari.properties");
    return new HikariDataSource(config);
  }

}
