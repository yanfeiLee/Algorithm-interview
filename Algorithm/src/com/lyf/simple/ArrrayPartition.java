package com.lyf.simple;

import java.util.ArrayList;
import java.util.*;

import org.junit.Test;

/**
 * @function 数组分割--Given an array of integers nums and a positive integer k,
 *           find whether it's possible to divide this array into k non-empty
 *           subsets whose sums are all equal.
 *
 *           Note: 1. 1 <= k <= len(nums) <= 16. 2. 0 < nums[i] < 10000
 *
 *           Example: Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4 Output: True
 *           Explanation: It's possible to divide it into 4 subsets (5), (1, 4),
 *           (2,3), (2,3) with equal sums.
 * @author Administrator
 * @date 2018年4月9日 下午12:17:30
 *
 */
public class ArrrayPartition {

	@Test
	public void test() {
		int[] nums = { 4, 4, 2, 3, 5, 2, 0};
		int k = 4;
		System.out.println(partitiontoEqualSumSubsets(nums, k));
		System.out.println(1 << nums.length);
		System.out.println(cnt);
	}

	public int[] ret;
	public boolean f = false;
	public int cnt = 0;
	public boolean partitiontoEqualSumSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		int sum = 0;
		int[] a = new int[nums.length]; // 倒序存放nums
		for (int i = 0; i < nums.length; i++) {
			a[i] = nums[nums.length - 1 - i];
			sum += a[i];
		}
		if (sum % k != 0) return false;
		for (int i : a){
			if (i > sum / k) return false;
		}
			
		ret = new int[k];  // 生成长度为k的数组
		dfs(a, sum / k, 0);
		return f;
	}
    /**
     * 深度优先搜索
     * @param a  倒序排列的数组
     * @param target  平均值
     * @param s  已遍历过nums的个数 
     */
	private void dfs(int[] a, int target, int s) {
		cnt++;
		if (f)
			return;
		if (s == a.length) {
			for (int i = 0; i < ret.length; i++){
				if (ret[i] != target) return;
			}			
			f = true;
			return;
		}
		for (int i = 0; i < ret.length; i++) {
			if (ret[i] + a[s] <= target) {
				ret[i] += a[s];
				dfs(a, target, s + 1);
				ret[i] -= a[s];
			}
		}
	}
}
