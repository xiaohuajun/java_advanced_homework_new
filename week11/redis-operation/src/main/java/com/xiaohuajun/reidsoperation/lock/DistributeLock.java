package com.xiaohuajun.reidsoperation.lock;

import java.util.Collections;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/10/24 下午5:18
 * @description DistributeLock 基于redis实现分布式锁
 */
public class DistributeLock {

  private enum LockInstance {
    /**
     * 锁的单例
     */
    INSTANCE;
    private DistributeLock instance;

    LockInstance() {
      instance = new DistributeLock();
    }

    public DistributeLock getInstance() {
      return instance;
    }
  }

  public static DistributeLock getInstance() {
    return LockInstance.INSTANCE.getInstance();
  }

  private JedisPool jedisPool = new JedisPool();

  private static final String OK = "OK";

  private static final Long SUCCESS = 1L;

  /**
   * 获取锁
   *
   * @param lockKey 锁的key
   * @param requestId 锁的唯一标识
   * @param expireTime 过期时间
   * @return 是否拿到锁
   */
  public boolean getLock(String lockKey, String requestId, long expireTime) {
    try (Jedis jedis = jedisPool.getResource()) {
      String success = jedis.set(lockKey, requestId, "NX", "EX", expireTime);
      return OK.equals(success);
    }
  }

  /**
   * 释放锁
   *
   * @param lockKey 锁的key
   * @param requestId 锁的唯一标识
   * @return 是否释放成功
   */
  public boolean releaseLock(String lockKey,String requestId){
    try(Jedis jedis = jedisPool.getResource()){
      String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
      Object eval = jedis
          .eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
      return SUCCESS.equals(eval);
    }
  }


}
