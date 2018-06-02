package com.lyf.simple;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @function ��k���ַ�����������ǵ������ǰ׺(LCP) �� "ABCD" "ABEF" �� "ACEF" ��, LCP Ϊ "A" ��
 *           "ABCDEFG", "ABCEFG", "ABCEFA" ��, LCP Ϊ "ABC"
 * @author Administrator
 * @date 2018��3��20�� ����9:44:23
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
	 * ˼·�� �ҳ���̵��ַ�������Ϊ��ˣ������������ַ������ַ��Ƚϣ�����ͬ�򽫱�˵ĵ�ǰλ����0��ѭ��
	 * 
	 * @param strs
	 * @return
	 */
	public String getCommonPrefix(String[] strs) {
		String s = "";
		int len = strs.length;
		if (0 == len)
			return s;
		
		//���ҳ�����С���ַ���������
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
		//�Ƚ�ȷ��������
		char[] tmpArr = strs[minIndex].toCharArray();
		for (int i = 0; i < len; i++) {
			int tLen = tmpArr.length;
			int sLen = strs[i].length();
			for (int j = 0; j < sLen && j < tLen; j++) {
				if(0 == tmpArr[j]) break; // ����0,�����Ͳ����жϣ�ֱ����һ���ַ����ж�
				if (strs[i].charAt(j) != tmpArr[j]) {
					tmpArr[j] = 0; //���������0					 
				}
			}
		}
		//ƴ��
		for (char c : tmpArr) {
			if (0 != c)
				s += c;
		}
		return s;
	}

	/**
	 * ����һ���ַ�����Ϊ��ˣ������������ַ����Ƚϣ���ȡ�������ȣ�Ȼ���ȡ�䣬
	 * ���˱Ƚϣ��õ�����ַ���
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
