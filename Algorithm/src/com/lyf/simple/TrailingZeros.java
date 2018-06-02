package com.lyf.simple;

import org.junit.Test;

/**
 *@function
 *@author Administrator
 *@date 2018年5月17日 上午11:40:08 
 *
 */
public class TrailingZeros {

	@Test
	public void test() {
		System.out.println(trailingZeros(25));
//		System.out.println(100%10);
	}
	/**
	 * 数据过大时，会越界，判断错误
	 * @param n
	 * @return
	 */
	public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
		long cnt = 0;
		long tmp = 1;
		for (int i = 1; i <= n; i++) {
			tmp *= i;
			if(0 == tmp%10){
				System.out.println(tmp);
				cnt++;
				tmp /= 10;
			}
		}
		System.out.println(tmp);
        return cnt;
    }
	/**
	 * 数学方法  https://blog.csdn.net/surp2011/article/details/51168272
	 * @param n
	 * @return
	 */
	public long trailingZeros2(long n) {
		 long sum = 0;
	     while (n != 0) {
	         sum += n / 5;
	         n /= 5;
	     }
	     return sum;
	}
}
