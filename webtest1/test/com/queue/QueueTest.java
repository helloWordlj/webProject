package com.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.lujun.webtest1.exception.ErrorCode;
import com.lujun.webtest1.exception.TestException;

/**
 * 关于队列,线程池的讲解： http://www.cnblogs.com/dolphin0520/p/3932906.html
 * sychronized与reentrantLock之间的区别： http://uule.iteye.com/blog/1488356
 * 
 * @author lujun
 *
 */
public class QueueTest {

	public void queue() throws Exception {
		BlockingQueue<String> bQueue = new ArrayBlockingQueue<String>(15);
		LinkedBlockingQueue<Integer> lq = new LinkedBlockingQueue<Integer>();
		PriorityBlockingQueue<Integer> pq = new PriorityBlockingQueue<Integer>();
		DelayQueue dq = new DelayQueue();

		/*
		 * for(int i=1;i<=10;i++){ bQueue.offer(i+"a"); }
		 */

		// bQueue.put("aa");
		// System.out.println();
	}

	public static void main(String[] args) throws TestException {
		int a = 1, b = 0;
		if (a > b) {
			throw new TestException(ErrorCode.SUCCESS.getErrCode(),
					ErrorCode.SUCCESS.getErrMsg());
		}
		System.out.println("aaa");
		/*
		 * try { int c=a/b; //throw new
		 * TestException(ErrorCode.SUCCESS.getErrCode(),
		 * ErrorCode.SUCCESS.getErrMsg()); } catch (Exception e) {
		 * System.out.println(e.getMessage()); //e.printStackTrace(); }finally{
		 * System.out.println("bb"); } if(a < b){ System.out.println("vv");
		 * //throw new TestException(ErrorCode.FAIL.getErrCode(),
		 * ErrorCode.FAIL.getErrMsg()); }
		 */
	}

}
