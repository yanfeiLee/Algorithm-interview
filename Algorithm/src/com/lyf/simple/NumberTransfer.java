package com.lyf.simple;

import org.junit.Test;

/**
 *@function 给一个转换规则来转换数字n：
			n是奇数，n = 3n + 1
			n是偶数，n = n / 2
			经过若干次转换后，n会变成1。
		现在给一个n，输出它转换到1需要的次数。
		
		Examples:
			给出 n = 2, 返回 1. 【2→1】
			给出 n = 3, 返回 7.【3→10→5→16→8→4→2→1】
 *@author Administrator
 *@date 2018年4月23日 上午10:00:50 
 *
 */
public class NumberTransfer {

	@Test
	public void test() {
//		System.out.println();
//		System.out.println(19.0%1);
//		System.out.println(0==0.0);
		System.out.println(digitConvert(2));
	}
	
	public int digitConvert(int n) { 
		int cnt = 0;
		if(1== n || 0 == n) return cnt;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if(1 == (n & 1)){ //奇数
				n = n*3 + 1;				
			}else{
				double tmpCnt = Math.log(n)/Math.log(2);
				if(0 == (tmpCnt)%1){
					return (int)(tmpCnt + cnt);
				}else{
					n /= 2;
				}				
			}
			cnt++;
		}
		return cnt;
        // Write your code here 
    }
}
