package com.lyf.simple;

import org.junit.Test;

/**
 *@function https://www.lintcode.com/problem/largest-palindrome-product/description
 *@author Administrator
 *@date 2018��5��28�� ����9:35:03 
 *
 */
public class LargestPalindrome {

	@Test
	public void test() {
		System.out.println(createPalindrome(98));
	}
    public int largestPalindrome(int n) {        
    	 if (n == 1) {
             return 9;
         }
    	 //�������ֵķ�Χ
         int high = (int) Math.pow(10, n) - 1, low = high / 10;

         for (int i = high; i > low; i--) {
             long palindrome = createPalindrome(i);
             
             for (long j = high; j > low; j--) {
                 if (palindrome / j > high) {
                     break;
                 }
                 //����
                 if (palindrome % j == 0) {
                     return (int) (palindrome % 1337);
                 }
             }
         }
         return -1;
    }
    //����С���ִ�����������
    private long createPalindrome(long num) {
        String str = num + new StringBuilder(Long.toString(num)).reverse().toString();
        return Long.parseLong(str);
    }
}
