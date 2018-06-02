package com.lyf.simple;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

/**
 * @function һ�����ǲ��ǿ�������ô����ģ�����һ����������ÿһ�ν������滻Ϊ��ÿ��λ���ϵ����ֵ�ƽ���ͣ�
 *           Ȼ���ظ��������ֱ���������Ϊ1����������ѭ����ʼ�ձ䲻��1��������Ա�Ϊ1����ô��������ǿ������� example 19
 *           ����һ���������� 1^2 + 9^2 = 82 8^2 + 2^2 = 68 6^2 + 8^2 = 100 1^2 + 0^2 +
 *           0^2 = 1
 * @author Administrator
 * @date 2018��3��19�� ����9:34:23
 *
 */
public class HappyNumber {

	@Test
	public void test() {
		if (isHappyNum(1)) {
			System.out.println("ok");
		}
	}

	HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();

	/**
	 * �жϿ�����
	 * 
	 * @param n
	 * @return
	 */
	public boolean isHappyNum(int n) {
		boolean flag = false;
		if (0 >= n)
			return flag;
		visited.put(n, 0);
		int num = 0;
		int sum = 0;
		do {
			num = n % 10;
			n = n / 10;
			sum += num * num;
		} while (n != 0);
		if (1 == sum) {
			flag = true;
		} else if (visited.containsKey(sum)) {
			return flag;
		} else {
			flag = isHappyNum(sum);
		}
		return flag;
	}
	
	/**
	 * �ݹ�������ĺ���ʵ��
	 * @param n
	 * @return
	 */
	private int getNextHappy(int n) {
		int sum = 0;
		while (n != 0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}

	public boolean isHappy(int n) {
		HashSet<Integer> hash = new HashSet<Integer>();
		while (n != 1) {
			if (hash.contains(n)) {
				return false;
			}
			hash.add(n);
			n = getNextHappy(n);
		}
		return true;
	}

}
