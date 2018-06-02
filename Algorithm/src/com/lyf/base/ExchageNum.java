package com.lyf.base;

import java.util.Stack;

import org.junit.Test;

/**
 * 交换数组中的两个元素A[0] 和 A[2];
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
	 * 借助第三个变量交换两个元素
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
	 * 借助栈实现
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
	 * 算术运算[仅针对数值运算,不安全],求出两点间的距离,利用距离完成交换
	 * @param A
	 * @return
	 */
	public int[] exchange3(int A[]){
		if(A[0]!=A[2]){    //判断的同时，消除了同一个元素，交换时，造成的结果为0现象
			A[0] = A[2] - A[0];
			A[2] = A[2] - A[0];
			A[0] = A[2] + A[0];
		}		
		return A;
	}
	/**
	 * 异或运算[仅针对数值运算]，任意一个数与给定的值，异或运算两次后，值不变
	 * @param A
	 * @return
	 */
	public int[] exchange4(int A[]){
		if(A[0]!=A[2]){ //判断的同时，消除了同一个元素，交换时，造成的结果为0现象 
			A[0] = A[0]^A[2];
			A[2] = A[0]^A[2];
			A[0] = A[0]^A[2];
		}
		return A;
	}
	
}
