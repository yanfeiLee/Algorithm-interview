package com.lyf.simple;

import java.util.Stack;

import org.junit.Test;

/**
 * @function 输入流比较：给出两个输入流inputA和inputB，有Backspace,如果两个输入流最后的结果相等，输出YES，否则输出NO。
 *           给出 inputA = “abcde<<”, inputB = “abcd<e<”, 返回 “YES”。
 *           inputA和inputB最后的结果都为abc，故返回”YES”。 给出 inputA = “a<<bc”, inputB =
 *           “abc<”, 返回 “NO”。inputA最后的结果为”bc”,inputB最后的结果为”ab”，故返回”NO”。
 * @author Administrator
 * @date 2018年3月13日 下午3:41:16
 *
 */
public class InputStreamCmp {

	@SuppressWarnings("unused")
	@Test
	public void test() {
		System.out.println((int) '<'); // 60
		if (94 == '<') {
			System.out.println("ok");
		} else {
			System.out.println("not equal");
		}
		System.out.println("-----------");
		System.out.println(cmpInputStream2("dqwdqdasdqwd", "eiwfjwefweicjiwefj"));
	}

	/**
	 * 利用栈实现 ，时间复杂度O(3n)
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public String cmpInputStream(String A, String B) {
		String output = "YES";
		Stack<Character> sA = new Stack<Character>();
		Stack<Character> sB = new Stack<Character>();
		char[] charsA = A.toCharArray();
		char[] charsB = B.toCharArray();
		for (int i = 0; i < charsA.length; i++) {
			if (60 == charsA[i] && !sA.isEmpty()) {
				sA.pop();
			} else if (60 != charsA[i]) {
				sA.push(charsA[i]);
			}
		}
		for (int i = 0; i < charsB.length; i++) {
			if (60 == charsB[i] && !sB.isEmpty()) {
				sB.pop();
			} else if (60 != charsB[i]) {
				sB.push(charsB[i]);
			}
		}
		if (sA.size() == sB.size()) {
			for (int i = 0; i < sA.size(); i++) {
				if (sA.pop() != sB.pop()) {
					output = "NO";
					break;
				}
			}
		} else {
			output = "NO";
		}
		return output;
	}
	/**
	 * 循环字符数组实现,空间复杂度小
	 * @param inputA
	 * @param inputB
	 * @return
	 */
	public String cmpInputStream2(String inputA, String inputB) {
		char[] A = new char[inputA.length()];
		int lenA = 0;
		for (int i = 0; i < inputA.length(); i++) {
			if (inputA.charAt(i) == '<') {
				if (lenA > 0) {
					lenA--;
				}
			} else {
				A[lenA++] = inputA.charAt(i);
			}
		}
		char[] B = new char[inputB.length()];
		int lenB = 0;
		for (int i = 0; i < inputB.length(); i++) {
			if (inputB.charAt(i) == '<') {
				if (lenB > 0) {
					lenB--;
				}
			} else {
				B[lenB++] = inputB.charAt(i);
			}
		}
		if (lenA == lenB) {
			for (int i = 0; i < lenA; i++) {
				if (A[i] != B[i]) {
					return "NO";
				}
			}
			return "YES";
		}
		return "NO";
	}
}
