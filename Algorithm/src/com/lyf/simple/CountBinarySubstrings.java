package com.lyf.simple;

import org.junit.Test;

/**
 *@function https://www.lintcode.com/problem/count-binary-substrings/description
 *@author Administrator
 *@date 2018年6月2日 上午10:26:58 
 *
 */
public class CountBinarySubstrings {

	@Test
	public void test() {
		String s = "10011";
		System.out.println(countBinarySubstrings2(s));
	}
    public int countBinarySubstrings(String s) {
    	int pre = 0, cur = 1, res = 0;    	
        for (int i = 1; i != s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                cur++;
            }else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur)
                res++;
        }
        return res;
    }
    //另外的方法
    public int countBinarySubstrings2(String s) {
	    int zeros = 0, ones = 0, res = 0;
	    for (int i = 0; i < s.length(); ++i) {
	        if (i == 0) {
	            if(s.charAt(i) == '1'){
	            	ones++;
	            }else{
	            	zeros++;
	            }
	        } else {
	            if (s.charAt(i) == '1') {
	                ones = (s.charAt(i-1) == '1') ? ones + 1 : 1;
	                if (zeros >= ones) ++res;
	            } else if (s.charAt(i) == '0') {
	                zeros = (s.charAt(i-1) == '0') ? zeros + 1 : 1;
	                if (ones >= zeros) ++res;
	            }
	        }	        
	    }
	    return res;
    }
   
}
