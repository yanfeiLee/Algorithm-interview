package com.lyf.simple;

import org.junit.Test;

/**
 *@function  ����һ����Ϊn������Ages, ���е�i��0-1000����Ԫ�ر�ʾ��i���˵����䡾0-150���������n���ˣ����͵ĺ�����������������У�
 *1. ���Age(B) <= (1/2)Age(A) + 7, A�����B������
 *2. ���Age(B) > Age(A)�� A�����B������
 *3. ���Age(B) < 100 and Age(A) > 100, A�����B������
 *4. ������1��2��3����A���B������
 *
 *@author Administrator
 *@date 2018��3��17�� ����12:00:13 
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
