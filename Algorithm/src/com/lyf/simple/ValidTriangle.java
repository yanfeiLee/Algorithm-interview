package com.lyf.simple;

import org.junit.Test;


/**
 * 判断3个数是否可以组成三角形
 * @author Administrator
 *
 */
public class ValidTriangle {

	@Test
	public void test() {
		if(isValidTriangle(2,2,3)){
			System.out.println("合法三条边");
		}else{
			System.out.println("不合法");
		}
	}

	/**
	 * 判断3个数是否可以组成三角形
	 * 充要条件
	 * 两边之和大于第三边
	 * 或者
	 * 两边之差小于第三边
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
