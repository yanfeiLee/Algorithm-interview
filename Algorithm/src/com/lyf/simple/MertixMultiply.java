package com.lyf.simple;

import org.junit.Test;

/**
 *@function  矩阵相乘实现  Amn * Bnk = Cmk
 *@author Administrator
 *@date 2018年4月4日 下午3:54:06 
 *
 */
public class MertixMultiply {

	@Test
	public void test() {
//		int[][] A = {{2,1},
//		             {2,2},
//		             {2,3}
//		             };
//		
//		int[][] B = {{1,0,0,1},
//					 {2,1,2,3}
//					};
//		int[][] res = doubleMertixMult(A, B);
		
		int[][] C = {{2,1},
		             {2,2}
	             	};
		int[][] rs = metrixNpower(C, 3);
		for(int[] in :rs){
			for(int i:in){
				System.out.print(i+",");
			}
			System.out.println("\r\n");
		}
	}
	
	/**
	 * 两个矩阵相乘
	 * @param A
	 * @param B
	 * @return
	 */
	public int[][] doubleMertixMult(int[][] A,int[][] B){
		//判断是否可以相乘		
		if(A[0].length != B.length){
			return null;
		}
		int inner = B.length;
		int m = A.length;  //结果 m行
		int n = B[0].length; //结果 n列
		int[][] res = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < inner  ; k++) {
					res[i][j] += A[i][k]*B[k][j];
				}
			}
		}		
		return res;
	}
	/**
	 * 计算方阵的n次幂，分治法
	 * @param A
	 * @param n
	 * @return
	 */
	public int[][] metrixNpower(int[][] A,int n){
		int i = A.length;
		if(0 == i){
			return null;
		}
		int[][] res = new int[i][i];
		
		//生成单位矩阵		 
		for (int j = 0; j < i; j++) {
			for (int j2 = 0; j2 < i; j2++) {
				if(j2 == j){
					res[j][j2] = 1;
				}else{
					res[j][j2] = 0;
				}
			}			
		}
		//循环分治计算
		while(0 != n){
			if(1 == (n&1)){
				res = doubleMertixMult(res, A);
			}
			A = doubleMertixMult(A, A);
			n>>=1;
		}		
		return res;
	}
	
}
