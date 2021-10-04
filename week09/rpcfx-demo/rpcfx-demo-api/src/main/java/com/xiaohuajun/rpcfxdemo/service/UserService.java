package com.xiaohuajun.rpcfxdemo.service;

import com.xiaohuajun.rpcfxdemo.entity.User;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/4 下午3:08
 * @description UserService 用户服务接口
 */
public interface UserService {


  /**
   * 通过用户id查询用户信息
   *
   * @param userId 用户id
   * @return 用户信息
   */
  User findByUserId(Integer userId);


}
