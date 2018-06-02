package com.lyf.simple;

import org.junit.Test;

/**
 *@function �������������
 *	һ��������������ÿ��һ����ĸ����ǰ�����������С��������У�ֻҪ�ܹ��ɻ����ַ�����Ϊ1������Ϊ0���Ƿ�����ɻ��Ĵ���
 *	Examples:
 *	���� s = ['a','a','a','a','a'], ���� [1,1,1,1,1]��
 *		���ͣ�
			��a�������п��Թ��ɻ��Ĵ�
			��aa�������п��Թ��ɻ��Ĵ�
			��aaa�������п��Թ��ɻ��Ĵ�
			��aaaa�������п��Թ��ɻ��Ĵ�
			��aaaaa�������п��Թ��ɻ��Ĵ�
	���� s = ['a','b','a']������ [1,0,1]��
		���ͣ�
			��a�������п��Թ��ɻ��Ĵ�
			��ab�������в����Թ��ɻ��Ĵ�
			��aba�������п��Թ��ɻ��Ĵ�
 *@author Administrator
 *@date 2018��4��8�� ����11:42:00 
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
	 * ��ȡ������,˳�����е��ַ����Ƿ��ܹ��ɻ����������������еĽ⡿
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
	 * �жϵ�ǰ�Ƿ�Ϊ�����ַ���
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
	 * ?????????����һ���ַ����󣬵�ǰ���ַ������������Ƿ���Թ��ɻ��Ĵ�
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
	        //?????????????? cnt ������
	        if (alphabet[c - 'a'] % 2 == 1) {
	            cnt--;  //����λ��a,c,e,g...	            
	        } else {
	            cnt++;	//ż��λ��b,d,f,h...            
	        }
	        alphabet[c - 'a']++;  //ͬһλ�õ��ַ������ۼ�
	        //��ֵ
	        if (cnt > 1) {
	            ans[i] = 0;
	        } else {
	            ans[i] = 1;
	        }
	    }
	    return ans;
	}
	
}
