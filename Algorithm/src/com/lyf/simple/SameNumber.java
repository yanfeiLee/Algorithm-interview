package com.lyf.simple;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 *@function 给一个数组，如果数组中存在相同数字，且相同数字的距离小于给定值k，输出YES，否则输出NO。
 *		Example:
 *			 给出 array = [1,2,3,1,5,9,3], k = 4, 返回 "YES"。
 *			 index为3的1和index为0的1距离为3，满足题意输出YES。
 *			给出 array =[1,2,3,5,7,1,5,1,3], k = 4, 返回 "YES"。
 *			index为7的1和index为5的1距离为2，满足题意。
 *@author Administrator
 *@date 2018年4月23日 上午10:55:09 
 *
 */
public class SameNumber {

	@Test
	public void test() {
		int[] nums = {1,2,3,12,1,11,2,1,3};
		System.out.println(sameNumber(nums, 2));
	}
	/**
	 * 只要出现相同数字，长度小于k即可
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
