package com.lyf.simple;

import org.junit.Test;

/**
 *@function ���Ҫ������Aת��ΪB����Ҫ�ı���ٸ�bitλ��
 *		  Note:Both n and m are 32-bit integers.
 *		  Example:
 *			���31ת��Ϊ14����Ҫ�ı�2��bitλ��
 *			(31)10=(11111)2
 *			(14)10=(01110)2
 *@author Administrator
 *@date 2018��4��18�� ����10:03:21 
 *
 */
public class BitSwapCount {

	@Test
	public void test() {
		int i = 11;
		System.out.println(1^-1);
		System.out.println("==" + ((1^-1)&1));
		System.out.println(Integer.toBinaryString(-2));
		System.out.println(bitSwapRequired3(1, -1));
	}
	/**
	 * ����תΪ�����ƽ�������Ƚ�
	 * @param a
	 * @param b
	 * @return
	 */
	public int bitSwapRequired(int a, int b) {
        // write your code here
        int res = 0;
        String aStr = Integer.toBinaryString(a);
        String bStr = Integer.toBinaryString(b);
        int aLen = aStr.length(),bLen = bStr.length();
        for (int i = 31; i >= aLen || i >= bLen; i--) {
        	if(aStr.length() != 32){
        		aStr = "0" + aStr;
        	}
        	if(bStr.length() != 32){
        		bStr = "0" + bStr; 
        	}			
		}         
        System.out.println(aStr);
        System.out.println(bStr);
        for (int i = 0; i < 32; i++) {
        	if(aStr.charAt(i) != bStr.charAt(i)){
        		res++;
        	}
		}        
        return res;
    }
	/**
	 * �������
	 * @param a
	 * @param b
	 * @return
	 */
	public int bitSwapRequired2(int a, int b) {
		int res = 0;
		int tmp = a ^ b;
		String tmpStr = Integer.toBinaryString(tmp);
		for (int i = 0; i < tmpStr.length(); i++) {
			if('1' == tmpStr.charAt(i)) res++;
		}
		return res;		
	}
	/**
	 * ��� ����λ����
	 * @param a
	 * @param b
	 * @return
	 */
	public int bitSwapRequired3(int a, int b) {
		 int count = 0;  
	     for (int c = a ^ b; c != 0; c = c >>> 1) {
	         count += c & 1;
	     }
	     return count;
	}	
}
