package com.lyf.simple;

import org.junit.Test;

/**
 *@function  给定一个长为n的数组Ages, 其中第i【0-1000】个元素表示第i个人的年龄【0-150】。求这个n个人，发送的好友请求的总数。其中，
 *1. 如果Age(B) <= (1/2)Age(A) + 7, A不会给B发请求
 *2. 如果Age(B) > Age(A)， A不会给B发请求
 *3. 如果Age(B) < 100 and Age(A) > 100, A不会给B发请求
 *4. 不满足1，2，3，则A会给B发请求。
 *
 *@author Administrator
 *@date 2018年3月17日 下午12:00:13 
 *
 */
public class FriendsRequest {

	@Test
	public void test() {
		int[] ages = {101,79,11,90,78,23,22};
		System.out.println(getFriendsRequest(ages));
	}
	
	public int getFriendsRequest(int[] ages){		
		int count = 0;
		int len = ages.length;
		if(len > 1000) return len;
		for(int i=0; i< len; i++){
			for (int j = 0; j < len; j++) {				 
				if(i != j){					
					if(ages[i]/2 +7 >= ages[j]) continue;
					if(ages[i] < ages[j])continue;
					if(ages[i]>100 && ages[j]<100 )continue;
					count++;
				}
			}
		}
		return count;
	}
}
