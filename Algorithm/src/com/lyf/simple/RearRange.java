package com.lyf.simple;

import java.util.Arrays;

import org.junit.Test;

/**
 *@function 给一列数组要求重排，必须所有偶数位上的数都小于所有奇数位上的数。同时，偶数位上的数也按照升序排序，奇数位上的也按照升序排序。
 *	给出array = [-1,0,1,-1,5,10], 返回 [-1,1,-1,5,0,10]。
 *	给出array = [2,0,1,-1,5,10], 返回 [-1,2,0,5,1,10]。
 *@author Administrator
 *@date 2018年4月3日 下午3:35:29 
 *
 */
public class RearRange {

	@Test
	public void test() {
//		System.out.println(11/2);
		int[] nums = {2,0,1,-1,5,10};
		int[] res = reIndex(nums);
		for(int i:res){
			System.out.print(i+",");
		}
	}
	
	public int[] reIndex(int[] nums){
		int len = nums.length;
		if(0 == len) return null;
		int[] res  = new int[len];
		int j = 1;
		Arrays.sort(nums);
		for (int i = 0; i < len/2; i++) {//[-1,,-1,,]
			res[i*2] = nums[i];
		}
		for(int i=len/2; i < len; i++){
			res[j] = nums[i];
			j += 2;			
			if(j >= len){
				j = len-1;
			}
		}		
		return res;
	}
}
