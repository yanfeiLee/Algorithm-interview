package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @function ���������ĵ��ʲ�������������������ͬ����ĸ�����������
 * 	�����������ϵ���ĸ����ô����һ���鴤�ʡ����ڸ�һ�����ʣ���������������г鴤��ĸ����ʼ��ͽ����㡣
 *	 ������ַ�������Ϊn��n <= 100000��
 * @author Administrator
 * @date 2018��5��14�� ����10:37:14
 *
 */
public class WeirdWord {

	@Test
	public void test() {
		String str = "whooooisssbesssst";
		int[][] res = twitchWords2(str);
		for(int[] o: res){
			for(int i : o){
				System.out.print(i+",");
			}
			System.out.println();
		}
	}
	/**
	 *  ����arraylist ��[] 
	 * @param str
	 * @return
	 */
	public int[][] twitchWords(String str) {
		 int len  = str.length();
		 int[][] res = new int[len/3][2];
		 if(0 == len || 3>len) return res;
		 char tmp='0';		 
		 int cnt = -1;
		 for(int i=0; i<len-2; i++){
			 char first = str.charAt(i);
			 char second = str.charAt(i+1);
			 char third = str.charAt(i+2);
			 if(first == second && second == third){
				 int[] row = {0,0};		 				 
				 cnt++;
				 tmp = first;
				 row[0] = i;
				 row[1] = i+2;
				 int j=i+3;
				 for( ;j < len; j++){
					 if(tmp == str.charAt(j)){
						 row[1] = j;
					 }else{
						 break;
					 }
				 }
				 i = j-1;
				 res[cnt] = row;				 
			 }			 			 
		 }
		 //�ϲ����
		 int l =0;
		 for(int[] o: res){
			 for (int i = 0; i < o.length-1; i++) {
				if(0 == o[i] && 0 == o[i+1]){
					l++; 
				}
			}
		 }
		 return Arrays.copyOf(res, res.length-l);
	}
	/**
	 * ����arrayList
	 * @param str
	 * @return
	 */
	public int[][] twitchWords2(String str) {
		 int len  = str.length();
		 int[][] res = {{}};
		 if(0 == len || 3>len) return res;
		 char tmp='0';		 
		 ArrayList<int[]> ao = new ArrayList<int[]>();		  
		 for(int i=0; i<len-2; i++){
			 char first = str.charAt(i);
			 char second = str.charAt(i+1);
			 char third = str.charAt(i+2);
			 if(first == second && second == third){
				 int[] row = {0,0};		 				 				 
				 tmp = first;
				 row[0] = i;
				 row[1] = i+2;
				 int j=i+3;
				 for( ;j < len; j++){
					 if(tmp == str.charAt(j)){
						 row[1] = j;
					 }else{
						 break;
					 }
				 }
				 i = j-1;
				 ao.add(row);				 				  
			 }			 			 
		 }
		 int[][] ss = ao.toArray(new int[ao.size()][2]);
		 return ss;
	}
}
