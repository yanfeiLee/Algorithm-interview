package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * @function ѭ������ The words are same rotate words if rotate the word to the
 *           right by loop, and get another. Count how many different rotate
 *           word sets in dictionary.
 *
 *           example Given dict = ["picture", "turepic", "icturep", "word",
 *           "ordw", "lint"] return 3; explain "picture", "turepic", "icturep"
 *           are same ratote words. "word", "ordw" are same too. "lint" is the
 *           third word that different from the previous two words.
 * @author Administrator
 * @date 2018��3��22�� ����3:17:39
 *
 */
public class RotateWord {

	@Test
	public void test() {
		ArrayList<String> dict = new ArrayList<String>(
				Arrays.asList("picture", "turepic", "icturep", "word", "ordw", "lint"));
		System.out.println(dict.size());
		System.out.println(getRotateWordNum2(dict));
	}

	/**
	 * ��ȡList����ת���ʵ����� ˼·�� 1.����ÿ������ 2.���ε��ʿ��ܳ��ֵ���ת�������ַ�����ȡ������ȫ�����ɣ�����hashMap
	 * 3.�ӵ�ǰ�������Դ�������ʣ�൥�ʣ������hashmap������ͬkey�����Ƴ� 4.��ȡʣ��list�ĳ��ȣ���Ϊ������ת���ϵĸ���
	 * 
	 * @param words
	 * @return
	 */
	public int getRotateWordNum(List<String> words) {
		if (words == null || words.size() == 0) {
			return 0;
		}
		for (int i = 0; i < words.size(); i++) {
			String s = words.get(i);
			int len = s.length();
			// �����ε��ʿ��ܵ���ת��Ȼ��hashMap�洢
			HashMap<String, Integer> sh = new HashMap<String, Integer>();
			sh.put(s, 1);
			for (int j = 1; j < len; j++) {
				sh.put(s.substring(j, len) + s.substring(0, j), 1);
			}
			for (int j = i + 1; j < words.size(); j++) {
				if (s.length() != words.get(j).length())
					continue;
				if (sh.containsKey(words.get(j))) {
					words.remove(j);
					j--;
				}
			}
			sh.clear();
		}
		return words.size();
	}
	/**
	 * ����hashsetʵ�֣���ͬһ���������ӣ���ȡ�ַ����ﵽѭ����Ч��
	 * @param words
	 * @return
	 */
	public int getRotateWordNum2(List<String> words) {
		if (words == null || words.size() == 0) {
			return 0;
		}
		Set<String> dict = new HashSet<String>();
		for (String w : words) {
			String s = w + w;  
			for (int i = 0; i < w.length(); i++) {
				dict.remove(s.substring(i, i + w.length()));
			}

			dict.add(w);
		}
		return dict.size();
	}
}
