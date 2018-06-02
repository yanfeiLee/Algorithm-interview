package com.lyf.simple;

import org.junit.Test;

/**
 *@function Given a sequence of words, check whether it forms a valid word square.
 *A sequence of words forms a valid word square if the k^th row and column read the exact same string, where
 *0 ≤ k < 500
 *Given
 *	[
	  "abcd",
	  "bnrt",
	  "crmy",
	  "dtye"
	]
	return true 
  *Given
		[
		  "ball",
		  "area",
		  "read",
		  "lady"
		]
		return false
 *@author Administrator
 *@date 2018年3月21日 上午10:51:47 
 *
 */
public class ValidWordSquare {

	@Test
	public void test() {
		String[] words = {
				  "ball",
				  "area",
				  "read",
				  "lady"};
		String[] words2 = {
				  "abcd",
				  "bnrt",
				  "crm",
				  "dt"};
		if(isValidWordSquare2(words)){
			System.out.println("ok");
		}else{
			System.out.println("invalid");
		}
	}
	 
	/**
	 * 第i行j列 == 第j行i列的元素
	 * @param words
	 * @return
	 */
	public boolean isValidWordSquare2(String[] words){		  
	    if(words.length == 0)return true;
	    if(words.length != words[0].length()) return false;
	    for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				if(j > words.length || i > words[j].length() || words[i].charAt(j)!= words[j].charAt(i))
					return false;
			}
		}
	    return true;
	}
}
