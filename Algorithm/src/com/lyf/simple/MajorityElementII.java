package com.lyf.simple;

import java.util.List;

import org.junit.Test;

/**
 *@function  给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的三分之一。
 *@author Administrator
 *@date 2018年5月3日 上午11:59:50 
 *
 */
public class MajorityElementII {

	@Test
	public void test() {

	}
	
	
	/**
	 * 思路:
	 * moore算法的核心说起来非常简单：当我们要找一个大于n/2的数的时候，这样的数只能出现一个，那我们把序列里面所有数归为两类，
	 * 一类是majority，另一类是non-majority。那我们把他们摞在一起，然后从底向上一层一层的削，当某类结束的时候，剩余的一层
	 * 就是majority。 
	 * 如果按照这个思路，那么这道题的思想就一样了。现在是大于n/3的数，那么最多会有两个选择，因为如果有三个的话，那这三个的总和将
	 * 大于n，所以就可以把整个集合分为三类。两个candidate，一个non-candidate。
	 * 还是一样的道理，如果新来一个元素，判断是否与两个candidate元素相同，相同的话就++，如果与二者都不同，那就candidate–
	 * （相当于消去一层）。最后剩余的部分就是两个candidate
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
         //第二次遍历，确认结果
         aCount=bCount=0;
         for(int i:nums){
        	 if(a == i){
        		 aCount++;
        	 }else if(b == i){
        		 bCount++;
        	 }
         }
         if(aCount > nums.size()/3){
        	 res[index++] = a;  //用index减少判断
         }
         if(bCount > nums.size()/3){
        	 res[index++] = b;
         }
         //这里任意返回一个主元素即可【大于n/3,可能最多出现两个主元素】
         return res[0];        
    }
	
	//利用hashMap，统计各个数字出现的个数，然后计算次数大于n/3的元素
}
