package com.lyf.test;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;


/**
 *@function
 *@author Administrator
 *@date 2018��4��2�� ����10:43:21 
 *
 */
public class TestQueueSize {

	@Test
	public void test() {
		Queue<Integer> q = new LinkedList<Integer>();
//		q.offer(0);
		q.offer(null); //����nullʱҲ����һ����λ��
		System.out.println(q.size());
	}
}
