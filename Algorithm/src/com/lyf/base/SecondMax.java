package com.lyf.base;

import org.junit.Test;

/**
 *@function 在数组中找到第二大的数;你可以假定至少有两个数字
 *			Note:如果最大值存在多个，则其中一个即为第二大的数
 *			Example:
 *				给出 [1, 3, 2, 4], 返回 3.
				给出 [1, 2], 返回 1.
 *@author Administrator
 *@date 2018年5月21日 上午9:31:39 
 *
 */
public class SecondMax {

	@Test
	public void test() {
//		int[] nums = {1, 3, 2,999, 4,9,0,90,-2,999};
//		int[] nums = {1,1,1,1};
		int[] nums = {8,7,6,5,4,3,2,1};
//		int[] nums = {1,2,2,1};
		System.out.println(secondMax(nums));
	}
	
    public int secondMax(int[] nums) {
        // write your code here
    	int first = nums[0];
    	int second = nums[1];
    	for (int i = 1; i < nums.length; i++) {
			if(first < nums[i]){
				second = first;
				first = nums[i];
			}else if(second < nums[i]){
				second = nums[i];
			}
		}
    	return second;
    }
    
    public int secondMax2(int[] nums) {
    	int first = Integer.MIN_VALUE;
    	int second = first;
    	boolean flag = true;
    	int index  = Integer.MIN_VALUE;
    	for (int i = 0; i < nums.length; i++) {		 
    		if(first < nums[i]){				    			
    			first = nums[i];
    			index = i;
    		}
		}
    	for (int i = 0; i < nums.length; i++) {
    		if(index == i){
    			flag = false;
    			continue;    			
    		}
			if(second < nums[i]){
				flag = true;
				second = nums[i];
			}
		}
    	if(!flag && second == Integer.MIN_VALUE){
    		second = first;
    	}
    	return second;
    }
}
