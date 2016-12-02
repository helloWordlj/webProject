package com.test;


import org.junit.Test;

import com.lujun.frame.exception.ErrorCode;
import com.lujun.frame.exception.SystemException;

public class TestException {

	public int division(int a,int b) throws SystemException{
		int c=0;
		try {
			c = a / b;
		} catch (ArithmeticException e) {
			throw new SystemException(ErrorCode.Fail);
		}
		return c;
	}
	
	@Test
	public void testDivision() throws SystemException{
		division(1, 0);
	}
}
