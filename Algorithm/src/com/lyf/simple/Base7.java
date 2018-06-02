package com.lyf.simple;

import org.junit.Test;

/**
 *@function  https://www.lintcode.com/problem/base-7/description
 *@author Administrator
 *@date 2018年5月21日 下午12:01:13 
 *
 */
public class Base7 {

	@Test
	public void test() {
		System.out.println(convertToBase7(-7));
	}
    public String convertToBase7(int num) {
    	if(0 == num) return "0";
        StringBuffer sb = new StringBuffer();
        int remainder = 0;       
        boolean flag = false;
        if(num < 0) {
        	flag = true;
        	num = Math.abs(num);
        }
        do{
        	remainder = num % 7; 
        	num = num / 7;        	       	
        	sb.append(remainder+"");        	 
        }while(num != 0);
        String res = sb.reverse().toString();
    	return flag ? "-"+res : res;
    }
}
