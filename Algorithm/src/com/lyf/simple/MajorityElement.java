package com.lyf.simple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 *@function Majority Element  ����һ���������飬�ҳ���Ԫ�أ����������еĳ��ִ����ϸ��������Ԫ�ظ����Ķ���֮һ��
 *		Note:You may assume that the array is non-empty and the majority number always exist in the array.
 *		Example: ��������[1,1,1,1,2,2,2]������ 1		
 *@author Administrator
 *@date 2018��5��3�� ����11:18:22 
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
	
 	
	/**  Moore��s Voting Algorithm
	 * ����㷨��Ҫϣ������������⣺ 
	  ����һ�����У��鿴�����Ƿ��д������Ԫ�أ�majority��>=n/2����������ҳ�����Ԫ�ء�
                 Ϊ�˽�������⣬moore �㷨��Ҫ�������α������ڶ��α����ǶԵ�һ�εĽ������֤��
		��һ�α����ǣ���0��n�����ж�count�Ƿ�Ϊ0�����count=0����ô��ǰԪ�ؾ���Ϊ�����Ԫ�أ�
		       Ȼ��������Ƚ�majority�Ƿ��뵱ǰԪ����ͬ����ͬ��count++,����count�C������Ԫ�ؼ�Ϊ��ѡmajority�� 
		Ȼ���ڵڶ������ȷ�ϡ���Ȼ�Ա�����ԾͲ���Ҫ�ڶ����ˡ�
	���֤�����أ� 
			�������룬���һ������������k��majority����ô����n-k��non-majority�����ǲ�����non-majority����һ�����壬
			���ͬһ����������Ӱ��������ȷ�ԣ�����ô��ʱ��������ͱ��������Ԫ�ء���ʧһ���ԣ��������һ��Ԫ��Ϊmajority
			����ʱǡ��Ϊnon-majority��Ԫ�أ�����ôcount��ൽn-k����Ȼ���һ����majority��Ԫ�أ���ô�����Ҫn-k����
			count�ͻ���0����ʱ�ܹ�������2n-2k����ʣ��2k-n��Ԫ�أ���Ϊk����n/2�����ԣ�ʣ��Ԫ�ظ���Ϊ����������ȫΪmajority�� 
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
