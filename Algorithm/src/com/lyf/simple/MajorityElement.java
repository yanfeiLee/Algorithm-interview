package com.lyf.simple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 *@function Majority Element  给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 *		Note:You may assume that the array is non-empty and the majority number always exist in the array.
 *		Example: 给出数组[1,1,1,1,2,2,2]，返回 1		
 *@author Administrator
 *@date 2018年5月3日 上午11:18:22 
 *
 */
public class MajorityElement {

	@Test
	public void test() {
		
	}
	
	public int majorityNumber(List<Integer> nums) {
		Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int tmp = 0,res = 0;	 
		for(Integer i:nums){
			if(!hm.containsKey(i)){
				tmp = 1;
			}else{
				tmp = hm.get(i)+1;
			}
			hm.put(i, tmp);			
			res = i;
			if(tmp > nums.size()/2){
				break;
			}
		}		 
		return res;        
    }
	
 	
	/**  Moore’s Voting Algorithm
	 * 这个算法主要希望解决如下问题： 
	  给定一个序列，查看里面是否有大多数的元素（majority，>=n/2），如果有找出最大的元素。
                 为了解决该问题，moore 算法需要进行两次遍历，第二次遍历是对第一次的结果的验证。
		第一次遍历是：从0到n，先判断count是否为0，如果count=0，那么当前元素就设为大多数元素，
		       然后接下来比较majority是否与当前元素相同，相同，count++,否则count–。最后的元素即为候选majority， 
		然后在第二遍遍历确认。当然对本题而言就不需要第二步了。
	如何证明它呢？ 
			那我们想，如果一个序列里面有k个majority，那么就有n-k个non-majority，我们不妨将non-majority当作一个整体，
			变成同一数（并不会影响程序的正确性）。那么此时序列里面就变成了两种元素。不失一般性，不妨令第一个元素为majority
			（此时恰好为non-majority的元素）。那么count最多到n-k。再然后就一定是majority的元素，那么最多需要n-k个，
			count就会变成0，此时总共经历了2n-2k，还剩余2k-n个元素，因为k大于n/2，所以，剩余元素个数为正数，而且全为majority。 
	 * @param nums
	 * @return
	 */
	public int majorityNumber2(List<Integer> nums) {
		Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int count = 0,res = 0;	 
		for(Integer i:nums){
			 if(0 == count){
				 res = i;
			 }
			 if(res == i){
				 count++;
			 }else{
				 count--;
			 }
			 if(count > nums.size()/2){
				 break;
			 }
		}		 
		return res;        
    }
}
