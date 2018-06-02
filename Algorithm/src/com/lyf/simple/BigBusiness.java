package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 *@function ������������a��b��a[i]�����i��ӰƬ�İ�Ȩ�ѣ�
 *			b[i]�����i��ӰƬ������Ǯ�����ڱ���k������������׬����Ǯ����ÿ��ӰƬֻ��Ҫ��һ�ΰ�Ȩ��ֻ����һ�Ρ���
 *			Note:���������Ϊ������100000���������������С������10000��
 *			Example:
 *				���� a = [3,1,5], b = [4,3,100], k = 1������ 4��
 *				���ͣ������2��ӰƬ���������������1��ӰƬ������������󱾽��Ϊ4��
 *				���� a = [3,1,5], b = [4,3,100], k = 10������ 108��
 *				���ͣ���ȫ��ӰƬ���£���������󱾽��Ϊ108��
 *@author Administrator
 *@date 2018��4��17�� ����10:03:57 
 *
 */
public class BigBusiness {

	@Test
	public void test() {
		int[] a = {3,1,5};
		int[] b = {3,3,34};
		int k = 100;
		System.out.println(bigBusiness2(a, b, k));
		
	}
	/**
	 * ֱ��ѭ���Ƚϣ��ų���Ǯ��ӰƬ
	 * @param a
	 * @param b
	 * @param k
	 * @return
	 */
	public int bigBusiness(int[] a, int[] b, int k) {
        // Write your code here		 
		for (int i = 0; i < a.length; i++) {
			if(-1 != a[i] && k >= a[i] && a[i] < b[i]){				
				k = k - a[i] + b[i];				  
				a[i] = -1;
				i = -1;
			}			
		}
		return k;
    }
	/**
	 * ��a[i],b[i]��װΪ����Ȼ����ݶ����a[i]������
	 * @param a
	 * @param b
	 * @param k
	 * @return
	 */
	public int bigBusiness2(int[] a, int[] b, int k) {
        // Write your code here
        List<pair> list = new ArrayList<pair>();
        for(int i = 0; i < a.length; i++) {
            list.add(new pair(a[i], b[i]));
        }
        Collections.sort(list);
        for(pair t : list) {
            if(t.b - t.a > 0 && k >= t.a) {
                k += t.b - t.a;
            }
        }
        return k;
    }
	
	/*
	 *  pair��ʵ��Comparable�ӿ� 
	 */
	class pair implements Comparable<pair>{
	    public int a, b;
	    public pair(int a, int b) {
	        this.a = a;
	        this.b = b;
	    }
	    public int compareTo(pair obj) {  
	        return a - obj .a;  //�����ţ�
	    }  
	}
}
