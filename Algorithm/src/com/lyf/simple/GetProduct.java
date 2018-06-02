package com.lyf.simple;

import org.junit.Test;

/**
 *@function https://www.lintcode.com/problem/residual-product/description
 *	note: 如果数组只有一个元素，那么其他元素默认为0
 *@author Administrator
 *@date 2018年6月2日 上午9:19:27 
 *
 */
public class GetProduct {

	@Test
	public void test() {
//		System.out.println(Integer.MAX_VALUE);
//		int[] arr = {10,10,10,10,10,10,10,10,10,10};
		int[] arr = {0};
		int[] res = getProduct(arr);
		for(int i : res){
			System.out.println(i);
		}
	}
	//求和后除以当前数
    public int[] getProduct(int[] arr) {
    	long product = 1;
    	int len = arr.length;
    	int zeroCount = 0;
        for (int i = 0; i < len; i++) {
			if(0 != arr[i]){
				product *= arr[i];
			}else{
				zeroCount++;
			}
		}         
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
        	if(1 == len){
        		res[i] = 0;
        		continue;
        	}
			if(0 != arr[i] && 0 == zeroCount){
				res[i] = (int) (product/arr[i]);
			}else if(0 != arr[i] && 0 < zeroCount){
				res[i] = 0;
			}else if(0 == arr[i] && 1 == zeroCount){				 
					res[i] = (int) product;				 		
			}else if(0 == arr[i] && 1 < zeroCount){
				res[i] = 0;
			}
		}
        return res;
    }
    //计算当前位置前边的积和后边的积
    public int[] getProduct2(int[] arr){
    	 //数组只有一个元素时，其他值为0
    	 if(arr.length == 1) {
             int[] ans = new int[1];
             ans[0] = 0;
             return ans;
         }
         int[] pre = new int[arr.length];
         int[] suf = new int[arr.length];
         int[] ans = new int [arr.length];
         pre[0] = arr[0];
         for(int i = 1; i < arr.length; i++) {
             pre[i] = arr[i] * pre[i - 1];
         }
         suf[arr.length - 1] = arr[arr.length - 1];
         for(int i = arr.length - 2; i >= 0; i--) {
             suf[i] = suf[i + 1] * arr[i];
         }
         //首尾值计算
         ans[0] = suf[1];
         ans[arr.length - 1] = pre[arr.length - 2];
         for(int i = 1; i <= arr.length - 2; i++) {
             ans[i] = pre[i - 1] * suf[i + 1];
         }
         return ans;
    }
}
