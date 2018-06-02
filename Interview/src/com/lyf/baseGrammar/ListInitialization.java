package com.lyf.baseGrammar;

import java.util.*;
 

import org.junit.Test;

/**
 *@function
 *@author lyf3312
 *@date 2018年3月22日 下午4:57:07 
 *
 */
public class ListInitialization {

	@Test
	public void test() {
		//初始化ArrayList
		ArrayList<String> l = new ArrayList<String>(Arrays.asList("c","cpp","c#","java","php","linux"));	
		l.add("google");
		l.remove(3);
		for(String s:l){
			System.out.println(s);			
		}
		
		ArrayList<String> lang = new ArrayList<String>(3);
		lang.add("php");
		lang.add("java");
		lang.add("linux");
		lang.add("hadoop");	
		for(String s:lang){
			System.out.println(s);
		}
	}
}
