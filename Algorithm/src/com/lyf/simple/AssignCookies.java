package com.lyf.simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.lyf.test.Array212List;

/**
 *@function https://www.lintcode.com/problem/assign-cookies/description
 *@author Administrator
 *@date 2018年5月22日 上午8:41:27 
 *
 */
public class AssignCookies {

	@Test
	public void test() {
		int[] s = {11,2,3,29,};
		Arrays.sort(s);
//		for(int i:s){
//			System.out.println(i);
//		}
		int[] g  = {1,2,2,3,10,9};
		System.out.println(findContentChildren(g, s));
		
	}
	/**
	 * 一块cookie可以分给多个人
	 * @param g
	 * @param s
	 * @return
	 */
    public int findContentChildren(int[] g, int[] s) {
        // Write your code here    	
    	int sum  = 0;     
    	for (int i = 0; i < g.length; i++) {
    		Arrays.sort(s);
			for (int j = 0; j < s.length; j++) {
				 if(s[j] <= 0 ) continue;
				 if( g[i] <= s[j]){
					s[j] -= g[i];
					sum += 1;
					break;
				 }
			}
		}
        return sum;
    }
    /**
     * 一块cookie只能分给一个人
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren2(int[] g, int[] s) {
	    Arrays.sort(g);
	    Arrays.sort(s);
	    int i, j;
	    for (i = j = 0; i < g.length && j < s.length; j++) {
	        if (g[i] <= s[j]) {
	            i++;
	        }
	    }
	    return i;
    }
}
