package com.lyf.base;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 对一组数进行排序
 * @author Administrator
 *
 */
public class SortNumber {

	
	@Test
	public void test(){
		int[] nums = {1,2,4,-2,3,99,0,2,19,80,66,22,7};
//		System.out.println("冒泡排序");
//		int[] A = BubbleSort(nums); 
				
//		System.out.println("简单选择排序");
//		int[] A = selectSort(nums); 
//		
//		System.out.println("插入排序");
//		int[] A = insertSrot(nums); 
		
		
		System.out.println("快速排序");
		int[] A = quickSort(nums,0,nums.length-1); 
		
		for(int k:A){
			System.out.print(k + " ");
		}
	}	 
	/**
	 * 冒泡排序:时间复杂度O(n^2),稳定    
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
	 * 简单选择排序 时间复杂的O(n^2),不稳定
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
     * 插入排序 时间复杂度O(n^2) ,稳定	
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
     * 快速排序 O(nlog2(n))  不稳定
     * @param A
     * @return
     */
	public int[] quickSort(int[] A,int s,int t){
		if (null == A || t <= s) return A;
		int i = quickExe(A, s, t);
		//对左右区域分别进行快排
		quickSort(A, s, i-1); 
		quickSort(A, i+1,t);		 	
		return A;		
	}
	//执行每次的快速排序
	public int quickExe(int[] A,int s,int t){				 		 
		int tmp = A[s];	
		while(s < t){			 
			while(s < t && A[t] >= tmp){ //必须有等于，否则有相同数据时，容易造成死循环。
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
