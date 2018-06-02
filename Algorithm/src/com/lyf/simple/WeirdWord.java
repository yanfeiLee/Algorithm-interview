package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @function 我们正常的单词不会有连续两个以上相同的字母，如果出现连
 * 	续三个或以上的字母，那么这是一个抽搐词。现在给一个单词，从左至右求出所有抽搐字母的起始点和结束点。
 *	 输入的字符串长度为n，n <= 100000。
 * @author Administrator
 * @date 2018年5月14日 上午10:37:14
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
	 *  操作arraylist 与[] 
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
		 //合并结果
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
	 * 操作arrayList
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
