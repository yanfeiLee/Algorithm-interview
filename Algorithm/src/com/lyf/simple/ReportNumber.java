package com.lyf.simple;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * @function 计算第n个报数 报数指的是，按照其中的整数的顺序进行报数，然后得到下一个数。如下所示：
 * 
 *           1, 11, 21, 1211, 111221, ...
 * 
 *           1 读作 "one 1" -> 11.
 * 
 *           11 读作 "two 1s" -> 21.
 * 
 *           21 读作 "one 2, then one 1" -> 1211.
 * 
 *           给定一个整数 n, 返回 第 n 个顺序。
 * @author Administrator
 * @date 2018年3月12日 上午10:57:30
 *
 */
public class ReportNumber {

	@Test
	public void test() {
		System.out.println(countAndSay(2));
	}
	/**
	 * 计算报数
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
		if (n <= 0) return "";
		String oldString = "1";
		while (--n > 0) {
			StringBuilder sb = new StringBuilder();
			char[] oldChars = oldString.toCharArray();
			for (int i = 0; i < oldChars.length; i++) {
				int count = 1;
				while ((i + 1) < oldChars.length && oldChars[i] == oldChars[i + 1]) {
					count++;
					i++;
				}
				sb.append(String.valueOf(count) + String.valueOf(oldChars[i]));
			}
			oldString = sb.toString();			 
		}
		return oldString;
	}	 
}
