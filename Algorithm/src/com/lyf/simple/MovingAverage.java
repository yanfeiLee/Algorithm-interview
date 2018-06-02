package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @function  ����һ���������ʹ��ڴ�С�����㻬������������������ƽ��ֵ��
 * 		Example:
 * 			MovingAverage m = new MovingAverage(3);
			m.next(1) = 1 // ���� 1.00000
			m.next(10) = (1 + 10) / 2 // ���� 5.50000
			m.next(3) = (1 + 10 + 3) / 3 // ���� 4.66667
			m.next(5) = (10 + 3 + 5) / 3 // ���� 6.00000
 * @author Administrator
 * @date 2018��4��20�� ����9:57:22
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
	private long sum = 0;  //�ۼӻ����۳�ʱ��ע�����ݳ���
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