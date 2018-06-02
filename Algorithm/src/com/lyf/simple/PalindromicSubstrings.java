package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/** 
 *@function ����ĳ���ַ����еĻ����ַ���  �����׳����ڴ泬�����ƴ�С�������  ===>��̬�滯[DP]
 *	Given a string, your task is to count how many palindromic substrings in this string.
 *	The substrings with different start indexes or end indexes are counted as different 
 *	substrings even they consist of same characters.
 *
 *	Example��
 *	Input: "abc"
 *	Output: 3
 *	Explanation: Three palindromic strings: "a", "b", "c".
 *@author Administrator
 *@date 2018��4��7�� ����11:17:10 
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
	 * �ָ����ַ�����Ȼ�������ж�,���ķ��ڴ桿
	 * @param str
	 * @return
	 */
	public int countPalindromicSubstrings(String str) {        
        int len = str.length();
        int res = len;  //�����ַ��ָ       
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
	 * �ж��Ƿ�λ�����ַ���
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
	
	
	//���ö�̬�滮[dynamic planing]
	public int countPalindromicSubstrings2(String s) {  
	    if(s.equals("")){  
	        return 0;  
	    }  
	    int count=0;  
	    char[] cs=s.toCharArray();  
	    int n=cs.length;  
	    boolean DP[][]=new boolean[n][n];   //Ĭ��false
	    for(int i=0;i<n;i++){  
	        DP[i][i]=true;   //�Խ���λ�ã��������ַ������ڻ���
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
	    if(i>=j){   //����������
	        return true;  
	    }else{  
	        return DP[i][j];  
	    }  
	}  
	
	/**
	 * ˼·:���ǲ�ͬ�Ļ������ģ�Ȼ���������������ĳ����������õĻ��ĸ�����
	 * ������������Ӵ� s[ i - j , ...,  i + j ] ��, i �ǻ������ģ����������������Σ���
	 * �Ӵ� s[ i - 1 - j , ...,  i + j ] �У�( i - 1 , i ) �ǻ������ģ�����ż���������Σ�
	 * @param s
	 * @return
	 */	
	public int countPalindromicSubstrings3(String s) { 
		int res = 0, n = s.length();  
	    for(int i = 0; i<n ;i++ ){  
	        for(int j = 0; i-j >= 0 && i+j < n && s.charAt(i-j) == s.charAt(i+j); j++){  
	            res++; //substring s[i-j, ..., i+j]  ����Ϊ����
	        }  
	        for(int j = 0; i-1-j >= 0 && i+j < n && s.charAt(i-1-j) == s.charAt(i+j); j++){  
	            res++; //substring s[i-1-j, ..., i+j] ����Ϊż��
	        }  
	    }  
	    return res;  
	}
}
