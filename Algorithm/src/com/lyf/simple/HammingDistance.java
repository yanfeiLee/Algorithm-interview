package com.lyf.simple;

import org.junit.Test;

/**
 *@function  ����������֮���Hamming Distance
 *������ʾ��������ͬ���ȣ��ֶ�Ӧλ��ͬ��������������d��x,y����ʾ������x,y֮��ĺ������롣
 * �������ַ�������������㣬��ͳ�ƽ��Ϊ1�ĸ�������ô��������Ǻ������롿
 * 
 *@author Administrator
 *@date 2018��4��8�� ����11:23:57 
 *
 */
public class HammingDistance {

	@Test
	public void test() {
		//�������
//		int i = 1^4;
//		System.out.println(i);
		System.out.println(getHammingDistance2(14, 4));
	}
	
	/**
	 * ���㺺�����룬����������ͳ��1�ĸ���
	 * @param x
	 * @param y
	 * @return
	 */
	public int getHammingDistance(int x,int y){
		int res = 0;
		int tmp = x^y;
		System.out.println(tmp);		 
		do{			
			if(1==tmp%2){
				res++;
			}
			tmp = tmp/2;
		}while(0 != tmp);
		return res;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int getHammingDistance2(int x,int y){
		int Distance=0;	      
		while (x != 0 || y != 0) {
			if (x % 2 != y % 2) {
				Distance++;
			}
			x /= 2;
			y /= 2;
		}
		return Distance;
	}
	  
}
