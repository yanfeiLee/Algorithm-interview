package com.lyf.simple;

import org.junit.Test;

/**
 *@function约翰想在他家后面的空地上建一个后花园，现在有两种砖，
 *一种3 dm的高度，7 dm的高度。约翰想围成x dm的墙。如果约翰能做到，输出YES，否则输出NO。  x取值[3, 1000]
 *给出 x = 10，返回YES。x = 3 + 7 : 即需要1匹3 dm高度的砖和1匹7 dm 高度的砖。
 *给出 x = 5，返回 NO。不能用高度为3 dm的砖和高度为7 dm的砖砌成 5 dm的墙。
 *给出 x = 13，返回YES。x = 2 * 3 + 7 : 即需要2匹3 dm高度的砖和1匹7 dm 高度的砖。
 *@author Administrator
 *@date 2018年3月23日 上午10:13:07 
 *
 */
public class BackYard {

	@Test
	public void test() {
		System.out.println(isBackYard(13));
	}

	/**
	 * 先考虑特殊情况 然后按照公式7m+3n=x 遍历判断
	 * 
	 * @param x
	 * @return
	 */
	public String isBackYard(int x) {
		if (x < 3 || x > 1000)
			return "NO";
		if (0 == x % 3 || 0 == x % 7)
			return "YES";
		for (int i = 1; i <= x / 7; i++) {
			for (int j = 1; j <= x / 3; j++) {
				if (i * 7 + j * 3 == x) {
					return "YES";
				}
			}
		}
		return "NO";
	}
	/**
	 * 所有距离差3或者7的数都置为1，最后判断x处是否为1
	 * @param x
	 * @return
	 */
	public String isBackYard2(int x){
		int [] dp = new int[10001];
		for(int i = 0; i <= 1000; i++) {
			dp[i] = 0;
		}
		dp[0] = 1;
		for(int i = 3; i <= x; i++) {
			if(dp[i - 3] == 1) {
				dp[i] = 1;
			}
		}
		for(int i = 7; i <= x; i++) {
			if(dp[i - 7] == 1) {
				dp[i] = 1;
			}
		}
		return dp[x] == 1 ? "YES" : "NO";
	}
}
