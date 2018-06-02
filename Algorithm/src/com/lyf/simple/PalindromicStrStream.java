package com.lyf.simple;

import org.junit.Test;

/**
 *@function 计算回文数据流
 *	一个数据流进来，每次一个字母，当前数据流的排列【任意排列，只要能构成回文字符串则为1，否则为0】是否能组成回文串。
 *	Examples:
 *	给出 s = ['a','a','a','a','a'], 返回 [1,1,1,1,1]。
 *		解释：
			“a”的排列可以构成回文串
			“aa”的排列可以构成回文串
			“aaa”的排列可以构成回文串
			“aaaa”的排列可以构成回文串
			“aaaaa”的排列可以构成回文串
	给出 s = ['a','b','a']，返回 [1,0,1]。
		解释：
			“a”的排列可以构成回文串
			“ab”的排列不可以构成回文串
			“aba”的排列可以构成回文串
 *@author Administrator
 *@date 2018年4月8日 上午11:42:00 
 *
 */
public class PalindromicStrStream {

	@Test
	public void test() {
		String s = "carwwrac"; //1,1,1,1,1,1,1,0,1,0,1,
		int[] res = getStream2(s);
		for(int i :res){
			System.out.print(i+",");
		} 
//		int [] alphabet = new int[26];
//		alphabet['d' -'a'] = 1;
//		System.out.println(alphabet[2]);
	}
	
	/**
	 * 获取回文流,顺序排列的字符，是否能构成回文流【不是题意中的解】
	 * @param s
	 * @return
	 */
	public int[] getStream(String s){
		int len = s.length();
		int res[] = new int[len];		
		for (int i = 0; i < len; i++) {
			if(isPalindromStr(s.substring(0,i+1))){
				res[i] = 1;
			}
		}
		return res;
	}
	/**
	 * 判断当前是否为回文字符串
	 * @param s
	 * @return
	 */
	private boolean isPalindromStr(String s){
//		int len = s.length();
//		boolean flag = true;
//		for (int i = 0; i < len/2; i++) {
//			if(s.charAt(i) != s.charAt(len-i-1)){
//				flag = false;
//				break;
//			}
//		}
//		return flag;
		StringBuffer sb = new StringBuffer(s);
		System.out.println(sb);		 
		if(s.toString().equals(sb.reverse().toString())){			 
			return true;
		}else{
			return false;
		}
	}	
	
	/**
	 * ?????????进入一个字符流后，当前的字符串任意排序，是否可以构成回文串
	 * @param s
	 * @return
	 */
	public int[] getStream2(String s){
		int len = s.length();
		int [] ans = new int[len];
	    int [] alphabet = new int[26];
	    int cnt = 0;
	    for (int i = 0; i < len; i++) {
	        char c = s.charAt(i);
	        //?????????????? cnt 的作用
	        if (alphabet[c - 'a'] % 2 == 1) {
	            cnt--;  //奇数位置a,c,e,g...	            
	        } else {
	            cnt++;	//偶数位置b,d,f,h...            
	        }
	        alphabet[c - 'a']++;  //同一位置的字符个数累加
	        //赋值
	        if (cnt > 1) {
	            ans[i] = 0;
	        } else {
	            ans[i] = 1;
	        }
	    }
	    return ans;
	}
	
}
