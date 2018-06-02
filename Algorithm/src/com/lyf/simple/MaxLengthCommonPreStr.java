package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/** 给出n个字符串,和一个目标串，输出目标串与这n个字符串的最长公共前缀的长度的最大值。
 * 注：n个字符串的长度总和sum，1 <= sum <= 50000.每个字符串的长度大于0(即没有空串)。
 * 给出["abcba","acc","abwsf"],target = "abse",return 2。
 * 解释：
 * "abse"与"abcba"的最长公共前缀为"ab"，长度为2,与"acc"最长公共前缀为"a"，长度为1，
 * 与"abwsf"最长公共前缀为"ab"，长度为2，max(2,1,2) = 2。
 *@function
 *@author Administrator
 *@date 2018年3月20日 上午9:21:15 
 *
 */
public class MaxLengthCommonPreStr {

	@Test
	public void test() {
		List<String> dic = new ArrayList<String>();
		dic.add("aaa");
		dic.add("bbb");
		dic.add("aabb");
		
		//arrayList 删除某个位置的元素后，后边位置的元素向前移动，补充被删除的位置
		System.out.println(dic.toString());
		dic.remove(0);
		System.out.println(dic.get(0));
		
		System.out.println(getMaxPreString2(dic, "aaab"));
	}
	
	/**
	 * 获取最长共同前缀长度
	 * @param dic
	 * @param target
	 * @return
	 */
	public int getMaxPreString(List<String> dic, String target){
		int res = 0;
		int count = 0;
		int tLen = target.length();
		ArrayList<Integer> tmpArr = new ArrayList<Integer>();
		for(String str:dic){
			for(int i = 0; i< tLen && i<str.length(); i++){
				if(str.charAt(i) != target.charAt(i)) break;
				count++;
			}
			tmpArr.add(count);
			count = 0;
		}
		//查找最大值
		for(Integer i:tmpArr){
			if(res < i) res = i;
		}
		return res;
	}
	/**
	 * 统计公共前缀长度后直接比较
	 * @param dic
	 * @param target
	 * @return
	 */
	public int getMaxPreString2(List<String> dic, String target){
		int res = 0;
		int count = 0;
		int tLen = target.length();
		int dLen = dic.size();		 
		for(int j = 0;  j < dLen; j++ ){
			String str = dic.get(j);
			for(int i = 0; i< tLen && i<str.length(); i++){
				if(str.charAt(i) != target.charAt(i)) break;
				count++;
			}
			if(res < count) res = count;
			count = 0;
		}		 
		return res;
	}
}
