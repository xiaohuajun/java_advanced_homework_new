package database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 上午8:10
 * @description ConnectionManagment 数据库连接管理
 */
public class ConnectionManagement {


  /**
   * 获取连接
   * @return 数据库连接
   */
  public static Connection getConnection() throws SQLException {
    //获取连接
    try {
      loadDriver();
      Connection connection = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/homework", "root", "xhj@1029");
      System.out.println("Connection successfully");
      return  connection;
    } catch (SQLException e) {
      System.out.println("Connection failed");
      throw  e;
    }
  }

  /**
   * 加载驱动
   */
  public static void loadDriver(){
    //加载mysql驱动
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("Can't find mysql jdbc driver");
      e.printStackTrace();
    }
  }
}
