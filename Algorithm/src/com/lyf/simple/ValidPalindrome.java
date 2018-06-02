package com.lyf.simple;

import org.junit.Test;

/**
 * @function ����һ���ַ���(ȫСд)�����ɾ������һ���ַ���ʹ���Ϊ���ġ��������������һ����
 * ˼·��˫ָ���㷨������ͷ�ߵ��м䣬���ֵ�һ�Բ�һ�����ַ�֮��Ҫôɾ��ߵģ�Ҫôɾ�ұߵġ�
 * @author Administrator
 * @date 2018��3��13�� ����9:41:21
 *
 */
public class ValidPalindrome {

	@Test
	public void test() {
		System.err.println((int) 's');
		if("s" == "s"){
			System.out.println("���");
		}
		String s = "akcbbca";
		if (isPalindrome(s)) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
	}
	/**
	 * �Գ����ж�
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
	 * ���ֲ��Գ�ʱ�������ƶ�һλ�������ж��Ӵ�
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
