package com.lyf.simple;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

/**
 *@function  计算连续子数组的和为k的个数 
 * Given an array of integers and an integer k, you need to
 * find the total number of continuous subarrays whose sum equals to k.
 * Example:
 * 	Input:nums = [1,1,1], k = 2
 *  Output: 2
 *@author Administrator
 *@date 2018年4月10日 上午10:38:40 
 *
 */
public class SubArraySum {

	@Test
	public void test() {
		int[] nums = {-10,3,2,-6,-6,0,0,0,-7,15,-5,5,-8,-3,-5,1,-2,-2,8,-8,6};
		int k = 15;
		System.out.println(getNumSubArray4(nums, k));
	}
	/**
	 * 暴力解法，直接遍历查找，时间复杂度高【超时】
	 * @param nums
	 * @param k
	 * @return
	 */
	public int getNumSubArray(int[] nums, int k){
		int res = 0;		  
		int len = nums.length;		 		 
		int tmpSum = 0;	
		for (int j = 1; j <= len; j++) {
			for (int m = 0; m <= len - j; m++) {
				for (int i = m; i < m+j; i++) {
					tmpSum += nums[i];					
				}
				if(k == tmpSum){						 
					res++;					
				}
				tmpSum = 0;				 
			}				
		}				 
		return res;
//		int count = 0;
//        for (int start = 0; start < nums.length; start++) {
//            for (int end = start + 1; end <= nums.length; end++) {
//                int sum = 0;
//                for (int i = start; i < end; i++)
//                    sum += nums[i];
//                if (sum == k)
//                    count++;
//            }
//        }
//        return count;
	}
	/**
	 * 累加 判断[超时]
	 * @param nums
	 * @param k
	 * @return
	 */
	public int getNumSubArray2(int[] nums, int k){
		int res = 0, n = nums.length;
        int[] sums = nums;
        //每一个数都表示前边的数之和
        for (int i = 1; i < n; ++i) {
            sums[i] = sums[i - 1] + nums[i];
        }
        //遍历，累加后的结果
        for (int i = 0; i < n; ++i) {
        	//相等添加
            if (sums[i] == k) ++res;
            //判断以此数为结尾的，不同长度的数组的和，依此减去前边的数
            for (int j = i - 1; j >= 0; --j) {
                if (sums[i] - sums[j] == k) ++res;
            }
        }
        return res;
	}
	/**
	 *  暴力解法【超时】
	 * @param nums
	 * @param k
	 * @return
	 */
	public int getNumSubArray3(int[] nums, int k){
		int res = 0, n = nums.length;
		for (int i = 0; i < n; ++i) {
		    int sum = nums[i];
		    if (sum == k) ++res;
		    for (int j = i + 1; j < n; ++j) {
		        sum += nums[j];
		        if (sum == k) ++res;
		    }
		}
		return res;
	}
	/**
	 * 利用hashMap 实现
	 * @param nums
	 * @param k
	 * @return
	 */
	public int getNumSubArray4(int[] nums, int k){
		int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap <Integer,Integer> ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            int v = 0;
            if(map.containsKey(sum)){
            	v = map.get(sum)+1;
            }else{
            	v = 1;
            }
            map.put(sum, v);
        }
        return count;
	}
}
