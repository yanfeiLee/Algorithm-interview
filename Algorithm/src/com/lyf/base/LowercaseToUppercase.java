package com.lyf.base;

import org.junit.Test;

public class LowercaseToUppercase {
	@Test
	public void test(){
		char in = 'a';
		char in2 = 'C';
		System.out.println(lowercaseToUppercase(in));
		System.out.println(uppercaseToLowercase(in2));
		System.out.println(uppercaseToLowercase2(in2));
		System.out.println("-------------");
		System.out.println((char)19);
		
		System.out.println((int)in);
		System.out.println(+in+99);
		System.out.println((byte)in);
		/*char res[] = String.valueOf(in2).toLowerCase().toCharArray();
		System.out.println(res.length);
		for(char ch : res){
				System.out.println(ch);
		}*/
	}
	
	public char lowercaseToUppercase(char character) {
        // write your code here        
		
        return String.valueOf(character).toUpperCase().toCharArray()[0];
    }
	
	public char uppercaseToLowercase(char character) {
        // write your code here        		
        return String.valueOf(character).toLowerCase().toCharArray()[0];
    }
	
	public char uppercaseToLowercase2(char character) {
        // write your code here        		
        return (char)((byte)character + 32);
    }

	public char uppercaseToLowercase3(char character) {
        // write your code here        		
        return (char)(+character + 32);
    }
}
