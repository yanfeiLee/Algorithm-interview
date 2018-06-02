package com.lyf.simple;

import org.junit.Test;

/**
 * @function 给定一个字符串(全小写)，最多删除其中一个字符，使其变为回文【正读反读结果都一样】
 * 思路：双指针算法。从两头走到中间，发现第一对不一样的字符之后，要么删左边的，要么删右边的。
 * @author Administrator
 * @date 2018年3月13日 上午9:41:21
 *
 */
public class ValidPalindrome {

	@Test
	public void test() {
		System.err.println((int) 's');
		if("s" == "s"){
			System.out.println("相等");
		}
		String s = "akcbbca";
		if (isPalindrome(s)) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
	}
	/**
	 * 对称性判断
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				break;
			}
			left++;
			right--;
		}
		if (left >= right) {
			return true;
		}
		return isSubPalindrome(s, left + 1, right) || isSubPalindrome(s, left, right - 1);
	}
	/**
	 * 出现不对称时，左右移动一位，接着判断子串
	 * @param s
	 * @param left
	 * @param right
	 * @return
	 */
	private boolean isSubPalindrome(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}
}
