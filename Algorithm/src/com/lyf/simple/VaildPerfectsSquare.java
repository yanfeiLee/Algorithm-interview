package com.lyf.simple;

import org.junit.Test;

/**
 * @function 给定一个整数，判断其是否是某个整数的平方，不能使用内建函数sqrt； 注: int overflow
 * @author Administrator
 * @date 2018年3月12日 下午12:17:18
 *
 */
public class VaildPerfectsSquare {

	@Test
	public void test() {		
		int s = 232563991;
		long r = (long)s*s;
		long r2 = (long)s*s; //超出Integer的最大表示值时，自动截取低32位
		System.out.println(r);
		if(isPerfectSquare2(2147395601)){
			System.out.println("perfect square!");
		}else{
			System.out.println("no");
		}
	}

	/**
	 * 时间复杂度O(log2(N)),二分法
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
		long start = 1, end = (long) num; // 转换为long防止溢出
		while (start + 1 < end) { // 找到mid时，防止死循环
			long mid = start + (end - start) / 2;
			if (mid * mid < num) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (start * start == (long) num || end * end == (long) num) {
			return true;
		}
		return false;
	}

	/**
	 * 时间复杂度O(n/2)
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare2(int num) {
		boolean flag = false;
		if (0 > num)
			return flag;
		int n = num % 10;
		//个位为下列这些数时，不能开根
		if (n == 2 || n == 3 || n == 7 || n == 8)  
			return flag;
		for (int i = 1; i <= num / 2 + 1; i++) {
			if ((long)i * i == num) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
