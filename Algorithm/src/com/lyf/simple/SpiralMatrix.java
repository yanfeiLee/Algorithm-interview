package com.lyf.simple;

import org.junit.Test;

/**
 * ���������������磬����3����������������
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
	 * ���ݸ�����n��������������
	 * �����㷨˼��
	 * 1.������ͬ������ƶ�����dx,dy
	 * 2.��ʼ�����е㣬�Ա������жϣ����Ƿ������ı䷽��
	 * 3.��ʼ����ʼλ�ü�����
	 * 4.��Ե���ѳ�ʼ����ļ��,�ı䷽��[d = (d+1)%4]
	 * 5.ѭ����ֵ
	 * @param n
	 * @return
	 */
	public int[][] createSpiralMatrix(int n){
		int [][] res = new int[n][n];
        // �ֱ����ҡ��¡����� �ƶ�һ��ʱ���±�x,y������
		int[] dx = new int[]{0, 1, 0, -1};  
		int[] dy = new int[]{1, 0, -1, 0};  
		
		// currently: x, y
		// direction d
		// next grid: (x + dx[d], y + dy[d])
		
		int x, y, d; //d��ʾ����
		int i, j, nx, ny;// ��һ������λ��[nx][ny]
		// ��ʼ�����е�λ-1��ʾ[i][j]����δ�����
		for (i = 0; i < n; ++i) {
			for (j = 0; j < n; ++j) {
			  res[i][j] = -1;  
			}
		}		
		x = 0;
		y = 0;
		d = 0; //0-->��, 1-->��, 2-->��, 3-->��
		//���е����n^2��
		for (i = 1; i <= n * n; ++i) {
			res[x][y] = i; //����
			//��һ�����λ��
			nx = x + dx[d];
			ny = y + dy[d];			 
			//�жϷ����Ƿ���ȷ�����ܳ�������Χ ���ߵ��Ѿ������(ֵ������-1)-----��ײ���
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || res[nx][ny] != -1) {  
			  //������ײ�����µ�������
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
