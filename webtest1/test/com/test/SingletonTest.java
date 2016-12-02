package com.test;

public class SingletonTest {

	private static SingletonTest instence = null;
	
	public SingletonTest(){}
	
	public static synchronized SingletonTest getInstence(){
		if(instence == null){
			//instence = new SingletonTest();
			synchronized(instence){	//代码快同步，避免直接同步方法带来的性能较大的开销
				instence = new SingletonTest();
			}
		}
		return instence; 
	}
	
	public static String getProperties(String key){
		return key;
	}
}

