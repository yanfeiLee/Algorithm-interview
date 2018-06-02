package com.lyf.simple;

import org.junit.Test;

/**
 *@function ����һ�����������һ��Ŀ��ֵ��������������ҵ�Ŀ��ֵ�򷵻����������û�У����ص������ᱻ��˳������λ�á�	
			����Լ��������������ظ�Ԫ�ء�
			Example��
			[1,3,5,6]��5 �� 2

			[1,3,5,6]��2 �� 1
			
			[1,3,5,6]�� 7 �� 4
			
			[1,3,5,6]��0 �� 0
 *@author Administrator
 *@date 2018��5��18�� ����9:05:07 
 *
 */
public class SearchInert {

	@Test
	public void test() {
		int[]  A  = {1,10,201,1001,10001,10007};
		int target = 10008;
		System.out.println(searchInsert(A, target));
	}
	/**
	 * ���ַ�
	 * @param A
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] A, int target) {
		int len = A.length;
//		�����������
		if(0==len || null == A) return 0;
		if(target < A[0]){
			return 0;
		}else if(target > A[len-1]){
			return len;
		}
		int mid = 0;
		int left = 0;
		int right = len-1;
		while(left <= right){
			mid = (left+right)/2;			 
			if(target == A[mid]){
				return mid;
			}else if(target > A[mid]){
				left = mid+1;
			}else{
				right = mid-1;
			}							 			 	
		}
		if(target > A[mid]){
			return mid+1;
		}else{
			return mid;
		}		 
	}
}
