package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 *@function 根据单词相似度规则，判断两句话是否相似
 *		Given two sentences words1, words2 (each represented as an array of strings), 
 *		and a list of similar word pairs pairs, determine if two sentences are similar.
 *	 Example:
 *		 "great acting skills" and "fine drama talent" are similar, if the similar 
 *		 word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]]
 *
 *	 Note:
 *		Note that the similarity relation is not transitive. For example, if "great" and "fine" 
 *		are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.
 *		
 *		However, similarity is symmetric. For example, "great" and "fine" being similar is the same as 
 *		"fine" and "great" being similar.
 *		
 *		Also, a word is always similar with itself. For example, the sentences words1 = ["great"], 
 *		words2 = ["great"], pairs = [] are similar, even though there are no specified similar word
 *		pairs
 *
 *		Finally, sentences can only be similar if they have the same number of words. So a sentence 
 *		like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 *
 *
 *		1.The length of words1 and words2 will not exceed 1000.
		2.The length of pairs will not exceed 2000.
		3.The length of each pairs[i] will be 2.
		4.The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 *@author Administrator
 *@date 2018年4月14日 上午11:47:20 
 *
 */
public class SentenceSimilarity {

	@Test
	public void test() {
		String[] words1 = {"great", "acting" ,"skills"};
		String[] words2 = {"fine","drama","talent"};
		List<String> p1 = new ArrayList<String>();
		List<String> p2 = new ArrayList<String>();
		List<String> p3 = new ArrayList<String>();
//		List<String> p4 = new ArrayList<String>();
		p1.add("great");
		p1.add("fine");
		p2.add("acting");
		p2.add("drama");
		p3.add("skills");
		p3.add("talent");
//		p4.add("great");
//		p4.add("good");
		List<List<String>> pairs = new ArrayList<List<String>>();
		pairs.add(p1);
		pairs.add(p2);
		pairs.add(p3);
//		pairs.add(p4);
		
		System.out.println("句子"+isSentenceSimilarity2(words1, words2, pairs));
	}
	
	/**
     * @param words1: a list of string
     * @param words2: a list of string
     * @param pairs: a list of string pairs
     * @return: return a boolean, denote whether two sentences are similar or not
     */
    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {        
         if(words1.length != words2.length) return false;
         int len = words1.length;
         Map<String,HashSet<String>>  pairsMap = new HashMap<String, HashSet<String>>();
         HashSet<String> hs  = new HashSet<String>();
         for(List<String> p : pairs){        	
        	 if(!pairsMap.containsKey(p.get(0))){
         		 pairsMap.put(p.get(0), new HashSet<String>());
         	 }
         	 pairsMap.get(p.get(0)).add(p.get(1));
         }         
         for (int i = 0; i < len; i++) {
        	 String s1 = words1[i];
        	 String s2 = words2[i];
        	 if(s1.equals(s2)){
        		 continue;
        	 }
        	 if((pairsMap.containsKey(s1)&& !pairsMap.get(s1).contains(s2)) && (pairsMap.containsKey(s2)&& !pairsMap.get(s2).contains(s1))){
        		 return false;
        	 }
         }          
         return true;
    }
    
    //2 官方解
    public boolean isSentenceSimilarity2(String[] words1, String[] words2, List<List<String>> pairs){
    	if(words1.length != words2.length){
    		return false;
    	}
    	Map<String,Set<String>> map = new HashMap<String, Set<String>>();
    	for(List<String> p :pairs){
    		if(!map.containsKey(p.get(0))){
    			map.put(p.get(0), new HashSet<String>());        		
	       	}
    		map.get(p.get(0)).add(p.get(1));
    	}
    	
    	for (int i = 0; i < words2.length; i++) {
    		 String s1 = words1[i];
        	 String s2 = words2[i];
        	 //getOrDefault 为jdk1.8中新增函数
//        	 if(!s1.equals(s2) && !map.getOrDefalut(s1,new HashSet<>()).contains(s2) && !map.getOrDefalut(s2,new HashSet<>().contains(s1)){
//        		 return false;
//        	 }
		}
    	return true;
    }
}
