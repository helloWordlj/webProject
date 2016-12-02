package com.lujun.frame.generic;

import org.springframework.data.redis.core.RedisTemplate;

public abstract class AbstractBaseRedisDao<k, v> {

	//@Autowired
	protected RedisTemplate<k,v> redisTemplate;

	public RedisTemplate<k, v> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<k, v> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
