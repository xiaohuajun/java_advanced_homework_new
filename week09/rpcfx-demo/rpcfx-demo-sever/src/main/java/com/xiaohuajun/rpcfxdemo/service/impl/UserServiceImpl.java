package com.xiaohuajun.rpcfxdemo.service.impl;

import com.xiaohuajun.rpcfxdemo.entity.User;
import com.xiaohuajun.rpcfxdemo.service.UserService;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午3:14
 * @description UserServiceImpl 用户服务
 */
public class UserServiceImpl implements UserService {

  @Override
  public User findByUserId(Integer userId) {
    return new User(791L,"RPC-791");
  }
}
