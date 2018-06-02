package com.lyf.simple;

import org.junit.Test;

/**
 * �ж�һ���Ǹ����� n �Ķ����Ʊ�ʾ�Ƿ�Ϊ������
 * 	���Ǳ�֤ 0 <= n <= 2^32 - 1
 * @function
 * @author Administrator
 * @date 2018��5��14�� ����9:45:52
 *
 */
public class ParlindromeII {

	@Test
	public void test() {
		System.out.println(this.isPalindrome(Long.parseLong("4294967295")));
//		System.out.println(Math.pow(2, 32));
//		System.out.println(4294967295);
	}

	public boolean isPalindrome(long n) {		
		if(0 > n || n > Math.pow(2, 31)-1 ) return false;
		String binaryString = Long.toBinaryString(n);		 
		int len = binaryString.length();
		for(int i=0; i<len/2; i++){
			if(binaryString.charAt(i) != binaryString.charAt(len-i-1)){
				return false;
			}
		}
		return true;
	}
	
	
}
