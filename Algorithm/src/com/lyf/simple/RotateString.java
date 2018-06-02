package com.lyf.simple;

import org.junit.Test;

/**
 * @function 按照指定的长度，旋转字符串
 * @author Administrator
 * @date 2018年5月3日 上午10:01:42
 *
 */
public class RotateString {

	@Test
	public void test() {
		char[] s = { 'g', 's', 'd', 'p' };
		// System.out.println(String.valueOf(s)+String.valueOf(s));
		rotateString(s, 19);
	}

	public void rotateString(char[] str, int offset) {
		if (str == null || str.length == 0) return;			
		int len = str.length;
		int mv = offset % len;
		String tmp = String.valueOf(str) + String.valueOf(str);
		String res = tmp.substring(len - mv, 2 * len - mv);
		str = res.toCharArray();
		System.out.println(str);
	}	 
}
