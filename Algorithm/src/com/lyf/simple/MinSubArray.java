package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 *@function  ����һ���������飬�ҵ�һ��������С�͵������顣��������С�͡�
			 Note: ���������ٰ���һ������
			  ��������[1, -1, -2, 1]������ -3
 *@author Administrator
 *@date 2018��5��18�� ����10:41:34 
 *
 */
public class MinSubArray {

	@Test
	public void test() {
		Integer[] num = {1, 1, -12, 1};
		List<Integer> nums = Arrays.asList(num);
		System.out.println(minSubArray2(nums));
	}
	/** ̰���㷨��ֻ����С��0 �ĺ�
	 * 
	 */
    public int minSubArray(List<Integer> nums) {
    	int len = nums.size();
    	if(0 == len){
    		return 0;
    	}
    	int sum = 0;
    	int min = Integer.MAX_VALUE;
    	for (int i = 0; i < len; i++) {
			sum += nums.get(i);
			min = Math.min(min, sum);
			sum = Math.min(sum, 0);
		}
        return min;
    }
    /**
     * 
     * @param nums
     * @return
     */
    public int minSubArray2(List<Integer> nums) {
        if (nums == null)
            return 0;
        int len = nums.size();
        int min = Integer.MAX_VALUE, currSum = 0;
        int []localmin  = new int[len];
        int []globalmin = new int[len];
        for (int i = 0; i < len; i++) {
            if( i ==0 )
                globalmin[i] = localmin[i] = nums.get(i);
            else {
                localmin[i] = Math.min(localmin[i - 1] + nums.get(i), nums.get(i));
                globalmin[i] = Math.min(globalmin[i - 1], localmin[i]);
            }
            
        }
        return globalmin[len-1];
    }
}
