package com.lyf.simple;

import org.junit.Test;

/**
 *@function ��ȡ�ַ���[������Сд��ĸ���ո�' ']���һ�����ʵĳ��ȣ�������������һ�����ʣ��򷵻�0��
 *@author Administrator
 *@date 2018��3��10�� ����7:24:16 
 *
 */
/**
 * @author Administrator
 *
 */
public class LenthOfLastWord {

	@Test
	public void test() {
		 
		System.out.println((byte)'u');
//		System.out.println(Math.pow(2,3));
		// System.err.println("hello".length());
		String s = "I have a dream ";
		// System.out.println(s.length());
		System.out.println(lengthOfLastWord(s));

	}

	/**
	 * ���ʷָ[split����]����ʵsplit���������ַ��ָ�ʵ�� 
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord(String s) {
		// write your code here
		if ("" == s || " " == s)
			return 0;
		String[] strArr = s.split(" ");
		return strArr[strArr.length - 1].length();
	}

	/**
	 * �ַ��ָ
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord2(String s) {
		int length = 0;
		char[] chars = s.toCharArray();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (length == 0) {			 
				if (chars[i] == ' ') {					 
					continue;
				} else {
					length++;
				}
			} else {
				if (chars[i] == ' ') {
					break;
				} else {
					length++;
				}
			}
		}
		return length;
	}
}
