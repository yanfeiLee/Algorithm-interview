package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 *@function 查找回文子序列
 *				A positive integer is a palindrome if its decimal representation (without leading zeros) 
 *			is a palindromic string (a string that reads the same forwards and backwards). For example, 
 *			the numbers 5, 77, 363, 4884, 11111, 12121 and 349943 are palindromes.
 *				A range of integers is interesting if it contains an even number of palindromes. The range 
 *			[L, R], with L <= R, is defined as the sequence of integers from L to R (inclusive): 
 *			(L, L+1, L+2, …, R-1, R). L and R are the range’s first and last numbers.
				The range [L1, R1] is a subrange of [L, R] if L <= L1 <= R1 <= R. Your job is to 
			determine how many interesting subranges of [L, R] there are.
			Examples:
				Given L = 1, R = 2, return 1 [[1,2]]
				Given L = 1, R = 7, return 12 [6+4+2]
				Given L = 87, R = 88, return 1 [[87,87],[88,88],[87,88]]
 *@author Administrator
 *@date 2018年5月4日 上午11:01:07 
 *
 */
public class PalindromicRanges {

	@Test
	public void test() {
		System.out.println("cnt=="+PalindromicRanges3(10,22));
		//System.out.println(isPalindromic(20));
//		System.out.println(isPalin(20));
//		if("78".equals("87")){
//			System.out.println("ok");
//		}else{
//			System.out.println("no");
//		}
	}
	
	/**
	 * 思路：计算R和L间，所有的子区间，依此判断，区间中是否有偶数个回文数
	 * Time Or Memory Limit
	 * @param L
	 * @param R
	 * @return
	 */
	public int PalindromicRanges(int L, int R) {
        int len = R -L;
        int cnt = 0;
        int start = L;
		int end = 0;
		for (int i = 0; i <= len; i++) {
			end = start + i;
			for (int k = end; k <= R ; k++) {				 
				int tmp = 0;
				for(int j = start;j <= end; j++){
					System.out.println( (j));
					if(isPalindromic(j)){
						tmp++;
					}				
				}
				if(0 == tmp%2){
					cnt++;					 
				}
				start++;
				end++;				
			}
			start = L;
		}
		return cnt;
    }
	private boolean isPalindromic(int num){
		StringBuffer sb = new StringBuffer(num+"");		 
		if(sb.toString().equals(sb.reverse().toString())){
			System.out.println("ok");
			return true;
		}else{
			return false;
		}		
	}
	/**
	 * 
	 * @param L
	 * @param R
	 * @return
	 */
	public int PalindromicRanges2(int L, int R) {
        // 边界判断
        if (L > R) {
            return 0;
        }
        if (L == R && !isPalin(L)) {
            return 1;
        }
        // [10, 22] -> list: {1,0,10,0}
        // 是回文数字，则添加其距离开始L的距离和0到list中
        List<Integer> list = new ArrayList<>();
        int start = L;
        int i = L;
        for (; i <= R; i++) {
            if (isPalin(i)) {
                list.add(i - start);
                if (i != start) {
                    list.add(0);
                }
                //更新起始位置为当前回文数字+1;
                start = i + 1;
            }
        }
        //当R，R—1,...,不是回文数字时
        if (i > start) {
            list.add(i - start);
        }
        //统计回文数个数为偶数的子区间
        int count = 0;
        for (int j = 0; j < list.size(); j++) {
            count += list.get(j);
            if (list.get(j) != 0) {
                count += list.get(j) * (list.get(j) - 1) / 2;
            }
            //
            int zeros = list.get(j) == 0 ? 1:0;
            for (int k = j + 1; k < list.size(); k++) {
                zeros += list.get(k) == 0 ? 1:0;
                if (zeros % 2 == 0) {
                    int a = list.get(j) == 0 ? 1:list.get(j);
                    int b = list.get(k) == 0 ? 1:list.get(k);
                    count += a * b;
                }
            }
        }
        return count;
    }
	//回文字符判断
	private boolean isPalin(int a) {
	        String s = String.valueOf(a);
	        int i = 0;
	        int j = s.length() - 1;
	        while (i < j) {
	            if (s.charAt(i) != s.charAt(j)) {
	                return false;
	            }
	            i++;
	            j--;
	        }
	        return true;
	 }

	public int PalindromicRanges3(int L, int R){
		 /**
		  * 思路： 
			题目的意思是计算包含偶数个回文数字的子区间的个数。 
			例如L=8，R=11 
			8，9，10, 11 
			构建数组v，判断是否为回文数字，得到{1,1,0,1} 
			接下来寻找包含的数字之和为偶数的子区间 
			即为：{0}，{1，1}，{1，1，0}，{1，0，1}  
		  */
        int range = R - L + 1;
        int cnt = 0;
        List<Integer> v = new ArrayList<Integer>();//构建数组表示每个数字是否是回文数字
        for (int i = L; i <= R; ++i)
        {
            if (isPalin(i))
                v.add(1);
            else
            {
                v.add(0);
                cnt++;
            }
        }
        for (int j = 1; j < range; ++j)
        {
            int num = v.get(j-1);
            for (int k = j; k <range; ++k)
            {
                num += v.get(k);
                if (num % 2 == 0)
                    cnt++;
            }
        }
        return cnt;	 
	}

}
