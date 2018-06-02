package com.lyf.base;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * ��һ������������
 * @author Administrator
 *
 */
public class SortNumber {

	
	@Test
	public void test(){
		int[] nums = {1,2,4,-2,3,99,0,2,19,80,66,22,7};
//		System.out.println("ð������");
//		int[] A = BubbleSort(nums); 
				
//		System.out.println("��ѡ������");
//		int[] A = selectSort(nums); 
//		
//		System.out.println("��������");
//		int[] A = insertSrot(nums); 
		
		
		System.out.println("��������");
		int[] A = quickSort(nums,0,nums.length-1); 
		
		for(int k:A){
			System.out.print(k + " ");
		}
	}	 
	/**
	 * ð������:ʱ�临�Ӷ�O(n^2),�ȶ�    
	 * @param A
	 * @return
	 */
	public int[] BubbleSort(int[] A){
		int temp = 0;
		boolean flag;
	    for(int i=A.length-1;i>=0;i--){
	    	flag = false;
	        for(int j=0;j < i;j++){
	            if(A[j] > A[j+1]){
	                temp = A[j];
	                A[j] = A[j+1];
	                A[j+1] = temp;
	                flag = true;
	            }
	        }
	        if(!flag) break;
	    }
	    return A;
	}
 
	/**
	 * ��ѡ������ ʱ�临�ӵ�O(n^2),���ȶ�
	 * @param A
	 * @return
	 */
	public int[] selectSort(int[] A){
		int temp = 0;
	    for(int i = 0;i< A.length-1;i++){
	        for(int j=i+1; j < A.length;j++){
	            if(A[i] > A[j]){
	                temp = A[i];
	                A[i] = A[j];
	                A[j] = temp;
	            }
	        }
	    }
	    return A;
	}
    
    /**
     * �������� ʱ�临�Ӷ�O(n^2) ,�ȶ�	
     * @param A
     * @return
     */
	public int[] insertSrot(int[] A){
		int i,j;
	    int len = A.length;
	    int tmp;
	    for(i=1; i < len; i++){
	        j = i;
	        tmp = A[i];
	        while(j>0 && tmp < A[j-1]){
	            A[j] = A[j-1];
	            j--;
	        }
	        A[j] = tmp;
	    }
	    return A;
	}
    /**
     * �������� O(nlog2(n))  ���ȶ�
     * @param A
     * @return
     */
	public int[] quickSort(int[] A,int s,int t){
		if (null == A || t <= s) return A;
		int i = quickExe(A, s, t);
		//����������ֱ���п���
		quickSort(A, s, i-1); 
		quickSort(A, i+1,t);		 	
		return A;		
	}
	//ִ��ÿ�εĿ�������
	public int quickExe(int[] A,int s,int t){				 		 
		int tmp = A[s];	
		while(s < t){			 
			while(s < t && A[t] >= tmp){ //�����е��ڣ���������ͬ����ʱ�����������ѭ����
				t--;
			}
			A[s] = A[t];
			while(t > s && A[s] <= tmp){
				s++;
			}
			A[t] = A[s];					 			 
		}		
		A[s] = tmp;	
		return s;		
	}
	
}
