package com.lyf.simple;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 *@function https://www.lintcode.com/problem/matrix-water-injection/description
 *				������������
 *@author Administrator
 *@date 2018��5��23�� ����9:44:39 
 *
 */
public class WaterInjection {

	@Test
	public void test() {
			
	}
	//��������
	int dir[][] = {
				{1,0}, //��
				{-1,0},//��
				{0,1},//��
				{0,-1}}; //�� 
    public String waterInjection(int[][] matrix, int R, int C) {    	
    	 int[][] vis = new int[matrix.length][matrix[0].length];
         Queue<Pair> q = new LinkedList<Pair>();
         q.offer(new Pair(R, C));
         vis[R][C]=1; //��¼�Ѿ����ʹ��ĵ�
         while(!q.isEmpty()) {
             Pair x = q.poll();
             //�߽��ж�
             if(x.x == 0 || x.x == matrix.length - 1 || x.y == 0 || x.y == matrix[0].length - 1) {
                 return "YES";
             }
             int num = matrix[x.x][x.y];
             for(int i = 0; i < 4; i++) {
                 int tx = x.x + dir[i][0];
                 int ty = x.y + dir[i][1];
                 //�����߽�
                 if(tx < 0 || tx >= matrix.length || ty < 0 || ty >= matrix[0].length) {
                     continue;
                 }
                 // ���������Ҳ�δ���ʹ�
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
