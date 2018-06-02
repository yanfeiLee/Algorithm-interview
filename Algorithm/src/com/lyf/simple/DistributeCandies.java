package com.lyf.simple;

import java.util.Arrays;

import org.junit.Test;

/**  
 *@function  https://www.lintcode.com/problem/distribute-candies/description
 *@author Administrator
 *@date 2018年6月2日 上午10:08:39 
 *
 */
public class DistributeCandies {

	@Test
	public void test() {
		int[] candies  ={1,1,2,2,3,3,3,3};
		System.out.println(distributeCandies(candies));
	}
	//计算最大不同数个数，
    public int distributeCandies(int[] candies) {
    	 int len = candies.length;
    	 if(0 == len) return 0;
    	 Arrays.sort(candies);
    	 int cnt  = 1;
    	 for (int i = 1; i < len-1; i++) {
    		 if(candies[i] != candies[i+1]){
    			 cnt++;
    		 }
    	 }
         return cnt > len/2 ? len/2 : cnt;
    }
}
