package com.lyf.simple;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

/**
 *@function  Given a string which contains only lowercase letters, remove duplicate letters so that 
 *every letter appear once and only once.You must make sure your result is 
 *the smallest in lexicographical order among all possible results.
 *	Examples:
 *		Given "bcabc"
 *		Return "abc"
 *		
 *		Given "cbacdcbc"
 *		Return "acdb"
 *@author Administrator
 *@date 2018��4��13�� ����10:43:08 
 *
 */
public class RemoveDuplicateLetters {

	@Test
	public void test() {
		String s = "cbacdcbc";
		System.out.println(s.charAt(2)+0);
		System.out.println(removeDuplicateLetters(s));
//		String ss = "[a, c, d, b]";
//		String[] r = ss.substring(1, ss.length()).split(",");
//		System.out.println(r[0]);
	}
	
	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() <= 1) return s;  
        // ʹ��charCounter array�����ǿ���֪����ĳһ���ַ������Ƿ�����һ���ַ���  
        int[] charCounter = new int[256];
        //ͳ��ÿ���ַ����ֵĴ���
        for (int i = 0; i < s.length(); i++) {
        	//s.charAt(i)Ϊ���� 97����122
            charCounter[s.charAt(i)]++;  
        }            
        Set<Character> hashSet = new HashSet<Character>();  
        Stack<Character> stack = new Stack<Character>();  
          
        for (int i = 0; i < s.length(); i++) {  
            if (!hashSet.contains(s.charAt(i))) {  //û��s.charAt(i)ʱ            	            	 
                while (stack.isEmpty() == false && stack.peek() > s.charAt(i) && charCounter[stack.peek()] >= 1) {  
                    hashSet.remove(stack.peek());  
                    stack.pop();  
                }  
                stack.push(s.charAt(i));  
                hashSet.add(s.charAt(i));  
            }  
            charCounter[s.charAt(i)]--;  
        }
        String res = stack.toString();
        return res.substring(1,res.length()-1).replace(", ", "");
    }
}
