package com.lyf.simple;

import org.junit.Test;

import com.sun.jmx.trace.Trace;

import sun.misc.Sort;

/**
 *@function ����һ�������� source �ַ�����һ�� target �ַ�����
 *			��Ӧ���� source �ַ������ҳ� target �ַ������ֵĵ�һ��λ��(��0��ʼ)����������ڣ��򷵻� -1
 *			Examples:
 *			��� source = "source" �� target = "target"������ -1��
			��� source = "abcdabcdefg" �� target = "bcd"������ 1��
 *@author Administrator
 *@date 2018��4��26�� ����12:04:24 
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
	 * ˳������ַ���,ʱ�临�Ӷȸ�
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
	 *  ˳�����2
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
