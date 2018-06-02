package com.lyf.simple;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * @function 多关键字排序 给定 n 个学生（ 1 到 n 编号）以及他们的考试成绩，这里有两个关键字，
 *           考试成绩以及学生学号。根据第一关键字对数组进行排序(降序)，如果第一关键字相同则根据第二关键字进行排序(升序). 给出
 *           [[2,50],[1,50],[3,100]]，返回 [[3,100],[1,50],[2,50]]
 * @author Administrator
 * @date 2018年3月15日 上午10:26:35
 *
 */
public class MultiSort {

	@Test
	public void test() {
		int[][] arr = { { 2, 50 }, { 1, 50 }, { 3, 100 } };
		int[][] res = getMultiSort1(arr);
		for (int[] i : res) {
			System.out.println(i[0] + "  " + i[1]);
		}
	}
	/**
	 * 根据条件，分别采用 不同稳定性的排序算法
	 * @param array
	 * @return
	 */
	public int[][] getMultiSort(int[][] array) {
		int[] tmp;
		// 选择排序--不稳定，确定第一个关键字顺序
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i][0] > array[j][0]) {
					tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
		// 冒泡排序--稳定，确定第二个关键字
		boolean flag = false;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j][1] < array[j + 1][1]) {
					flag = true;
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
			if (!flag)
				break;
		}
		return array;
	}

	/**
	 * 多关键字排序 利用内建函数 Arrays.Sort 排序
	 * 
	 * @param array
	 * @return
	 */
	public int[][] getMultiSort1(int[][] array) {
		//构建对象数组
		Stu[] s = new Stu[array.length];
		for (int i = 0; i < array.length; i++) {
			s[i] = new Stu();
			s[i].num = array[i][0];
			s[i].score = array[i][1];
		}
		//排序
		Arrays.sort(s, 0, s.length, new MyCmp());
    	for(int i = 0; i<s.length; i++){
    	    array[i][0] = s[i].num;
    	    array[i][1] = s[i].score;
    	}
		return array;		 
	}

	/**
	 * 利用判断函数排序 -- 扩展性强
	 * 
	 * @param array
	 * @return
	 */
	public int[][] getMultiSort2(int[][] array) {
		int[] tmp;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (!cmp(array[i], array[j])) {
					tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}

		return array;
	}
	//可以扩展到多个条件，判断
	boolean cmp(int[] a, int[] b) {
		//第一条件
		if (a[1] > b[1]) {
			return true;
		}
		//第二条件
		if (a[1] == b[1] && a[0] < b[0]) {
			return true;
		}
		return false;
	}
}



/**
 * 实现排序的辅助类
 * @author Administrator
 *
 */
class Stu{
	public int num,score;
}
class MyCmp implements Comparator<Stu> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Stu s1, Stu s2) {
		// TODO Auto-generated method stub
		if(s1.score != s2.score){
			return s1.score > s2.score ? -1 : 1;
		}
		if(s1.num != s2.num){
			return s1.num > s2.num ? 1 : -1; 
		}		
		return 0;
	}     
}
