package com.lyf.simple;

import org.junit.Test;

/**
 *@function  计算两个数之间的Hamming Distance
 *【它表示两个（相同长度）字对应位不同的数量，我们以d（x,y）表示两个字x,y之间的汉明距离。
 * 对两个字符串进行异或运算，并统计结果为1的个数，那么这个数就是汉明距离】
 * 
 *@author Administrator
 *@date 2018年4月8日 上午11:23:57 
 *
 */
public class HammingDistance {

	@Test
	public void test() {
		//异或运算
//		int i = 1^4;
//		System.out.println(i);
		System.out.println(getHammingDistance2(14, 4));
	}
	
	/**
	 * 计算汉明距离，先与或运算后统计1的个数
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
