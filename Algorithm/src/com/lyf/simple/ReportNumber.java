package com.lyf.simple;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * @function �����n������ ����ָ���ǣ��������е�������˳����б�����Ȼ��õ���һ������������ʾ��
 * 
 *           1, 11, 21, 1211, 111221, ...
 * 
 *           1 ���� "one 1" -> 11.
 * 
 *           11 ���� "two 1s" -> 21.
 * 
 *           21 ���� "one 2, then one 1" -> 1211.
 * 
 *           ����һ������ n, ���� �� n ��˳��
 * @author Administrator
 * @date 2018��3��12�� ����10:57:30
 *
 */
public class ReportNumber {

	@Test
	public void test() {
		System.out.println(countAndSay(2));
	}
	/**
	 * ���㱨��
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
