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
	 * �����ּ��㷴ת����ת3λ����
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
	 * �ַ�������,��ת3λ����
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
	 * ��ת����λ��������
	 * @param x
	 * @return
	 */
	public int intreverse(int x) {
		long tmp = x; // ��ֹ������
		long result = 0;
		while (tmp != 0) {
			result = result * 10 + tmp % 10;
			tmp = tmp / 10;
		}
		// ����ж�
		if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) result = 0;
		return (int) result;
	}
	 
}
