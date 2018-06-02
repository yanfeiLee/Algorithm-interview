package com.lyf.base;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 移除数组中值为ele的元素，返回移除后的数组长度及数组
 * @author Administrator
 *
 */
public class RemoveDuplicateInArray {

	@Test
	public void test(){
		int[] arr =new int[8];
		arr[0]  = 12;
		arr[2]  = 2;
		arr[1]  = 32;
		arr[3]  = 2;
		arr[4]  = 92;
		arr[5]  = 2;
		arr[6]  = 22;
		arr[7]  = 122;
		for(int i = 0; i<arr.length;i++){
			System.out.println(arr[i]);
		}
		System.out.println("-----------");
		//去重后【ele=2】
		int res = removeDuplicate2(arr, 2);
		for(int i = 0; i<res;i++){
			System.out.println(arr[i]);
		}
	}
	
 
	/**
	 * 尾部填充
	 * @param arr
	 * @param ele
	 * @return 去重后数组的长度
	 */
	public int removeDuplicate(int[] arr,int ele){
		int len = arr.length;
		for(int i = 0;i < len ; i++){
			 while(ele == arr[i] && i < len  ){
				 arr[i] = arr[--len];
			 }
		}
		return len;
	}
	/**
	 * 数组中每个index的值重新填写；去重后元素整体的顺序不变，稳定
	 * @param arr
	 * @param ele
	 * @return 
	 */
	public int removeDuplicate2(int[] arr,int ele){
		int m = 0;
		int len = arr.length;
		for(int i=0; i< len; i++){
			if(arr[i] != ele){
				arr[m] = arr[i];
				m++;
			}
		}
		return m;
	}
}
