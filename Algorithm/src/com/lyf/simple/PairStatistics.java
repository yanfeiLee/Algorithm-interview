package com.lyf.simple;

import java.awt.Point;

import org.junit.Test;

/**
 *@function 数对统计
 *给一个<Point>的List p，求满足p[i].x+p[j].x和p[i].y+p[j].y（i < j)都能被2整除的(i,j)对数。
 *@author Administrator
 *@date 2018年3月11日 下午8:49:58 
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
	 * 获取满足条件的数对
	 * 条件：p[i].x+p[j].x和p[i].y+p[j].y（i < j)都能被2整除的(i,j)对数
	 * 时间复杂度O(n^2)
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
	 * 统计奇偶对，a,b,c,d为point数组中（奇数，偶数）,（奇数，奇数）,（偶数，偶数）,（偶数，奇数）四种情况的数量。
	 * （奇数，偶数）与（奇数，偶数）组合，（奇数，奇数）与（奇数，奇数）组合，（偶数，偶数）与（偶数，偶数）组合，
	 * （偶数，奇数）与（偶数，奇数）组合，
	 * 即答案为ans = ((a - 1) * a + (b - 1) * b + (c - 1) * c + (d - 1) * d)/2。
	 * 时间复杂度O(n)
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
