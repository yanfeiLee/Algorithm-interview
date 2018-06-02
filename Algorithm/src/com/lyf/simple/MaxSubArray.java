package com.lyf.simple;

import org.junit.Test;

/**
 *@function 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 *		Note:子数组最少包含一个数
 *		Example:给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
 *@author Administrator
 *@date 2018年5月18日 上午9:48:57 
 *
 */
public class MaxSubArray {

	@Test
	public void test() {
		int[] nums = { 1,2,-9,-1,0,2,9};
		System.out.println(maxSubArray(nums));
	}
	/**
	 * 贪婪算法，只计算大于0的sum
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0){
            return 0;
        }        
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);  //比较获得最大值
            sum = Math.max(sum, 0); //总和小于0的子数组置为0，使得max持续增大
        }
        return max;
    }
	 //？？？？？
	 public int maxSubArray2(int[] nums) {
	        if (nums == null || nums.length == 0){
	            return 0;
	        }
	        
	        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
	        for (int i = 0; i < nums.length; i++) {
	            sum += nums[i];
	            max = Math.max(max, sum - minSum);
	            minSum = Math.min(minSum, sum);
	        }
	        return max;
	  }
	 //？？？？
	 public int maxSubArray3(int[] nums) {
	        // write your code
	        if(nums.length == 0){
	            return 0; 
	        }
	        int n = nums.length;
	        int[] global = new int[2];
	        int[] local = new int[2];
	        global[0] = nums[0];
	        local[0] = nums[0];
	        
	        for(int i = 1; i < n; i ++) {  
	            local[i % 2] = Math.max(nums[i], local[(i - 1) % 2] + nums[i]);  
	            global[i % 2] = Math.max(local[i % 2], global[(i - 1) % 2]);  
	        }  
	        return global[(n-1) % 2];  
	   }
}
