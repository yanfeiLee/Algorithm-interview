package com.lyf.simple;

import java.util.List;

import org.junit.Test;

/**
 *@function  ����һ���������飬�ҵ���Ԫ�أ����������еĳ��ִ����ϸ��������Ԫ�ظ���������֮һ��
 *@author Administrator
 *@date 2018��5��3�� ����11:59:50 
 *
 */
public class MajorityElementII {

	@Test
	public void test() {

	}
	
	
	/**
	 * ˼·:
	 * moore�㷨�ĺ���˵�����ǳ��򵥣�������Ҫ��һ������n/2������ʱ����������ֻ�ܳ���һ���������ǰ�����������������Ϊ���࣬
	 * һ����majority����һ����non-majority�������ǰ���������һ��Ȼ��ӵ�����һ��һ���������ĳ�������ʱ��ʣ���һ��
	 * ����majority�� 
	 * ����������˼·����ô������˼���һ���ˡ������Ǵ���n/3��������ô����������ѡ����Ϊ����������Ļ��������������ܺͽ�
	 * ����n�����ԾͿ��԰��������Ϸ�Ϊ���ࡣ����candidate��һ��non-candidate��
	 * ����һ���ĵ����������һ��Ԫ�أ��ж��Ƿ�������candidateԪ����ͬ����ͬ�Ļ���++���������߶���ͬ���Ǿ�candidate�C
	 * ���൱����ȥһ�㣩�����ʣ��Ĳ��־�������candidate
	 * @param nums
	 * @return
	 */
	public int majorityNumber(List<Integer> nums) {
         int[] res = new int[2];         
         int a=0,aCount=0,b=0,bCount=0,index=0;
         for(int i:nums){
        	 if(0 == aCount){
        		 a = i;
        	 }else if(0 == bCount){
        		 b = i;
        	 }
        	 
        	 if(a == i){
        		 aCount++;
        	 }else if(b == i){
        		 bCount++;
        	 }else{
        		 aCount--;
        		 bCount--;
        	 }        	
         }
         //�ڶ��α�����ȷ�Ͻ��
         aCount=bCount=0;
         for(int i:nums){
        	 if(a == i){
        		 aCount++;
        	 }else if(b == i){
        		 bCount++;
        	 }
         }
         if(aCount > nums.size()/3){
        	 res[index++] = a;  //��index�����ж�
         }
         if(bCount > nums.size()/3){
        	 res[index++] = b;
         }
         //�������ⷵ��һ����Ԫ�ؼ��ɡ�����n/3,����������������Ԫ�ء�
         return res[0];        
    }
	
	//����hashMap��ͳ�Ƹ������ֳ��ֵĸ�����Ȼ������������n/3��Ԫ��
}
