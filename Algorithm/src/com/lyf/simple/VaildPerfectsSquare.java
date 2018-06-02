package com.lyf.simple;

import org.junit.Test;

/**
 * @function ����һ���������ж����Ƿ���ĳ��������ƽ��������ʹ���ڽ�����sqrt�� ע: int overflow
 * @author Administrator
 * @date 2018��3��12�� ����12:17:18
 *
 */
public class VaildPerfectsSquare {

	@Test
	public void test() {		
		int s = 232563991;
		long r = (long)s*s;
		long r2 = (long)s*s; //����Integer������ʾֵʱ���Զ���ȡ��32λ
		System.out.println(r);
		if(isPerfectSquare2(2147395601)){
			System.out.println("perfect square!");
		}else{
			System.out.println("no");
		}
	}

	/**
	 * ʱ�临�Ӷ�O(log2(N)),���ַ�
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
		long start = 1, end = (long) num; // ת��Ϊlong��ֹ���
		while (start + 1 < end) { // �ҵ�midʱ����ֹ��ѭ��
			long mid = start + (end - start) / 2;
			if (mid * mid < num) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (start * start == (long) num || end * end == (long) num) {
			return true;
		}
		return false;
	}

	/**
	 * ʱ�临�Ӷ�O(n/2)
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare2(int num) {
		boolean flag = false;
		if (0 > num)
			return flag;
		int n = num % 10;
		//��λΪ������Щ��ʱ�����ܿ���
		if (n == 2 || n == 3 || n == 7 || n == 8)  
			return flag;
		for (int i = 1; i <= num / 2 + 1; i++) {
			if ((long)i * i == num) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
