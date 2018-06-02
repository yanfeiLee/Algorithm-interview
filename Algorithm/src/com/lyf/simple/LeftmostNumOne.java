package com.lyf.simple;

import org.junit.Test;

/**
 *@function 一个二维数组，每一行都只有0和1，前面部分是0，后一部分是1，找到数组里面所有行中最左边的1所在的列数。
 *给出 arr = [[0,0,0,1],[1,1,1,1]], 返回 0。 【arr[1][0]为所有行中最左边的1，其所在的列为0。】
 *给出 arr = [[0,0,0,1],[0,1,1,1]], 返回 1。【arr[1][1]为所有行中最左边的1，其所在的列为1。】
 *@author Administrator
 *@date 2018年3月17日 下午12:31:04 
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
	 * 计算最左边的1
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
