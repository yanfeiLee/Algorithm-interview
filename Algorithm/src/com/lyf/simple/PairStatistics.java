package com.lyf.simple;

import java.awt.Point;

import org.junit.Test;

/**
 *@function ����ͳ��
 *��һ��<Point>��List p��������p[i].x+p[j].x��p[i].y+p[j].y��i < j)���ܱ�2������(i,j)������
 *@author Administrator
 *@date 2018��3��11�� ����8:49:58 
 *
 */
public class PairStatistics {

	@Test
	public void test() {
		Point[] p = new Point[3];
		p[0] = new Point(1,2);
		p[1] = new Point(3,4);
		p[2] = new Point(5,6);
		System.out.println(p[0].x); 
		System.out.println(getPairs2(p));
	 	
	}
	
	/**
	 * ��ȡ��������������
	 * ������p[i].x+p[j].x��p[i].y+p[j].y��i < j)���ܱ�2������(i,j)����
	 * ʱ�临�Ӷ�O(n^2)
	 * @param p
	 * @return
	 */
	public int getPairs(Point[] p){
		int count = 0;
		int len = p.length;
		if(2 > len) return 0;
		for(int i = 0; i < len-1; i++){
			for (int j = i+1; j < len ; j++) {
				if(0 == (p[i].getX()+p[j].getX())%2  && 0 == (p[i].getY()+p[j].getY())%2 ){
					count++;
				}
			}
		}
		return count;
	}
	/**
	 * ͳ����ż�ԣ�a,b,c,dΪpoint�����У�������ż����,��������������,��ż����ż����,��ż�������������������������
	 * ��������ż�����루������ż������ϣ����������������루��������������ϣ���ż����ż�����루ż����ż������ϣ�
	 * ��ż�����������루ż������������ϣ�
	 * ����Ϊans = ((a - 1) * a + (b - 1) * b + (c - 1) * c + (d - 1) * d)/2��
	 * ʱ�临�Ӷ�O(n)
	 * @param p
	 * @return
	 */
	public int getPairs2(Point[] p) {
        // Write your code here
        int odd_odd = 0, odd_even = 0, even_odd = 0, even_even = 0;
        for(int i = 0; i < p.length; i++) {
            if(p[i].x % 2 == 1) {
                if(p[i].y % 2 == 1) {
                    odd_odd++;
                }
                else {
                    odd_even++;
                }
            }
            else {
                if(p[i].y % 2 == 1) {
                    even_odd++;
                }
                else {
                    even_even++;
                }
            }
        }
        int ans = 0;
        ans += odd_odd * (odd_odd - 1) / 2;
        ans += odd_even * (odd_even - 1) / 2;
        ans += even_odd * (even_odd - 1) / 2;
        ans += even_even * (even_even - 1) / 2;
        return ans;
    }
}
