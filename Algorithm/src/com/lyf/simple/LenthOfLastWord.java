package com.lyf.simple;

import org.junit.Test;

/**
 *@function 获取字符串[包含大小写字母、空格' ']最后一个单词的长度，如果不存在最后一个单词，则返回0；
 *@author Administrator
 *@date 2018年3月10日 下午7:24:16 
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
	 * 单词分割法[split函数]，其实split函数基于字符分割实现 
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
	 * 字符分割法
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
