package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @function  给出一串整数流和窗口大小，计算滑动窗口中所有整数的平均值。
 * 		Example:
 * 			MovingAverage m = new MovingAverage(3);
			m.next(1) = 1 // 返回 1.00000
			m.next(10) = (1 + 10) / 2 // 返回 5.50000
			m.next(3) = (1 + 10 + 3) / 3 // 返回 4.66667
			m.next(5) = (10 + 3 + 5) / 3 // 返回 6.00000
 * @author Administrator
 * @date 2018年4月20日 上午9:57:22
 *
 */
public class MovingAverage {

	@Test
	public void test() {
		MA m = new MA(10);
		m.next(10);
		System.out.println(m.next(9));
		System.out.println(m.next(19));
	}
}
class MA{
	
	/*
	 * @param size: An integer
	 */
	private int windowSize = 0;
	private long sum = 0;  //累加或者累乘时，注意数据长度
	List<Integer> tmp = null;	 
	public MA(int size) {
		// do intialization if necessary
		this.windowSize = size;
		tmp = new ArrayList<Integer>();
	}

	/*
	 * @param val: An integer
	 * 
	 * @return:
	 */
	public double next(int val) {
		// write your code here		
		if(this.windowSize != tmp.size()){
			sum += val;
			tmp.add(val);
		}else{
			sum += val - tmp.get(0);
			tmp.remove(0);
			tmp.add(val);
		}
		return (double)sum/tmp.size();
		
	}
}