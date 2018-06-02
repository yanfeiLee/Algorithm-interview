package com.lyf.simple;


import java.util.ArrayList;

import org.junit.Test;

/**
 *@function 孤岛城市计算
 *Given a matrix of size n x m, the elements 
 *in the matrix are 0、1、2. 0 for the sea, 1 for the island, 
 *and 2 for the city on the island(You can assume that 2 is built on 1, 
 *ie 2 also represents the island).
 *If two 1 are adjacent, then these two 1 belong to the same island.
 * Find the number of islands with at least one city.
 * 
 * examples
 * Given mat =
	[
	     [1,1,0,0,0],
	     [0,1,0,0,1],
	     [0,0,0,1,1],
	     [0,0,0,0,0],
	     [0,0,0,0,1]
	]
	return 0; //There are 3 islands, but none of them contain cities.
	
	Given mat =
	[
	     [1,1,0,0,0],
	     [0,1,0,0,1],
	     [0,0,2,1,2],
	     [0,0,0,0,0],
	     [0,0,0,0,2]
	]
	return 2;//There are 3 islands, and two of them have cities.
        孤立的2代表岛
 *@author Administrator
 *@date 2018年3月22日 上午9:20:48 
 *
 */
public class IslandCitys {

	@Test
	public void test() {
		//boolean类型数组 默认是false
//		 boolean [][] visit = new boolean[2][2];
//		 System.out.println(visit[1][1]);
		int[][] grid = {{1,1,0,0,0},{0,1,0,0,1},{0,0,2,1,2},{0,0,0,0,0},{0,0,0,0,2}};
		System.out.println(getIslandCitys(grid));

	}
	int [][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; //下上 右左
	/**
	 * 递归判断是否连通
	 * @param visit  是否访问过
	 * @param grid   网格
	 * @param x   坐标x
	 * @param y   坐标y
	 * @param n    高   --- 行
	 * @param m   宽 --- 列
	 * @return
	 */
    public int dfs(boolean [][] visit, int [][] grid, int x, int y, int n, int m) {
        visit[x][y] = true;
        int ans = 0;
        if(grid[x][y] == 2) {
            ans++;
        }
        for(int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if(dx >= n || dx < 0 || dy >= m || dy < 0 || visit[dx][dy] || grid[dx][dy] == 0) {
                continue;
            }
            ans += dfs(visit, grid, dx, dy, n, m);
        }
        if(ans != 0) {
            return 1; //至少有一座城市
        } else {
            return 0;
        }
    }
//    [1,1,0,0,0],
//    [0,1,0,0,1],
//    [0,0,2,1,2],
//    [0,0,0,0,0],
//    [0,0,0,0,2]
    public int getIslandCitys(int [][] grid) {
        // Write your code here
        int n = grid.length;  //高   --- 行
        int m = grid[0].length; //宽 --- 列
        boolean [][] visit = new boolean[n][m];        
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visit[i][j] == false && grid[i][j] != 0) {
                    ans += dfs(visit, grid, i, j, n, m);
                }
            }
        }
        return ans;
    }
	
}
