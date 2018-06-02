package com.lyf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 *@function
 *@author Administrator
 *@date 2018年4月24日 上午9:43:02 
 *
 */
public class Array212List {

	private static final Object[] Integer = null;

	@Test
	public void test() {
		String[] str = {"aa","bb","cc"};
//		List<Object> strList = Array2List(str);
//		strList.add("dd"); //无法使用add、remove方法
//		strList.remove(0);
		 
		
		List<Object> strList = Array2List2(str);
		strList.add("kk");
		strList.remove(0);
		for(Object obj:strList){
			System.out.println(obj); // bb cc kk
		}
		System.out.println("-------------------");
		String[] obj = list2Array(strList);
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
		}
	}
	/**
	 * array 转 list
	 * @param obj
	 * @return
	 */
	public List<Object>  Array2List(Object[] obj){
		return Arrays.asList(obj);
	}
	//转换后可以使用list的全部方法
	public List<Object>  Array2List2(Object[] obj){
		return new ArrayList<Object>(Arrays.asList(obj));
	}
	//list 转array
	public String[]  list2Array(List<Object> ls){
		return ls.toArray(new String[ls.size()]);
	}
	
	/**
	 * 查找矩阵中的最大值和最小值
	 * @param matrix
	 * @return
	 */
	public java.lang.Integer[] maxAndMin(int[][] matrix) {
        // write your code here	
		ArrayList<Integer> al = new ArrayList<Integer>();	 		 
        if(0 == matrix.length){
            return al.toArray(new Integer[al.size()]);
        }
        int max = matrix[0][0];
        int min = max;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length;j++){
                if(max < matrix[i][j]){
                    max = matrix[i][j];
                }
                if(min > matrix[i][j]){
                    min = matrix[i][j];
                }
            }
        }
        Integer[] res = {max,min};
        return res;
    }
}
