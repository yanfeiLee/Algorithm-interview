package com.lyf.simple;

import org.junit.Test;

/**
 *@function ��һ��ת��������ת������n��
			n��������n = 3n + 1
			n��ż����n = n / 2
			�������ɴ�ת����n����1��
		���ڸ�һ��n�������ת����1��Ҫ�Ĵ�����
		
		Examples:
			���� n = 2, ���� 1. ��2��1��
			���� n = 3, ���� 7.��3��10��5��16��8��4��2��1��
 *@author Administrator
 *@date 2018��4��23�� ����10:00:50 
 *
 */
public class NumberTransfer {

	@Test
	public void test() {
//		System.out.println();
//		System.out.println(19.0%1);
//		System.out.println(0==0.0);
		System.out.println(digitConvert(2));
	}
	
	public int digitConvert(int n) { 
		int cnt = 0;
		if(1== n || 0 == n) return cnt;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if(1 == (n & 1)){ //����
				n = n*3 + 1;				
			}else{
				double tmpCnt = Math.log(n)/Math.log(2);
				if(0 == (tmpCnt)%1){
					return (int)(tmpCnt + cnt);
				}else{
					n /= 2;
				}				
			}
			cnt++;
		}
		return cnt;
        // Write your code here 
    }
}
