package com.lyf.simple;

import org.junit.Test;

/**
 *@function  https://www.lintcode.com/problem/excel-sheet-column-number/description
 *@author Administrator
 *@date 2018年5月28日 上午8:39:45 
 *
 */
public class TitleToNumber {

	@Test
	public void test() {
//		System.out.println((int)'B'- 64);
//		System.out.println(Math.pow(26, 0));
		System.out.println(titleToNumber("A"));
	}
	
    public int titleToNumber(String s) {
        int len = s.length();
        int res  = 0;
        for (int i = 0; i < len; i++) {        	 
			res += getVal(s.charAt(i))*Math.pow(26, len-i-1);
		}
    	return res;
    }
    private int getVal(char c){
    	return (int)c - 64;
    }
}
