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
 *@date 2018年4月13日 上午10:43:08 
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
        // 使用charCounter array，我们可以知道在某一个字符后面是否还有另一个字符。  
        int[] charCounter = new int[256];
        //统计每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
        	//s.charAt(i)为数字 97——122
            charCounter[s.charAt(i)]++;  
        }            
        Set<Character> hashSet = new HashSet<Character>();  
        Stack<Character> stack = new Stack<Character>();  
          
        for (int i = 0; i < s.length(); i++) {  
            if (!hashSet.contains(s.charAt(i))) {  //没有s.charAt(i)时            	            	 
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
