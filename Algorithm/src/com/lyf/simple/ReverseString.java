package com.lyf.simple;

import org.junit.Test;

/**
 *@function   ����һ���ַ����������ת�ַ����е�ÿ�����ʡ�
 *		Note:
 *			���ʵĹ��ɣ��޿ո���ĸ����һ������
			�����ַ����Ƿ����ǰ������β��ո񣿿��԰��������Ƿ�ת����ַ����ܰ���
			��δ����������ʼ�Ķ���ո��ڷ�ת�ַ����м�ո���ٵ�ֻ��һ��
 *@author Administrator
 *@date 2018��4��23�� ����11:42:50 
 *
 */
public class ReverseString {

	@Test
	public void test() {
		String s = "   I am   Balcke  ";	 
//		System.out.println(s.trim());
//		System.out.println(s.trim().split(" ").length);
//		System.out.println(s.trim().split(" ")[1]);
//		System.out.println(s.trim().split(" ")[2]);
		System.out.println(reverseWords(s));
	}
	/**
	 * ����jdk��StringBuffer �����reverse����
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
        // write your code here
		String sTmp = s.trim();  //ȥ����λ�ո�
		String[] sArr = sTmp.split(" ");
		StringBuffer sbRes = new StringBuffer();
		
		for (int i = 0; i < sArr.length; i++) {
			if("".equals(sArr[i])){
				continue;
			}
			StringBuffer sb = new StringBuffer();
			sbRes.append(sb.append(sArr[i]).reverse().toString()+" ");			 
		}
		return sbRes.toString();
    }
	public String reverseWords2(String s) {
        // write your code here
		String sTmp = s.trim();  //ȥ����λ�ո�		 
		String[] sArr = sTmp.split(" ");
		StringBuffer sbRes = new StringBuffer();
		System.out.println(sArr.length);
		for (int i=sArr.length-1; i > 0; i--) {			
			if(!"".equals(sArr[i])){				
				sbRes.append(sArr[i]+" ");
			}			
		}
		return sbRes.append(sArr[0]).toString();
    }
}
