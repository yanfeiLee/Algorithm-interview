package com.lyf.simple;

import org.junit.Test;

/**
 *@function  Given a string, determine if a permutation of the string could form a palindrome.
 *		Examples:
 *			Given s = "code", return False.
			Given s = "aab", return True.
			Given s = "carerac", return True.
 *@author Administrator
 *@date 2018��4��19�� ����9:12:33 
 *
 */
public class PalindromePermutation {

	@Test
	public void test() {
		String s = "carerac2";
		System.out.println(canPermutePalindrome(s));
	}
	
	public boolean canPermutePalindrome(String s) {
		boolean flag = false;		 	
	    int [] alphabet = new int[26];
	    int cnt = 0;
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        //?????????????? cnt ������
	        if (alphabet[c - 'a'] % 2 == 1) {
	            cnt--;  //����λ��a,c,e,g...	            
	        } else {
	            cnt++;	//ż��λ��b,d,f,h...            
	        }
	        alphabet[c - 'a']++;  //ͬһλ�õ��ַ������ۼ�
	        //��ֵ
	        if (cnt > 1) {
	            flag = false;
	        } else {
	            flag = true;
	        }
	    }
	     
		return flag;
	}
}
