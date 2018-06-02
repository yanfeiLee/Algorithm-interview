package com.lyf.simple;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

/**
 * @function 一个数是不是快乐是这么定义的：对于一个正整数，每一次将该数替换为他每个位置上的数字的平方和，
 *           然后重复这个过程直到这个数变为1，或是无限循环但始终变不到1。如果可以变为1，那么这个数就是快乐数。 example 19
 *           就是一个快乐数。 1^2 + 9^2 = 82 8^2 + 2^2 = 68 6^2 + 8^2 = 100 1^2 + 0^2 +
 *           0^2 = 1
 * @author Administrator
 * @date 2018年3月19日 上午9:34:23
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
	 * 判断快乐数
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
	 * 递归在另外的函数实现
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
