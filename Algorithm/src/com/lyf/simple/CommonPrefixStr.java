package com.lyf.simple;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @function 给k个字符串，求出他们的最长公共前缀(LCP) 在 "ABCD" "ABEF" 和 "ACEF" 中, LCP 为 "A" 在
 *           "ABCDEFG", "ABCEFG", "ABCEFA" 中, LCP 为 "ABC"
 * @author Administrator
 * @date 2018年3月20日 上午9:44:23
 *
 */
public class CommonPrefixStr {

	@Test
	public void test() {
		// String[] strs = {"ABCDEFG","ABCEFG","ABCEFA"};
		String[] strs = { "mqwasfsafsafe", "mqwaasfsafsaf", "mqwasfsafsaf", "mqwhyyyyassfsf" };
		System.out.println(getCommonPrefix2(strs));
		// String s = "ABCDEFG";
		// System.out.println(s.toCharArray()[0]);

	}

	/**
	 * 思路： 找出最短的字符串，作为标杆，依此与其他字符串各字符比较，不相同则将标杆的当前位置置0，循环
	 * 
	 * @param strs
	 * @return
	 */
	public String getCommonPrefix(String[] strs) {
		String s = "";
		int len = strs.length;
		if (0 == len)
			return s;
		
		//查找长度最小的字符串的索引
		int minLen = strs[0].length();
		int minIndex = 0;
		for (int i = 0; i < len; i++) {
			if (minLen > strs[i].length()) {
				minLen = strs[i].length();
				minIndex = i;
			}
		}
		if (0 == minLen)
			return s;
		//比较确定公共串
		char[] tmpArr = strs[minIndex].toCharArray();
		for (int i = 0; i < len; i++) {
			int tLen = tmpArr.length;
			int sLen = strs[i].length();
			for (int j = 0; j < sLen && j < tLen; j++) {
				if(0 == tmpArr[j]) break; // 存在0,后续就不需判断，直接下一个字符串判断
				if (strs[i].charAt(j) != tmpArr[j]) {
					tmpArr[j] = 0; //不相等则置0					 
				}
			}
		}
		//拼接
		for (char c : tmpArr) {
			if (0 != c)
				s += c;
		}
		return s;
	}

	/**
	 * 将第一个字符串左为标杆，依此与其他字符串比较，获取公共长度，然后截取其，
	 * 依此比较，得到最后字符串
	 * @param strs
	 * @return
	 */
	public String getCommonPrefix2(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			while (j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
				j++;
			}
			if (j == 0) {
				return "";
			}
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}
	
	
}
