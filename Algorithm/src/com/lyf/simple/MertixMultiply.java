package com.lyf.simple;

import org.junit.Test;

/**
 *@function  �������ʵ��  Amn * Bnk = Cmk
 *@author Administrator
 *@date 2018��4��4�� ����3:54:06 
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
	 * �����������
	 * @param A
	 * @param B
	 * @return
	 */
	public int[][] doubleMertixMult(int[][] A,int[][] B){
		//�ж��Ƿ�������		
		if(A[0].length != B.length){
			return null;
		}
		int inner = B.length;
		int m = A.length;  //��� m��
		int n = B[0].length; //��� n��
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
	 * ���㷽���n���ݣ����η�
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
		
		//���ɵ�λ����		 
		for (int j = 0; j < i; j++) {
			for (int j2 = 0; j2 < i; j2++) {
				if(j2 == j){
					res[j][j2] = 1;
				}else{
					res[j][j2] = 0;
				}
			}			
		}
		//ѭ�����μ���
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
