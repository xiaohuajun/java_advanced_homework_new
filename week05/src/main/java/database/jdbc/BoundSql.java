package database.jdbc;

import java.util.List;
import org.springframework.util.CollectionUtils;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 上午10:51
 * @description BoundSql
 */
public class BoundSql {

  /**
   * sql类型
   */
  private String sqlType;

  /**
   * 表名
   */
  private String tableName;

  /**
   * sql参数
   */
  private List<Object> params;

  /**
   * 表字段
   */
  private String column;

  public BoundSql(String sqlType,String tableName,List<Object> params,String column){
    this.sqlType = sqlType;
    this.tableName = tableName;
    this.column = column;
    this.params = params;
  }

  /**
   * 跟进不同的操作创建sql模版
   *
   * @return 组装的sql
   */
  public String buildSqlTemplate(){
      String sql = "";
      switch (sqlType){
        case "insert":
          sql = buildInsertSql(tableName,column,params);
          break;
        case "select":
          sql = buildSelectSql(tableName,column,params);
          break;
        case "update":
          sql = buildUpdateSql(tableName,column,params);
          break;
        case "delete":
          sql = buildDeleteSql(tableName,column,params);
          break;
        default:
          break;
      }
      return sql;
  }

  private String buildDeleteSql(String tableName, String column, List<Object> params) {
    return null;
  }

  private String buildUpdateSql(String tableName, String column, List<Object> params) {
    return null;
  }

  private String buildSelectSql(String tableName, String column, List<Object> params) {
    String sqlTemplate = "select " + column + " from " + tableName;
    if (!CollectionUtils.isEmpty(params)) {
        sqlTemplate += " where " + params.toString();
    }
    return sqlTemplate;
  }

  private String buildInsertSql(String tableName, String column, List<Object> params) {
    return "insert into " + tableName + " " + column + " values (?" +
        ",?".repeat(Math.max(0, params.size() - 1)) + ")";
  }

}
