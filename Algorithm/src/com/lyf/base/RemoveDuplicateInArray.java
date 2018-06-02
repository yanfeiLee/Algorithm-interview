package com.lyf.base;

import java.util.ArrayList;

import org.junit.Test;

/**
 * �Ƴ�������ֵΪele��Ԫ�أ������Ƴ�������鳤�ȼ�����
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
		//ȥ�غ�ele=2��
		int res = removeDuplicate2(arr, 2);
		for(int i = 0; i<res;i++){
			System.out.println(arr[i]);
		}
	}
	
 
	/**
	 * β�����
	 * @param arr
	 * @param ele
	 * @return ȥ�غ�����ĳ���
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
	 * ������ÿ��index��ֵ������д��ȥ�غ�Ԫ�������˳�򲻱䣬�ȶ�
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
