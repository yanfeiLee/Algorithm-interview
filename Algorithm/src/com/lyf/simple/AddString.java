package com.lyf.simple;

import org.junit.Test;

/**
 * @function ���ַ�������ʽ���������Ǹ����� num1 �� num2������ num1 �� num2 �ĺ͡� Note�� num1 �� num2
 *           �ĳ��ȶ�С��5100�� num1 �� num2 ��ֻ�������� 0-9�� num1 �� num2 ���������κ�ǰ���㡣
 *           ������ʹ���κ����õ�BigInteger���ڵķ�����ֱ�ӽ�����ת��Ϊ������
 * 
 *           Example: ���� num1 = "123"��num2 = "45" ���� "168"
 * @author Administrator
 * @date 2018��4��16�� ����11:32:32
 *
 */
public class AddString {

	@Test
	public void test() {
		// String a = "123";
		// char[] cc = a.toCharArray();
		// System.out.println((cc[1]-48)+3);
		String num1 = "9999999999981";
		String num2 = "19";
		System.out.println(addStrings(num1, num2));

	}

	public String addStrings(String num1, String num2) {
		// write your code here
		char[] arr_1 = num1.toCharArray();
		char[] arr_2 = num2.toCharArray();
		int len = arr_1.length > arr_2.length ? arr_2.length : arr_1.length;
		StringBuilder sb = new StringBuilder();
		int next = 0; // ��λ
		int suffix = 0;// β��
		int tmp = 0;
		if (arr_1.length == len) {
			for (int i = len - 1; i >= 0; i--) {
				int i_2 = i + arr_2.length - len;
				tmp = arr_1[i] + arr_2[i_2] - 96 + next;
				next = 0;
				next = addNums(tmp, next, suffix, sb);
			}
			for (int i = arr_2.length - len - 1; i >= 0; i--) {
				tmp = arr_2[i] - 48 + next;
				next = 0;
				next = addNums(tmp, next, suffix, sb);
			}
			System.out.println("okk");
		} else {
			for (int i = len - 1; i >= 0; i--) {
				int i_1 = i + arr_1.length - len;
				tmp = arr_1[i_1] + arr_2[i] - 96 + next;
				next = 0;
				next = addNums(tmp, next, suffix, sb);
			}
			for (int i = arr_1.length - len - 1; i >= 0; i--) {
				System.out.println(arr_1[i] + "===" + next);
				tmp = arr_1[i] - 48 + next;
				next = 0;
				next = addNums(tmp, next, suffix, sb);
			}
		}
		if (next == 1)
			sb.append(next);
		return new StringBuffer(sb).reverse().toString();
	}

	private int addNums(int tmp,int next,int suffix,StringBuilder sb ) {
		if (tmp >= 10) {
			next = 1;
			suffix = tmp % 10;
		} else {
			suffix = tmp;
		}
		sb.append(suffix);
		return next;
	}
	//�ٷ���
	public String addStrings2(String num1, String num2){	
	  String res = "";
      int m = num1.length(), n = num2.length(), i = m - 1, j = n - 1, flag = 0;
      while(i >= 0 || j >= 0){
          int a, b; 
          if(i >= 0){
              a = num1.charAt(i--) - '0';
          }else{
              a = 0;
          }
          if(j >= 0){
              b = num2.charAt(j--) - '0';
          }else{
              b = 0;
          }
          int sum = a + b + flag;
          res =(char)(sum % 10 + '0') + res;
          flag = sum / 10;
      }
      return flag == 1 ? "1" + res: res; 
	}
}
