package com.lyf.simple;

 
import java.util.*;

import org.junit.Test;

/**
 *@function  ������������Ľ������׳���ʱ�临�Ӷȹ��������
 *	Note:
 *	ÿ��Ԫ�س��ִ����ú���������һ��
 *	�𰸿���������˳�����
 *	Example:
 *	[1, 2, 2, 1]��[2, 2]  => [2, 2]	
 *@author Administrator
 *@date 2018��4��7�� ����10:38:27 
 *
 */
public class ArrayDuplicate {

	@Test
	public void test() {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		int[] res = getArrDuplicate2(nums1, nums2);
		for(int i:res){
			System.out.print(i+",");
		}

	}
	
	/**
	 * ����HashMap�������Ľ���
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] getArrDuplicate(int[] nums1, int[] nums2){		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; ++i) {
            if (map.containsKey(nums1[i]))
                map.put(nums1[i], map.get(nums1[i]) + 1); 
            else
                map.put(nums1[i], 1);
        }

        List<Integer> results = new ArrayList<Integer>();

        for (int i = 0; i < nums2.length; ++i){
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                results.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1); 
            }
        }
        int result[] = new int[results.size()];
        for(int i = 0; i < results.size(); ++i){
        	result[i] = results.get(i);
        }            
        return result;	 
	}
	
	/**
	 * ��������������Ȼ�������������ֱ���������������ʼλ�ã�������������������������ȣ�
	 * �����ִ������У���������������1�������һ����������������ִ���ڶ�����������1����֮��Ȼ��
	 * 
	 */	
	public int[] getArrDuplicate2(int[] nums1, int[] nums2){		
		Arrays.sort(nums1);
	    Arrays.sort(nums2);

	    List<Integer> tmp = new ArrayList<>();

	    int i = 0;
	    int j = 0;
	    while (i < nums1.length && j < nums2.length) {
	        if (nums2[j] > nums1[i]) {
	            i++;
	        } else if (nums2[j] < nums1[i]) {
	            j++;
	        } else {
	            tmp.add(nums1[i]);
	            i++;
	            j++;
	        }
	    }

	    int[] result = new int[tmp.size()];
	    for (int k = 0; k < result.length; k++) {
	        result[k] = tmp.get(k);
	    }
	    return result;
	}
	
}
