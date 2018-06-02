package com.lyf.simple;

import java.util.Stack;

import org.junit.Test;

/**
 * @function �������Ƚϣ���������������inputA��inputB����Backspace,����������������Ľ����ȣ����YES���������NO��
 *           ���� inputA = ��abcde<<��, inputB = ��abcd<e<��, ���� ��YES����
 *           inputA��inputB���Ľ����Ϊabc���ʷ��ء�YES���� ���� inputA = ��a<<bc��, inputB =
 *           ��abc<��, ���� ��NO����inputA���Ľ��Ϊ��bc��,inputB���Ľ��Ϊ��ab�����ʷ��ء�NO����
 * @author Administrator
 * @date 2018��3��13�� ����3:41:16
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
	 * ����ջʵ�� ��ʱ�临�Ӷ�O(3n)
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
	 * ѭ���ַ�����ʵ��,�ռ临�Ӷ�С
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
