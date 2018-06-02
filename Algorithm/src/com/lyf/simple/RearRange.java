package com.lyf.simple;

import java.util.Arrays;

import org.junit.Test;

/**
 *@function ��һ������Ҫ�����ţ���������ż��λ�ϵ�����С����������λ�ϵ�����ͬʱ��ż��λ�ϵ���Ҳ����������������λ�ϵ�Ҳ������������
 *	����array = [-1,0,1,-1,5,10], ���� [-1,1,-1,5,0,10]��
 *	����array = [2,0,1,-1,5,10], ���� [-1,2,0,5,1,10]��
 *@author Administrator
 *@date 2018��4��3�� ����3:35:29 
 *
 */
public class RearRange {

	@Test
	public void test() {
//		System.out.println(11/2);
		int[] nums = {2,0,1,-1,5,10};
		int[] res = reIndex(nums);
		for(int i:res){
			System.out.print(i+",");
		}
	}
	
	public int[] reIndex(int[] nums){
		int len = nums.length;
		if(0 == len) return null;
		int[] res  = new int[len];
		int j = 1;
		Arrays.sort(nums);
		for (int i = 0; i < len/2; i++) {//[-1,,-1,,]
			res[i*2] = nums[i];
		}
		for(int i=len/2; i < len; i++){
			res[j] = nums[i];
			j += 2;			
			if(j >= len){
				j = len-1;
			}
		}		
		return res;
	}
}
