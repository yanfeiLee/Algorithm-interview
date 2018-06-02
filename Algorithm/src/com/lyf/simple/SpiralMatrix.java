package com.lyf.simple;

import org.junit.Test;

/**
 * 构造螺旋矩阵，例如，给定3，则螺旋矩阵如下
   [
	[1,2,3]
	[8,9,4]
	[7,6,5]
   ]
 * @author Administrator
 *
 */
public class SpiralMatrix {
	
	@Test
	public void test(){
		int n = 5;
		int A[][] = createSpiralMatrix(n);
		for(int i = 0; i < n; ++i ){
			for(int j=0; j < n; ++j){
				System.out.print(A[i][j] + " ");
			}
			System.out.println("\r\n");
		}
	}
	/**
	 * 根据给定的n，构建螺旋矩阵
	 * 基本算法思想
	 * 1.构建不同方向的移动数组dx,dy
	 * 2.初始化所有点，以便用于判断，点是否被填充而改变方向
	 * 3.初始化开始位置及方向
	 * 4.边缘、已初始化点的检测,改变方向[d = (d+1)%4]
	 * 5.循环赋值
	 * @param n
	 * @return
	 */
	public int[][] createSpiralMatrix(int n){
		int [][] res = new int[n][n];
        // 分别向右、下、左、上 移动一步时，下标x,y的增量
		int[] dx = new int[]{0, 1, 0, -1};  
		int[] dy = new int[]{1, 0, -1, 0};  
		
		// currently: x, y
		// direction d
		// next grid: (x + dx[d], y + dy[d])
		
		int x, y, d; //d表示方向
		int i, j, nx, ny;// 下一步填充的位置[nx][ny]
		// 初始化所有点位-1表示[i][j]点尚未被填充
		for (i = 0; i < n; ++i) {
			for (j = 0; j < n; ++j) {
			  res[i][j] = -1;  
			}
		}		
		x = 0;
		y = 0;
		d = 0; //0-->右, 1-->下, 2-->左, 3-->上
		//所有点个数n^2个
		for (i = 1; i <= n * n; ++i) {
			res[x][y] = i; //填充点
			//下一个点的位置
			nx = x + dx[d];
			ny = y + dy[d];			 
			//判断方向是否正确，不能超出矩阵范围 或者点已经被填充(值不等于-1)-----碰撞检测
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || res[nx][ny] != -1) {  
			  //发生碰撞，重新调整方向
			  d = (d + 1) % 4;
			  nx = x + dx[d];
			  ny = y + dy[d];
			}			
			x = nx;
			y = ny;
		}		
		return res;	 
	}
}
