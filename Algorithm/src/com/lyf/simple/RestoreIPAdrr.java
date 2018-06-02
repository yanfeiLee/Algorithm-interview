package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @function ��һ����������ɵ��ַ������������ָܻ�Ϊ������IP��ַ�� Examples: �����ַ���
 *           "25525511135"�����п��ܵ�IP��ַΪ�� [ "255.255.11.135", "255.255.111.35" ]
 *           ˳���޹ؽ�Ҫ
 * @author Administrator
 * @date 2018��4��8�� ����4:11:59
 *
 */
public class RestoreIPAdrr {

	@Test
	public void test() {
		String s = "12345678";
		List<String> res = restoreIpAddresses2(s);
		for (String i : res) {
			System.out.println(i);
		}
		/*
		 * int a = 10; int b = 22; int c = 122; String tmp = a +""+b +""+c +"";
		 * System.out.println(tmp.length());
		 */
	}

	/**
	 * ��ͳ����������+��� �ж� Note: 1.��һλ�õ���ֵ���ڡ�0-255�� 2.�ָ����ַ����ȣ����ƴ�Ӻ�����ԭ���ĳ���
	 * 
	 * @param s
	 * @return
	 */
	public List<String> restoreIpAddresses(String s) {
		// write your code here
		List<String> res = new ArrayList<String>();
		int len = s.length();
		// �ַ����Ϸ����ȼ��
		if (len < 4 || len > 12)
			return null;
		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				for (int m = 1; m < 4; m++) {
					for (int k = 1; k < 4; k++) {
						if (len == i + j + m + k) {
							int p1 = Integer.parseInt(s.substring(0, i));
							int p2 = Integer.parseInt(s.substring(i, i + j));
							int p3 = Integer.parseInt(s.substring(i + j, i + j + m));
							int p4 = Integer.parseInt(s.substring(i + j + m, len));
							String tmp = p1 + "" + p2 + "" + p3 + "" + p4 + "";
							if (tmp.length() != len)
								continue;
							if (p1 >= 0 && p1 < 256 && p2 >= 0 && p2 < 256 && p3 >= 0 && p3 < 256 && p4 >= 0
									&& p4 < 256) {
								res.add(p1 + "." + p2 + "." + p3 + "." + p4);
							}
						}
					}
				}
			}
		}
		return res;
	}

	/**
	 * �ݹ��ж�
	 * @param s
	 * @return
	 */
	public ArrayList<String> restoreIpAddresses2(String s) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();

		if (s.length() < 4 || s.length() > 12)
			return result;

		helper(result, list, s, 0);
		return result;
	}

	public void helper(ArrayList<String> result, ArrayList<String> list, String s, int start) {
		//����λ�ö���ֵʱ���ж�
		if (list.size() == 4) {
			//�ַ���δȫ���������
			if (start != s.length())
				return;

			StringBuffer sb = new StringBuffer();
			for (String tmp : list) {
				sb.append(tmp);
				sb.append(".");
			}
			sb.deleteCharAt(sb.length() - 1);
			result.add(sb.toString());
			return;
		}

		for (int i = start; i < s.length() && i < start + 3; i++) {
			String tmp = s.substring(start, i + 1);
			if (isvalid(tmp)) {
				list.add(tmp);
				helper(result, list, s, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
	/**
	 * ip��ַÿλ�ĺϷ���У��
	 * @param s
	 * @return
	 */
	private boolean isvalid(String s) {
		if (s.charAt(0) == '0')
			return s.equals("0"); // to eliminate cases like "00", "10"
		int digit = Integer.valueOf(s);
		return digit >= 0 && digit <= 255;
	}
}
