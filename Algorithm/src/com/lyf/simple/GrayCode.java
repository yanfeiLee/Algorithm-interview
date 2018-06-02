package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 *@function 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个二进制的差异。
	给定一个非负整数 n ，表示该代码中所有二进制的总数，请找出其格雷编码顺序。一个格雷编码顺序必须以 0 开始，并覆盖所有的 2n 个整数。
	Note:对于给定的 n，其格雷编码顺序并不唯一。	根据以上定义， [0,2,3,1] 也是一个有效的格雷编码顺序。
	Examples:
		给定 n = 2， 返回 [0,1,3,2]。其格雷编码顺序为：
		00 - 0
		01 - 1
		11 - 3
		10 - 2
 *@author Administrator
 *@date 2018年5月19日 上午10:41:41 
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
