package com.xiaohuajun.rpcfxdemo.entity;

import lombok.Data;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午3:01
 * @description User 用户实体
 */
@Data
public class User {

  private Long id;

  private String name;

  public User(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
