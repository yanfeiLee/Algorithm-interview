package com.lyf.simple;

import org.junit.Test;

/**
 *@function   给定一个字符串，逐个翻转字符串中的每个单词。
 *		Note:
 *			单词的构成：无空格字母构成一个单词
			输入字符串是否包括前导或者尾随空格？可以包括，但是反转后的字符不能包括
			如何处理两个单词间的多个空格？在反转字符串中间空格减少到只含一个
 *@author Administrator
 *@date 2018年4月23日 上午11:42:50 
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
	 * 利用jdk的StringBuffer 对象的reverse方法
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
        // write your code here
		String sTmp = s.trim();  //去除首位空格
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
		String sTmp = s.trim();  //去除首位空格		 
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
