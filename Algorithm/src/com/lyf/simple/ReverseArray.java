package com.lyf.simple;

import java.lang.reflect.Array;

import org.junit.Test;

/**
 * 不借助额外的变量，反转一个整型数组
 * @author Administrator
 *
 */
public class ReverseArray {

	@Test
	public void test(){
		int[] nums = new int[]{1,2,3};
		nums = reverseArr(nums);		
		for(int num:nums){
			System.out.print(num+" ");	
		}		
	}
	
	/**
	 * 整型数组反转
	 * @param A
	 * @return
	 */
	public int[] reverseArr(int[] A){
		if(null == A) return null;
		int len = A.length;
		for(int i = 0; i < len/2 ;i++){
			A[i] = A[len-i-1] - A[i];
			A[len-i-1] = A[len-i-1] - A[i];
			A[i] = A[len-i-1] + A[i];
		}		
		return A;
	}
}
