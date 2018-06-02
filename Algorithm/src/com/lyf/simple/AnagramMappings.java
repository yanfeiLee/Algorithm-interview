package com.lyf.simple;

import java.util.HashMap;

import org.junit.Test;

/**
 *@function ����ӳ��
 *Given two lists A and B, and B is an anagram of A. B is an anagram of A means 
 *B is made by randomizing the order of the elements in A.We want to find an index mapping P,
 *from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
 *These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 *Given A = [12, 28, 46, 32, 50] and B = [50, 12, 32, 46, 28], return [1, 4, 3, 2, 0].
 *@author Administrator
 *@date 2018��3��11�� ����9:41:58 
 *
 */

public class AnagramMappings {

	@Test
	public void test() {
		int[] A = {12, 28, 46, 32, 50};
		int[] B = {50, 12, 32, 46, 28};
		int[] res = getMappings2(A, B);
		for(int num :res){
			System.out.print(num+" ");
		}
	}
	
	/**
	 * �ҵ�����A,B���������ӳ���ϵ,A�����ظ�ֵʱ�������������B�е�һ��λ�þͿ���
	 * @param A
	 * @param B
	 * @return
	 */
	public int[] getMappings(int[] A,int[] B){
		int len = A.length;		 
		int[] res = new int[len];
		for(int i=0; i< len; i++){
			for (int j = 0; j < len; j++) {
				if(A[i] == B[j]){
					res[i] = j;					 
					break;
				}				
			}
		}		
		return res;		
	}
	/**
	 * ����hashMap ʵ��
	 * @param A
	 * @param B
	 * @return
	 */
	public int[] getMappings2(int[] A,int[] B){		
		int len = A.length;		 
		int[] res = new int[len];
		HashMap<Integer,Integer> target = new HashMap<Integer, Integer>();
		for(int i = 0; i < len; i++){
			target.put(B[i], i);
		}
		for (int i = 0; i < len; i++) {
			if(target.containsKey(A[i])){
				res[i] = target.get(A[i]);
			}
		}
		return res;
	}
}
