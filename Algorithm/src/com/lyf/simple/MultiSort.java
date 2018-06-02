package com.lyf.simple;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * @function ��ؼ������� ���� n ��ѧ���� 1 �� n ��ţ��Լ����ǵĿ��Գɼ��������������ؼ��֣�
 *           ���Գɼ��Լ�ѧ��ѧ�š����ݵ�һ�ؼ��ֶ������������(����)�������һ�ؼ�����ͬ����ݵڶ��ؼ��ֽ�������(����). ����
 *           [[2,50],[1,50],[3,100]]������ [[3,100],[1,50],[2,50]]
 * @author Administrator
 * @date 2018��3��15�� ����10:26:35
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
	 * �����������ֱ���� ��ͬ�ȶ��Ե������㷨
	 * @param array
	 * @return
	 */
	public int[][] getMultiSort(int[][] array) {
		int[] tmp;
		// ѡ������--���ȶ���ȷ����һ���ؼ���˳��
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i][0] > array[j][0]) {
					tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
		// ð������--�ȶ���ȷ���ڶ����ؼ���
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
	 * ��ؼ������� �����ڽ����� Arrays.Sort ����
	 * 
	 * @param array
	 * @return
	 */
	public int[][] getMultiSort1(int[][] array) {
		//������������
		Stu[] s = new Stu[array.length];
		for (int i = 0; i < array.length; i++) {
			s[i] = new Stu();
			s[i].num = array[i][0];
			s[i].score = array[i][1];
		}
		//����
		Arrays.sort(s, 0, s.length, new MyCmp());
    	for(int i = 0; i<s.length; i++){
    	    array[i][0] = s[i].num;
    	    array[i][1] = s[i].score;
    	}
		return array;		 
	}

	/**
	 * �����жϺ������� -- ��չ��ǿ
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
	//������չ������������ж�
	boolean cmp(int[] a, int[] b) {
		//��һ����
		if (a[1] > b[1]) {
			return true;
		}
		//�ڶ�����
		if (a[1] == b[1] && a[0] < b[0]) {
			return true;
		}
		return false;
	}
}



/**
 * ʵ������ĸ�����
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
