package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 *@function ���ױ�����һ������������ϵͳ���ڸ�ϵͳ�У�������������ֵ����һ�������ƵĲ��졣
	����һ���Ǹ����� n ����ʾ�ô��������ж����Ƶ����������ҳ�����ױ���˳��һ�����ױ���˳������� 0 ��ʼ�����������е� 2n ��������
	Note:���ڸ����� n������ױ���˳�򲢲�Ψһ��	�������϶��壬 [0,2,3,1] Ҳ��һ����Ч�ĸ��ױ���˳��
	Examples:
		���� n = 2�� ���� [0,1,3,2]������ױ���˳��Ϊ��
		00 - 0
		01 - 1
		11 - 3
		10 - 2
 *@author Administrator
 *@date 2018��5��19�� ����10:41:41 
 *
 */
public class GrayCode {

	@Test
	public void test() {
		System.out.println(6^3);
	}
	
    public List<Integer> grayCode(int n) {
    	List<Integer> result = new ArrayList<Integer>();
        if (n <= 1) {
            for (int i = 0; i <= n; i++){
                result.add(i);
            }
            return result;
        }
        result = grayCode(n - 1);
        List<Integer> r1 = reverse(result);
        int x = 1 << (n-1);
        for (int i = 0; i < r1.size(); i++) {
            r1.set(i, r1.get(i) + x);
        }
        result.addAll(r1);
        return result;
	}
    public List<Integer> reverse (List<Integer> result) {
        ArrayList<Integer> rev = new ArrayList<Integer>();
        for (int i = result.size() - 1; i >= 0; i--) {
            rev.add(result.get(i));
        }
        return rev;
    }
    
    /**
     * Gray[i] = Gray[i-1]^B[i]
     */
    public List<Integer> grayCode2(int n) {
    	int size = 1 << n;          
        ArrayList<Integer> res = new ArrayList<Integer>();  
        for(int i = 0; i < size; i++) {  
            int grayCode = i ^ (i >> 1);  
            res.add(grayCode);  
        }  
        return res;  
    }
}
