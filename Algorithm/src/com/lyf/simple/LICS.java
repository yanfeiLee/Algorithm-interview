package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/**
 *@function ����һ���������飨�±�� 0 �� n-1�� n ��ʾ��������Ĺ�ģ����
 *  ���ҳ��������е���������������С�����������������п��Զ���Ϊ���ҵ��������ҵ����С���
 *	Examples:
 *		���� [5, 4, 2, 1, 3], ����������������У�LICS��Ϊ [5, 4, 2, 1], ���� 4.
 *		���� [5, 1, 2, 3, 4], ����������������У�LICS��Ϊ [1, 2, 3, 4], ���� 4.
 *@author Administrator
 *@date 2018��4��12�� ����9:08:26 
 *
 */
public class LICS {

	@Test
	public void test() {
		int[] A = {5, 4, 2, 1, 3};
		System.out.println(longestIncreasingContinuousSubsequence2(A));
	}
	/**
	 * ��ȡ����������еĳ���,ÿ�θ��µ�����������������ߵݼ�����������������������ս��
	 * @param A
	 * @return
	 */
	public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
		if(0 == A.length) return 0;
		int cnt = 0; 
		int inc = 0;
		int dec = 0;
		int tmp = 0;
		boolean flag = false;
		for (int i = 0; i < A.length-1; i++) {
			if(A[i+1] > A[i]){
				if(!flag){
					tmp++;
					dec = tmp > dec ? tmp:dec; 
					tmp = 0;
				}
				flag = true;				
				tmp++;
			}else if(A[i+1] < A[i]){
				if(flag){
					tmp++;
					inc = tmp > inc ? tmp :inc;
					tmp = 0;					
				}
				flag = false;
				tmp++;
			}else{
				continue;
			}
		}
		tmp++;
		if(!flag){			
			dec = tmp > dec ? tmp:dec; 
		}else{
			inc = tmp > inc ? tmp :inc;
		}
		cnt = dec > inc ? dec : inc;
		return cnt;
    }
	
	/**
	 * ÿ�θ������ս��
	 * @param A
	 * @return
	 */
	public int longestIncreasingContinuousSubsequence2(int[] A) {
        // write your code here
		if(0 == A.length) return 0;
		int cnt = 1; 
		int inc = 1;
		int dec = 1;
		int tmp = 0;
		for (int i = 0; i < A.length-1; i++) {
			if(A[i+1] > A[i]){
				inc++;
				dec = 1;
			}else if(A[i+1] < A[i]){
				dec++;
				inc = 1;
			}
			cnt = Math.max(cnt, Math.max(inc, dec));
		}		 	
		return cnt;
    }
}
