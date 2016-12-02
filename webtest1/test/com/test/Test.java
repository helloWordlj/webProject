package com.test;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import redis.clients.jedis.ShardedJedis;

import com.lujun.frame.common.SqlConstants;
import com.lujun.frame.query.Query;
import com.lujun.frame.query.SimpleCriteria;

public class Test {

	@Resource
	private static Query query;

	public static void main(String[] args) {
		// ApplicationContext applicationContext=new
		// ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		// Query query=(Query)applicationContext.getBean("query");
		// QueryImpl
		// userService=(QueryImpl)applicationContext.getBean("userService");
		ShardedJedis shardedJedis = null;
		if (query == null) {
			System.out.println("null!");
		} else {
			// String t=query.test("test11111111111");
			SimpleCriteria criteria = new SimpleCriteria();
			criteria.setStrVal1("大军");
			criteria.setLonVal1(Long.valueOf("1"));
			boolean i = query.isExists(SqlConstants.EXISTS_USER_NAME, criteria);
			System.out.println(i);
		}
		Set<String> set = new HashSet<String>();
		if(set.contains("")){
			
		}

	}

}
