package com.lyf.simple;

import org.junit.Test;


/**
 * �ж�3�����Ƿ�������������
 * @author Administrator
 *
 */
public class ValidTriangle {

	@Test
	public void test() {
		if(isValidTriangle(2,2,3)){
			System.out.println("�Ϸ�������");
		}else{
			System.out.println("���Ϸ�");
		}
	}

	/**
	 * �ж�3�����Ƿ�������������
	 * ��Ҫ����
	 * ����֮�ʹ��ڵ�����
	 * ����
	 * ����֮��С�ڵ�����
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public boolean isValidTriangle(int a, int b, int c) {
		return (a + b > c && b + c > a && c + a > b);
        //return (a - b < c && b - c < a && c - a < b);
	}
}
