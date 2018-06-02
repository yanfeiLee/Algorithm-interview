package com.lyf.test;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;


/**
 *@function
 *@author Administrator
 *@date 2018年4月2日 上午10:43:21 
 *
 */
public class TestQueueSize {

	@Test
	public void test() {
		Queue<Integer> q = new LinkedList<Integer>();
//		q.offer(0);
		q.offer(null); //插入null时也算作一各个位置
		System.out.println(q.size());
	}
}
