package com.lyf.test;

import java.util.*;

import org.junit.Test;


/**
 *@function  Arrays.sort()  ʵ���Զ��巽ʽ���� ���ɼ����򣬳ɼ���ͬʱ��ѧ������
 *@author Administrator
 *@date 2018��3��15�� ����11:37:12 
 *
 */
public class ArraysSortTest {

	@Test
	public void test() {
		
		int[][] array = { { 2, 50 }, { 1, 50 }, { 3, 100 } };
		//�����������
		Stu[] s = new Stu[array.length];
		for (int i = 0; i < array.length; i++) {
			s[i] = new Stu();
			s[i].num = array[i][0];
			s[i].score = array[i][1];
		}		
		//����
		Arrays.sort(s, 0, s.length, new MyCmp());
	 
		for (Stu i : s) {
			System.out.println(i.num + "  "+ i.score);
		}
		
	}
}
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
			//��һ������ > �ڶ������� ����-1ʱ�����Ƚϵ����� �����ţ�����1ʱ�����Ƚϵ�����������
			return s1.score > s2.score ? -1 : 1; 
		}
		if(s1.num != s2.num){
			return s1.num > s2.num ? 1 : -1; 
		}		
		return 0;
	}     
}