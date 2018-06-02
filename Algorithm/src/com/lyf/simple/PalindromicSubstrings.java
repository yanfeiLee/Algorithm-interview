package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/** 
 *@function 计算某个字符串中的回文字符串  【容易出现内存超出限制大小的情况】  ===>动态规化[DP]
 *	Given a string, your task is to count how many palindromic substrings in this string.
 *	The substrings with different start indexes or end indexes are counted as different 
 *	substrings even they consist of same characters.
 *
 *	Example：
 *	Input: "abc"
 *	Output: 3
 *	Explanation: Three palindromic strings: "a", "b", "c".
 *@author Administrator
 *@date 2018年4月7日 上午11:17:10 
 *
 */
public class PalindromicSubstrings {

	@Test
	public void test() {
		 
		String s = "moloonlnollmolomnnnmononlononmnnnoolllmlnlloloononmmomnolllnnm"
				+ "nlmmmmmnlonlllnomommonnomnmmnolnlmnmmolnlonlmonolonmlollommnlnooonlolmo"
				+ "nommlolnlnnmnolmlmonnooonlmmonollmlmomlonlmnnmmmnnmoooolmomllnnmlolmnlnnm"
				+ "lnmomoloomloomnmoomllmllmnlmlnnlnonolmnoonloonmnlmmmmlonnmllomnmnlmlmlonommo"
				+ "mmnlonnlmlmlomlolnlnnloomnllomnnonoolnmmolnlonlmmmolmonolmolnnommmmnnnnollmoo"
				+ "mlloooommonmmmllllmlomnnmnlomllomlnmnlnooonllonolnloomoooonmmnmnomllmnonlllnloo"
				+ "lmonomomnmonmoollmmmommlnlllomonnllmlnmlonlllllnnmmoolmnmlmnn";
//		if(s.charAt(0) == s.charAt(3)){
//			System.out.println("===");
//		}
//		int n =10;
//		boolean DP[][]=new boolean[n][n];
//		System.out.println(DP[2][3]);
		 
		System.out.println(countPalindromicSubstrings2(s));
	}
	/**
	 * 分割子字符串，然后依次判断,【耗费内存】
	 * @param str
	 * @return
	 */
	public int countPalindromicSubstrings(String str) {        
        int len = str.length();
        int res = len;  //单个字符分割，       
		for (int i = 2; i < len + 1; i++) {
			for (int j = 0; j <= len-i; j++) {
				if(isPalindromStr(str.substring(j, j+i))){
					res++;
				}
			}
		}		
		return res;
    }
	/**
	 * 判断是否位回文字符串
	 * @param s
	 * @return
	 */
	private boolean isPalindromStr(String s){
		int len = s.length();
		boolean flag = true;
		for (int i = 0; i < len/2; i++) {
			if(s.charAt(i) != s.charAt(len-i-1)){
				flag = false;
				break;
			}
		}
		return flag;
		
		
		/*StringBuffer sb = new StringBuffer(s);
		if(s.toString().equals(sb.reverse().toString())){
			return true;
		}else{
			return false;
		}*/
	}
	
	
	//利用动态规划[dynamic planing]
	public int countPalindromicSubstrings2(String s) {  
	    if(s.equals("")){  
	        return 0;  
	    }  
	    int count=0;  
	    char[] cs=s.toCharArray();  
	    int n=cs.length;  
	    boolean DP[][]=new boolean[n][n];   //默认false
	    for(int i=0;i<n;i++){  
	        DP[i][i]=true;   //对角线位置，即单个字符都属于回文
	    }  
	    count+=n;  
	    for(int len=1;len<n;len++){  
	        for(int i=0;i<n-len;i++){  
	            int j=i+len;  
	            if(cs[i]!=cs[j]){  
	                DP[i][j]=false;  
	            }else{  
	                DP[i][j]=isPalindrom(DP, i+1, j-1);  
	                if(DP[i][j]==true){  
	                    count++;  
	                }  
	            }  
	        }  
	    }  
	    return count;  
	}  	  
	private boolean isPalindrom(boolean DP[][],int i,int j){  
	    if(i>=j){   //交叉或者相等
	        return true;  
	    }else{  
	        return DP[i][j];  
	    }  
	}  
	
	/**
	 * 思路:考虑不同的回文中心，然后从中心扩大，求以某个中心来获得的回文个数。
	 * 有两种情况：子串 s[ i - j , ...,  i + j ] 中, i 是回文中心（这是奇数串的情形）。
	 * 子串 s[ i - 1 - j , ...,  i + j ] 中，( i - 1 , i ) 是回文中心（这是偶数串的情形）
	 * @param s
	 * @return
	 */	
	public int countPalindromicSubstrings3(String s) { 
		int res = 0, n = s.length();  
	    for(int i = 0; i<n ;i++ ){  
	        for(int j = 0; i-j >= 0 && i+j < n && s.charAt(i-j) == s.charAt(i+j); j++){  
	            res++; //substring s[i-j, ..., i+j]  长度为奇数
	        }  
	        for(int j = 0; i-1-j >= 0 && i+j < n && s.charAt(i-1-j) == s.charAt(i+j); j++){  
	            res++; //substring s[i-1-j, ..., i+j] 长度为偶数
	        }  
	    }  
	    return res;  
	}
}
