package com.lyf.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

/**
 *@function  ��һ���ʵ䣬�ҳ�����������ĵ��ʡ�
 *			Examples��
 *				{
				  "dog",
				  "google",
				  "facebook",
				  "internationalization",
				  "blabla"
				} ��, ��ĵ��ʼ���Ϊ ["internationalization"]
				{
				  "like",
				  "love",
				  "hate",
				  "yes"
				}�У���ĵ��ʼ���Ϊ ["like", "love", "hate"]
 *@author Administrator
 *@date 2018��5��3�� ����10:44:14 
 *
 */
public class LongestWord {

	@Test
	public void test() {
		String[] dictionary = {
				"dog",
				  "google",
				  "facebook",
				  "internationalization",
				  "blabla"
		};
		for(String s:longestWords3(dictionary)){
			System.out.println(s);
		}
	}
	/**
	 * ����hashmapʵ��
	 * @param dictionary
	 * @return
	 */
	public List<String> longestWords(String[] dictionary) {
		 List<String> tmp = null;
         Map<Integer,List> hm = new HashMap<Integer,List>();
         for (int i = 0; i < dictionary.length; i++) {
			 if(!hm.containsKey(dictionary[i].length())){
				 tmp = new ArrayList<String>();
			 }else{
				 tmp = hm.get(dictionary[i].length());			  
			 }
			 tmp.add(dictionary[i]);
			 hm.put(dictionary[i].length(),tmp);
		 }
         int maxIndex = 0;
         for(Map.Entry<Integer,List> entry: hm.entrySet()){
        	 if(maxIndex < entry.getKey()){
        		 maxIndex = entry.getKey();
        	 }
         }
         return hm.get(maxIndex);
    }
	/**
	 * ֱ�ӱȽ����
	 * @param dictionary
	 * @return
	 */
	public List<String> longestWords2(String[] dictionary) {
		List<String> res = new ArrayList<String>();
		int maxLen = 0;
		for (int i = 0; i < dictionary.length; i++) {
			if(maxLen < dictionary[i].length()){
				maxLen = dictionary[i].length();
				res.clear();
				res.add(dictionary[i]);
			}else if(maxLen == dictionary[i].length()){
				res.add(dictionary[i]);
			}else{
				continue;
			}
		}
		return res;
	}
	//������󳤶ȣ�Ȼ�����
	public ArrayList<String> longestWords3(String[] dictionary) {
        // write your code here
        int maxLen = 0;
        ArrayList<String> ans = new ArrayList<String>();
        for (int i=0; i<dictionary.length; ++i) 
            if (dictionary[i].length()>maxLen) maxLen = dictionary[i].length();
        for (int i=0; i<dictionary.length; ++i)
            if (dictionary[i].length()==maxLen) ans.add(dictionary[i]);
        return ans;
    }
}
