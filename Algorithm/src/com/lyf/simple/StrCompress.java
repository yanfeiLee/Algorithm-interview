package com.lyf.simple;

import org.junit.Test;

/**
 *@function  设计一种方法，通过给重复字符计数来进行基本的字符串压缩。
 *		例如，字符串 aabcccccaaa 可压缩为 a2b1c5a3 。而如果压缩后的字符数不小于原始的字符数，则返回原始的字符串。
 *			可以假设字符串仅包括a-z的字母。
 *
 *			Examples:
 *				str=aabcccccaaa 返回 a2b1c5a3
				str=aabbcc 返回 aabbcc
				str=aaaa 返回 a4
 *@author Administrator
 *@date 2018年4月17日 上午9:19:07 
 *
 */
public class StrCompress {

	@Test
	public void test() {
		String str= "asd";
		System.out.println(compress(str));
	}
	/**
	 * 挨个比较i和i+1(越界问题)统计，在循环结束时，统计最后一次的结果，
	 * 比较结果和原字符串的长度，若res()>=str.length() 则不压缩，返回res
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
		//收尾
		res += c + String.valueOf(cnt);
		if(res.length() >= len){  // "abc" return "abc" 而不是a1b1c1
			res = str;
		}
		return res;
    }
}
