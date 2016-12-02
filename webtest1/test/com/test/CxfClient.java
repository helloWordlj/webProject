package com.test;

public class CxfClient{
	
	public static void main(String[] args){
		String value = SingletonTest.getInstence().getProperties("aaa");
	}
}

