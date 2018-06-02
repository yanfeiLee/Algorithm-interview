package com.lyf.simple;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 *@function ��һ�����飬��������д�����ͬ���֣�����ͬ���ֵľ���С�ڸ���ֵk�����YES���������NO��
 *		Example:
 *			 ���� array = [1,2,3,1,5,9,3], k = 4, ���� "YES"��
 *			 indexΪ3��1��indexΪ0��1����Ϊ3�������������YES��
 *			���� array =[1,2,3,5,7,1,5,1,3], k = 4, ���� "YES"��
 *			indexΪ7��1��indexΪ5��1����Ϊ2���������⡣
 *@author Administrator
 *@date 2018��4��23�� ����10:55:09 
 *
 */
public class SameNumber {

	@Test
	public void test() {
		int[] nums = {1,2,3,12,1,11,2,1,3};
		System.out.println(sameNumber(nums, 2));
	}
	/**
	 * ֻҪ������ͬ���֣�����С��k����
	 * @param nums
	 * @param k
	 * @return
	 */
	public String sameNumber(int[] nums, int k) {
         Map<Integer,Integer> mp = new HashMap<Integer, Integer>();
         for (int i = 0; i < nums.length; i++) {
			if(mp.containsKey(nums[i])){
				int start = mp.get(nums[i]);
				if(i - start < k)	return "YES";
			}
			mp.put(nums[i], i);
		}
		return "NO";
    }
}
