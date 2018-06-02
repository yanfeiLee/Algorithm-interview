package com.lyf.simple;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 计算第K个质数【素数】在所有质数中的位置		
 * 质数：大于1的数中;只有1和它本身为其因数
 * 对正整数n，如果用2到  之间的所有整数去除，均无法整除，则n为质数
 * @author Administrator
 *
 */
public class KthPrimeNum {
	@Test
	public void test(){
		System.out.println(getPrimeList(220));
	}
	
	
	/**
	 * 获得小于num的所有质数列表		
	 * @param num
	 * @return
	 */
	public ArrayList getPrimeList(int num){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int i = 1;		 
		int flag = 0;
		do{
			i++;
			for(int j = 1; j <= Math.sqrt(i);j++){
				if(0 == i%j){
					flag ++;
				}
			}
			if(flag == 1 ){				
				arr.add(i);				
			}
			flag = 0;
		}while(i < num);		
		return arr;
	}
	/**
	 * 获取num的在所有质数中的排名
	 * @param num
	 * @return
	 */
	public int kthPrime(int n) {
		if (n >= 100000)
			return 0;
		int i = 1;
		int k = 0;
		int flag = 0;
		do {
			i++;
			for (int j = 1; j <= Math.sqrt(i); j++) {
				if (0 == i % j) {
					flag++;
				}
			}
			if (flag == 1) {
				k++;
			}
			flag = 0;
		} while (i < n);
		return k;
	}
	 
	
	/**
	 * 获取num的在所有质数中的排名
	 * @param num
	 * @return
	 */
	public int kthPrime2(int n){
		boolean[] ba = new boolean[n+1];
		//初始所有都置为true
        for (int i = 2; i <= n; i++){
            ba[i] = true;
        }
        //排除非素数????
        for (int i = 2, end = (int)Math.sqrt(n); i <= end; i++){
            if (ba[i]){
                for (int j = i * i; j <= n; j+=i){
                    ba[j] = false;
                }
            }
        }
        //计数
        int ans = 0;
        for (int i = 2; i <= n; i++){
            if (ba[i]){
                ans++;
            }
        }
        return ans;
	}
}
