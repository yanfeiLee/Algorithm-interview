package com.lyf.base;

import org.junit.Test;

public class ReverseInteger {

	@Test
	public void test() {
		int i = Integer.parseInt("-229");
//		System.out.println(reverseInt2(i));
		System.out.println(intreverse(-9322));
		//String eleString = "gogd"; System.out.println(eleString.charAt(0));
		 
	}

	/**
	 * 纯数字计算反转，反转3位整数
	 * 
	 * @param ele
	 * @return
	 */
	public int reverseInt(int ele) {
		int one = ele / 100;
		int two = ele % 100 / 10;
		int three = ele % 100 % 10;
		int res_one = three * 100;
		int res_two = two * 10;
		int res_three = one;
		return Integer.parseInt((res_one + res_three + res_two) + "");
	}

	/**
	 * 字符串交换,反转3位整数
	 * 
	 * @param ele
	 * @return
	 */
	public int reverseInt2(int ele) {
		String eleString = "";
		if (ele < 0) {
			eleString = Math.abs(ele) + "";
			String one = eleString.charAt(0) + "";
			String two = eleString.charAt(1) + "";
			String three = eleString.charAt(2) + "";
			String tmp;
			if (!one.equals(three)) {
				tmp = one;
				one = three;
				three = tmp;
				eleString = "-" + one + two + three;
			}
		} else {
			eleString = ele + "";
			String one = eleString.charAt(0) + "";
			String two = eleString.charAt(1) + "";
			String three = eleString.charAt(2) + "";
			String tmp;
			if (!one.equals(three)) {
				tmp = one;
				one = three;
				three = tmp;
				eleString = one + two + three + "";
			}
		}
		return Integer.parseInt(eleString);
	}
	
	/**
	 * 反转任意位数的整数
	 * @param x
	 * @return
	 */
	public int intreverse(int x) {
		long tmp = x; // 防止结果溢出
		long result = 0;
		while (tmp != 0) {
			result = result * 10 + tmp % 10;
			tmp = tmp / 10;
		}
		// 溢出判断
		if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) result = 0;
		return (int) result;
	}
	 
}
