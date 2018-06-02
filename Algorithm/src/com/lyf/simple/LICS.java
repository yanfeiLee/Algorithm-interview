package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/**
 *@function 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），
 *  请找出该数组中的最长上升连续子序列。（最长上升连续子序列可以定义为从右到左或从左到右的序列。）
 *	Examples:
 *		给定 [5, 4, 2, 1, 3], 其最长上升连续子序列（LICS）为 [5, 4, 2, 1], 返回 4.
 *		给定 [5, 1, 2, 3, 4], 其最长上升连续子序列（LICS）为 [1, 2, 3, 4], 返回 4.
 *@author Administrator
 *@date 2018年4月12日 上午9:08:26 
 *
 */
public class LICS {

	@Test
	public void test() {
		int[] A = {5, 4, 2, 1, 3};
		System.out.println(longestIncreasingContinuousSubsequence2(A));
	}
	/**
	 * 获取最长连续子序列的长度,每次更新递增最大连续个数或者递减最大连续个数，最后更新最终结果
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
	 * 每次更新最终结果
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
