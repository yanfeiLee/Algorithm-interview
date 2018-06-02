package com.lyf.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 *@function
 *@author Administrator
 *@date 2018年4月13日 上午10:55:21 
 *
 */
public class TraverseHashMap {

	@Test
	public void test() {
		Map<String,String> m = new HashMap<String, String>();
		m.put("a", "23");
		m.put("b", "213");
		m.put("c", "223");
		traverseMap(m);
	}
	public void traverseMap(Map<String,String> m){
		System.out.println("\n通过Map.entrySet遍历key和value");  
        for(Map.Entry<String, String> entry: m.entrySet())
        {
         System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
        }
	}
}
