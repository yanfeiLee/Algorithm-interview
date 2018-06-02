package com.lyf.simple;

import org.junit.Test;

/**
 *@function  https://www.lintcode.com/problem/binary-number-with-alternating-bits/description
 *@author Administrator
 *@date 2018年5月28日 上午8:29:18 
 *
 */
public class HasAlternatingBits {

	@Test
	public void test() {

	}
	
    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        for (int i = 0; i < binary.length()-1; i++) {
			if(binary.charAt(i) == binary.charAt(i+1)){
				return false;
			}
		}
    	return true;
    }
}
