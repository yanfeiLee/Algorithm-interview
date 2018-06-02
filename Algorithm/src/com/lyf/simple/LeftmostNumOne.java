package com.lyf.simple;

import org.junit.Test;

/**
 *@function һ����ά���飬ÿһ�ж�ֻ��0��1��ǰ�沿����0����һ������1���ҵ���������������������ߵ�1���ڵ�������
 *���� arr = [[0,0,0,1],[1,1,1,1]], ���� 0�� ��arr[1][0]Ϊ������������ߵ�1�������ڵ���Ϊ0����
 *���� arr = [[0,0,0,1],[0,1,1,1]], ���� 1����arr[1][1]Ϊ������������ߵ�1�������ڵ���Ϊ1����
 *@author Administrator
 *@date 2018��3��17�� ����12:31:04 
 *
 */
public class LeftmostNumOne {

	@Test
	public void test() {
		int arr[][] = {{0,0,0,1},{1,1,1,1}};
		int arr2[][] = {{0,0,0,1},{0,1,1,1}};
		System.out.println(getLeftmostCol(arr2));
	}
	
	/**
	 * ��������ߵ�1
	 * @param arr
	 * @return
	 */
	public int getLeftmostCol(int[][] arr){
		int col = Integer.MAX_VALUE;
		int len = arr.length;
		int len_in = arr[0].length;
		for(int i = 0; i < len; i++ ){
			for(int j = 0; j < len_in; j++){
				if(arr[i][j] == 1 && col > j){					
					col = j;
				}
			}
		}
		return col;
	}
}
