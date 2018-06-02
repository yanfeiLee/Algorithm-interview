package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 *@function 给出两个数组a，b。a[i]代表第i部影片的版权费，
 *			b[i]代表第i部影片能卖的钱，现在本金k，问最后最多能赚多少钱。（每部影片只需要买一次版权，只能卖一次。）
 *			Note:所有输入均为不超过100000的正整数。数组大小不超过10000。
 *			Example:
 *				给出 a = [3,1,5], b = [4,3,100], k = 1，返回 4。
 *				解释：先买第2部影片，再卖出，再买第1部影片，再卖出，最后本金变为4。
 *				给出 a = [3,1,5], b = [4,3,100], k = 10，返回 108。
 *				解释：将全部影片买下，卖出，最后本金变为108。
 *@author Administrator
 *@date 2018年4月17日 上午10:03:57 
 *
 */
public class BigBusiness {

	@Test
	public void test() {
		int[] a = {3,1,5};
		int[] b = {3,3,34};
		int k = 100;
		System.out.println(bigBusiness2(a, b, k));
		
	}
	/**
	 * 直接循环比较，排除亏钱的影片
	 * @param a
	 * @param b
	 * @param k
	 * @return
	 */
	public int bigBusiness(int[] a, int[] b, int k) {
        // Write your code here		 
		for (int i = 0; i < a.length; i++) {
			if(-1 != a[i] && k >= a[i] && a[i] < b[i]){				
				k = k - a[i] + b[i];				  
				a[i] = -1;
				i = -1;
			}			
		}
		return k;
    }
	/**
	 * 将a[i],b[i]封装为对象，然后根据对象的a[i]升序排
	 * @param a
	 * @param b
	 * @param k
	 * @return
	 */
	public int bigBusiness2(int[] a, int[] b, int k) {
        // Write your code here
        List<pair> list = new ArrayList<pair>();
        for(int i = 0; i < a.length; i++) {
            list.add(new pair(a[i], b[i]));
        }
        Collections.sort(list);
        for(pair t : list) {
            if(t.b - t.a > 0 && k >= t.a) {
                k += t.b - t.a;
            }
        }
        return k;
    }
	
	/*
	 *  pair类实现Comparable接口 
	 */
	class pair implements Comparable<pair>{
	    public int a, b;
	    public pair(int a, int b) {
	        this.a = a;
	        this.b = b;
	    }
	    public int compareTo(pair obj) {  
	        return a - obj .a;  //升序排，
	    }  
	}
}
