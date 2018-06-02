package com.lyf.simple;

import org.junit.Test;

/**
 *@functionԼ���������Һ���Ŀյ��Ͻ�һ����԰������������ש��
 *һ��3 dm�ĸ߶ȣ�7 dm�ĸ߶ȡ�Լ����Χ��x dm��ǽ�����Լ�������������YES���������NO��  xȡֵ[3, 1000]
 *���� x = 10������YES��x = 3 + 7 : ����Ҫ1ƥ3 dm�߶ȵ�ש��1ƥ7 dm �߶ȵ�ש��
 *���� x = 5������ NO�������ø߶�Ϊ3 dm��ש�͸߶�Ϊ7 dm��ש���� 5 dm��ǽ��
 *���� x = 13������YES��x = 2 * 3 + 7 : ����Ҫ2ƥ3 dm�߶ȵ�ש��1ƥ7 dm �߶ȵ�ש��
 *@author Administrator
 *@date 2018��3��23�� ����10:13:07 
 *
 */
public class BackYard {

	@Test
	public void test() {
		System.out.println(isBackYard(13));
	}

	/**
	 * �ȿ���������� Ȼ���չ�ʽ7m+3n=x �����ж�
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
	 * ���о����3����7��������Ϊ1������ж�x���Ƿ�Ϊ1
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
