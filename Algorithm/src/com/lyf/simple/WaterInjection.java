package com.lyf.simple;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 *@function https://www.lintcode.com/problem/matrix-water-injection/description
 *				上下左右流动
 *@author Administrator
 *@date 2018年5月23日 上午9:44:39 
 *
 */
public class WaterInjection {

	@Test
	public void test() {
			
	}
	//流动方向
	int dir[][] = {
				{1,0}, //下
				{-1,0},//上
				{0,1},//右
				{0,-1}}; //左 
    public String waterInjection(int[][] matrix, int R, int C) {    	
    	 int[][] vis = new int[matrix.length][matrix[0].length];
         Queue<Pair> q = new LinkedList<Pair>();
         q.offer(new Pair(R, C));
         vis[R][C]=1; //记录已经访问过的点
         while(!q.isEmpty()) {
             Pair x = q.poll();
             //边界判断
             if(x.x == 0 || x.x == matrix.length - 1 || x.y == 0 || x.y == matrix[0].length - 1) {
                 return "YES";
             }
             int num = matrix[x.x][x.y];
             for(int i = 0; i < 4; i++) {
                 int tx = x.x + dir[i][0];
                 int ty = x.y + dir[i][1];
                 //超出边界
                 if(tx < 0 || tx >= matrix.length || ty < 0 || ty >= matrix[0].length) {
                     continue;
                 }
                 // 满足条件且并未访问过
                 if(matrix[tx][ty] < num && vis[tx][ty] == 0) {
                     q.offer(new Pair(tx,ty));
                     vis[tx][ty] = 1;
                 }
             }
         }
         return "NO";
    }
    class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }    
    
}
