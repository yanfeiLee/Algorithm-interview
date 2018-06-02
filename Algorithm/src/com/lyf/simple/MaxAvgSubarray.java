package com.lyf.simple;

import java.text.DecimalFormat;

import org.junit.Test;

/**
 * @function Given an array consisting of n integers, find the contiguous
 *           subarray of given length k that has the maximum average value. And
 *           you need to output the maximum average value. Example: Given nums =
 *           [1,12,-5,-6,50,3], k = 4, return 12.75 Explanation: Maximum average
 *           is (12-5-6+50)/4 = 51/4 = 12.75
 * @author Administrator
 * @date 2018��3��23�� ����9:10:28
 *
 */
public class MaxAvgSubarray {

	@Test
	public void test() {
		int[] nums = { 1, 12, -5, -6, 50, 3 };
		System.out.println(getMaxAvgSubarray2(nums, 4));
	}

	/**
	 * ÿ��ѭ������ ƽ��ֵ
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public double getMaxAvgSubarray(int[] nums, int k) {
		double res = Double.MIN_VALUE;
		int num = 0;
		int len = nums.length;
		if (k > len)
			return 0;
		DecimalFormat df = new DecimalFormat("0.00");
		for (int i = 0; i < len - k + 1; i++) {
			for (int j = i; j < i + k; j++) {
				num += nums[j];
			}
			System.out.println((double) num / k);
			if (res < (double) num / k) {
				res = (double) num / k;
			}
			num = 0;
		}
		return new Double(df.format(res));
	}

	/**
	 * ÿ��ֻ�����ڵ���β����
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public double getMaxAvgSubarray2(int[] nums, int k) {
		double res = Double.MIN_VALUE;
		int num = 0;
		int len = nums.length;
		if (k > len)
			return 0;
		DecimalFormat df = new DecimalFormat("0.00");
		for (int i = 0; i < k; i++) {
			num += nums[i];
		}
		res = (double) num / k; // ��һ���������ƽ��ֵ
		// ֻ�仯��β����
		for (int i = 1; i < len - k + 1; i++) {
			num = num - nums[i - 1] + nums[i + k - 1];
			System.out.println((double) num / k);
			if (res < (double) num / k) {
				res = (double) num / k;
			}
		}
		return new Double(df.format(res));
	}
}
