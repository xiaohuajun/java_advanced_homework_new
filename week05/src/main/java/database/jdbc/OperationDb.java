package database.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 下午10:51
 * @description OperationDb jdbc操作数据库
 */
public class OperationDb {

  private Connection connection = null;

  private PreparedStatement preparedStatement = null;

  public void initConnection() {
    try {
      connection = ConnectionManagement.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  /**
   * 保存数据
   *
   * @param table  表名
   * @param column 列
   * @param values 保存的数据
   */
  public void insert(String table, String column, List<Object> values) {
    BoundSql insert = new BoundSql("insert", table, values, column);
    String sql = insert.buildSqlTemplate();
    try {
      preparedStatement = connection.prepareStatement(sql);
      for (int i = 1; i <= values.size(); i++) {
        preparedStatement.setObject(i, values.get(i - 1));
      }
      System.out.println(preparedStatement.toString());
      preparedStatement.execute();
      System.out.println("Insert successfully");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * 查询
   *
   * @param table  表名
   * @param column 需要查询的列名
   * @return 查询结果
   */
  public List<Map<String, Object>> query(String table, String column) {
    BoundSql insert = new BoundSql("select", table, null, column);
    String sql = insert.buildSqlTemplate();
    List<Map<String, Object>> list = new ArrayList<>();
    try {
      preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();
      String[] columns = column.split(",");
      while(resultSet.next()){
        for (String s : columns) {
          Map<String, Object> valueMap = new HashMap<>(16);
          valueMap.put(s, resultSet.getObject(s));
          list.add(valueMap);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  private void close() throws SQLException {
    preparedStatement.close();
    connection.close();
    System.out.println("Connection closed");
  }

  public static void main(String[] args) {
    OperationDb operationDb = new OperationDb();
    operationDb.initConnection();
    String table = "user";
    String columns = "id,username,password,birthday";

    String insertColumns = "(username, password, birthday)";
    List<Object> values = Arrays.asList("xiaohuajun", "122311", "1991-10-29");
    //查询
    List<Map<String, Object>> resultList = operationDb.query(table, columns);
    for (Map<String, Object> res : resultList) {
      System.out.println(res);
    }
    //保存
    operationDb.insert(table,insertColumns,values);
    try {
      operationDb.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }


}
