package com.lyf.simple;

import org.junit.Test;

/**
 *@function  ���һ�ַ�����ͨ�����ظ��ַ����������л������ַ���ѹ����
 *		���磬�ַ��� aabcccccaaa ��ѹ��Ϊ a2b1c5a3 �������ѹ������ַ�����С��ԭʼ���ַ������򷵻�ԭʼ���ַ�����
 *			���Լ����ַ���������a-z����ĸ��
 *
 *			Examples:
 *				str=aabcccccaaa ���� a2b1c5a3
				str=aabbcc ���� aabbcc
				str=aaaa ���� a4
 *@author Administrator
 *@date 2018��4��17�� ����9:19:07 
 *
 */
public class StrCompress {

	@Test
	public void test() {
		String str= "asd";
		System.out.println(compress(str));
	}
	/**
	 * �����Ƚ�i��i+1(Խ������)ͳ�ƣ���ѭ������ʱ��ͳ�����һ�εĽ����
	 * �ȽϽ����ԭ�ַ����ĳ��ȣ���res()>=str.length() ��ѹ��������res
	 * @param str
	 * @return
	 */
	public String compress(String str) {
        // write your code here
		String res = "";
		int cnt = 1;
		int len = str.length();
		char c = ' ';
		for (int i = 0; i < len-1; i++) {
			c = str.charAt(i);
			if(c == str.charAt(i+1)){
				cnt++;
			}else{
				res =res + c + String.valueOf(cnt);
				cnt = 1;				
			}
		}
		//��β
		res += c + String.valueOf(cnt);
		if(res.length() >= len){  // "abc" return "abc" ������a1b1c1
			res = str;
		}
		return res;
    }
}
