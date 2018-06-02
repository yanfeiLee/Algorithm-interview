package com.lyf.simple;

import org.junit.Test;

import com.sun.jmx.trace.Trace;

import sun.misc.Sort;

/**
 *@function 对于一个给定的 source 字符串和一个 target 字符串，
 *			你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1
 *			Examples:
 *			如果 source = "source" 和 target = "target"，返回 -1。
			如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。
 *@author Administrator
 *@date 2018年4月26日 下午12:04:24 
 *
 */
public class StrSearch {

	@Test
	public void test() {
		String source = "source";
		String target = "rced";
		System.out.println(strStr(source, target));
	}
	/**
	 * 顺序查找字符串,时间复杂度高
	 * @param source
	 * @param target
	 * @return
	 */
	public int strStr(String source, String target) {
		boolean flag = true;
		if("" == target) return 0;
		if("".equals(source) || null == source || null == target) return -1;				
		for (int i = 0; i < source.length(); i++) {
			if(source.charAt(i) == target.charAt(0)){
				flag = true;
				int j = 1;
				for (j = 1; j < target.length()&& i+j < source.length(); j++) {
					if(source.charAt(i+j) != target.charAt(j)){
						flag = false;
						break;
					}					 
				}
			    if(flag && target.length() == j) return i;
			}
		}
		return -1;         
    }
	/**
	 *  顺序查找2
	 * @param source
	 * @param target
	 * @return
	 */
	public int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            // finished loop, target found
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}
