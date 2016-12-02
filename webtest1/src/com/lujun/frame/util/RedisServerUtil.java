package com.lujun.frame.util;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;

public class RedisServerUtil {

	public void hmset(String key,Map<String, String> value){
		this.getJedis().hmset(key, value);
	}
	
	public void hexists(String key,String field){
		this.getJedis().hexists(key, field);
	}

	public List<Map<String, String>> getlistObj(String key){
		return this.getJedis().sentinelSlaves(key);
	}
	
	
	/** 
     * 获取一个jedis 客户端 
     * @return 
     */  
    private Jedis getJedis(){  
        if(jedis == null){  
            return jedisConnectionFactory.getShardInfo().createResource();  
        }  
        return jedis;  
    }  
    //操作redis客户端  
    private static Jedis jedis;  
    @Autowired  
    @Qualifier("jedisConnectionFactory")  
    private JedisConnectionFactory jedisConnectionFactory;
}
