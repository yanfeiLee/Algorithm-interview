package com.lyf.simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 *@function Given a pattern and a string str, find if str follows the same pattern.
 *Here follow means a full match, such that there is a bijection between a letter in
 *pattern and a non-empty word in str.
 *Example:
 *  Given pattern = "abba", str = "dog cat cat dog", return true.
	Given pattern = "abba", str = "dog cat cat fish", return false.
	Given pattern = "aaaa", str = "dog cat cat dog", return false.
	Given pattern = "abba", str = "dog dog dog dog", return false.
 *@author Administrator
 *@date 2018年3月23日 下午12:07:32 
 *
 */
public class WordPattern {

	@Test
	public void test() {
		String pattern = "abba";
		String str = "dog cat cat fish";				
		System.err.println(isValidString(pattern, str));
	}
	
	public boolean isValidString(String pattern, String str){
		boolean res = false;
		String[] s = str.split(" ");
		int len = s.length;
		if(len != s.length) return res;
		Map<Character,String> hm = new HashMap<Character, String>();
		Set<String> hs = new HashSet<String>();
		for (int i = 0; i < len; i++) {
			char key = pattern.charAt(i);
			if(hm.containsKey(key)){
				if(!hm.get(key).equals(s[i])) return res;
			}else{
				if(hs.contains(s[i])) return res;
				hm.put(key, s[i]);
				hs.add(s[i]);
			}
		}
		return !res;
	}
	
}
