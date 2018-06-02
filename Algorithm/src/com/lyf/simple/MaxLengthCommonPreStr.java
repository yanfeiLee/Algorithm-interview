package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/** ����n���ַ���,��һ��Ŀ�괮�����Ŀ�괮����n���ַ����������ǰ׺�ĳ��ȵ����ֵ��
 * ע��n���ַ����ĳ����ܺ�sum��1 <= sum <= 50000.ÿ���ַ����ĳ��ȴ���0(��û�пմ�)��
 * ����["abcba","acc","abwsf"],target = "abse",return 2��
 * ���ͣ�
 * "abse"��"abcba"�������ǰ׺Ϊ"ab"������Ϊ2,��"acc"�����ǰ׺Ϊ"a"������Ϊ1��
 * ��"abwsf"�����ǰ׺Ϊ"ab"������Ϊ2��max(2,1,2) = 2��
 *@function
 *@author Administrator
 *@date 2018��3��20�� ����9:21:15 
 *
 */
public class MaxLengthCommonPreStr {

	@Test
	public void test() {
		List<String> dic = new ArrayList<String>();
		dic.add("aaa");
		dic.add("bbb");
		dic.add("aabb");
		
		//arrayList ɾ��ĳ��λ�õ�Ԫ�غ󣬺��λ�õ�Ԫ����ǰ�ƶ������䱻ɾ����λ��
		System.out.println(dic.toString());
		dic.remove(0);
		System.out.println(dic.get(0));
		
		System.out.println(getMaxPreString2(dic, "aaab"));
	}
	
	/**
	 * ��ȡ���ͬǰ׺����
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
		//�������ֵ
		for(Integer i:tmpArr){
			if(res < i) res = i;
		}
		return res;
	}
	/**
	 * ͳ�ƹ���ǰ׺���Ⱥ�ֱ�ӱȽ�
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
