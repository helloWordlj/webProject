package com.test;


public class Test1 {

	protected String test1(){
		return "test1";
	}
	
	@org.junit.Test
	public void testSystem(){
		Long loadTime = System.currentTimeMillis();
	}
}
