package com.lyf.base;

import java.util.Stack;

import org.junit.Test;

/**
 * ���������е�����Ԫ��A[0] �� A[2];
 * @author Administrator
 *
 */
public class ExchageNum {

	@Test
	public void test(){
		int A[] = {101,2,11};
		A = exchange4(A);
		for(int x:A){
			System.out.println(x);
		}
		System.out.println("----------");
		String s = "helo";
		System.out.println(s.hashCode());
		
	}
	
	/**
	 * ����������������������Ԫ��
	 * @param A
	 * @return
	 */
	public int[]  exchange(int A[]){
		if(A[0]!=A[2]){
			int tmp;
			tmp = A[0];
			A[0] = A[2];
			A[2] = tmp;
		}
		return A;
	}
	/**
	 * ����ջʵ��
	 * @param A
	 * @return
	 */
	public int[] exchange2(int A[]){
		if(A[0]!=A[2]){
			Stack<Integer> s = new Stack<Integer>();
			s.push(A[0]);
			s.push(A[2]);
			A[0] = s.pop();
			A[2] = s.pop();		
		}
		return A;
	}
	/**
	 * ��������[�������ֵ����,����ȫ],��������ľ���,���þ�����ɽ���
	 * @param A
	 * @return
	 */
	public int[] exchange3(int A[]){
		if(A[0]!=A[2]){    //�жϵ�ͬʱ��������ͬһ��Ԫ�أ�����ʱ����ɵĽ��Ϊ0����
			A[0] = A[2] - A[0];
			A[2] = A[2] - A[0];
			A[0] = A[2] + A[0];
		}		
		return A;
	}
	/**
	 * �������[�������ֵ����]������һ�����������ֵ������������κ�ֵ����
	 * @param A
	 * @return
	 */
	public int[] exchange4(int A[]){
		if(A[0]!=A[2]){ //�жϵ�ͬʱ��������ͬһ��Ԫ�أ�����ʱ����ɵĽ��Ϊ0���� 
			A[0] = A[0]^A[2];
			A[2] = A[0]^A[2];
			A[0] = A[0]^A[2];
		}
		return A;
	}
	
}
