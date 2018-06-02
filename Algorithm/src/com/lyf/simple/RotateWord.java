package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * @function 循环单词 The words are same rotate words if rotate the word to the
 *           right by loop, and get another. Count how many different rotate
 *           word sets in dictionary.
 *
 *           example Given dict = ["picture", "turepic", "icturep", "word",
 *           "ordw", "lint"] return 3; explain "picture", "turepic", "icturep"
 *           are same ratote words. "word", "ordw" are same too. "lint" is the
 *           third word that different from the previous two words.
 * @author Administrator
 * @date 2018年3月22日 下午3:17:39
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
	 * 获取List中旋转单词的数量 思路： 1.遍历每个单词 2.将次单词可能出现的旋转，利用字符串截取方法，全部生成，存于hashMap
	 * 3.从当前单词起，以此向后遍历剩余单词，如果和hashmap存在相同key，则移除 4.获取剩余list的长度，即为单词旋转集合的个数
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
			// 生产次单词可能的旋转，然后hashMap存储
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
	 * 利用hashset实现，将同一个单词连接，截取字符串达到循环的效果
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
