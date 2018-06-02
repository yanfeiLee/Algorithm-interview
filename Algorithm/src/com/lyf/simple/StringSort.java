package com.lyf.simple;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.text.html.parser.Entity;

import org.junit.Test;

/**
 *@function  给出一个字符串，以最常用的字符为第一关键字，字典顺序为第二关键字排序字符串。
 *给出 str = “bloomberg” , 返回 “bbooeglmr”。['b'出现次数最多，且字典序最小，排名第一，其次是'o'。]
 *给出 str = “lintcode”, 返回 “cdeilnot”。[所有字符出现次数一样多，所以直接按照字典序排序。]
 *@author Administrator
 *@date 2018年3月14日 上午11:16:25 
 *
 */
public class StringSort {

	@Test
	public void test() {
//		char[] c = {'d','b','c'};
//		Arrays.sort(c);
//		for(char cc:c){
//			System.out.println(cc);
//		}
//		System.out.println("-----------------");
		 
		System.out.println(stringSort("bloomberg"));
		 
	}
	/**
	 * 按照上述规则对字符串排序
	 * @param str
	 * @return
	 */
	public String myStrSort(String str){
		String output = "";
		HashMap<Character, Integer> tmp = new HashMap<Character, Integer>();
		int count = 1;
		//存数据
		for (int i = 0; i < str.length(); i++) {
			if(tmp.containsKey(str.charAt(i))){
				tmp.put(str.charAt(i), tmp.get(str.charAt(i))+1);
			}else{
				tmp.put(str.charAt(i), count);
			}						
		}
		//去重
		Object[] cts =  (Object[])tmp.values().toArray();
		ArrayList<Integer>  sc = new ArrayList<Integer>();
		for (int i = 0; i  < cts.length; i++) {
			if(!sc.contains(cts[i])){
				sc.add((Integer)cts[i]);
			}
		}		
		Object[] counts = (Object[]) sc.toArray();
		//排序
		Arrays.sort(counts);
		Iterator<Character> ic = tmp.keySet().iterator();
		//System.out.println(cts.length);
		char[] keys = new char[cts.length];
		int k = 0;
		while(ic.hasNext()){			
			keys[k] = ic.next();
//			System.out.println(ic.next());
			k++;
		}
		Arrays.sort(keys);
 
		List<ArrayList<Character>> outter = new ArrayList<ArrayList<Character>>();
		 
		ArrayList<Character> alPart = new ArrayList<Character>();
		 
		//System.out.println(counts.length);
		for (int i = counts.length-1; i >= 0; i--) {
			 ArrayList<Character> inner = new ArrayList<Character>();
			 inner.add(String.valueOf(counts[i]).charAt(0));
		     for(char c: keys){
		    	 if(Integer.valueOf(tmp.get(c).toString()) == Integer.valueOf(counts[i].toString())){
		    		  alPart.add(c);
		    	 }
		     } 		    
		     Arrays.sort(alPart.toArray());
		     for (int j = 0; j < alPart.size(); j++) {		    	 
 		    	 inner.add(alPart.get(j));		    	 	    	
		     }	
		     alPart.clear();
		     outter.add(inner);
		}
		//遍历组装结果  outter 格式为:[[3,e,f,g][2,i,k,s],[1,p,j]]
		//System.out.println(outter.size());
		for(ArrayList<Character> in:outter){
			int loop = Integer.parseInt(String.valueOf(in.get(0)));
			for (int i = 1; i < in.size(); i++) {
				for (int j = 0; j < loop; j++) {
					output += in.get(i).toString();
				}
				 
				
			}			 
		}
		return output;
	}
	
	
	
	/**
	 * 利用Comparator 排序
	 */
    int[] count = new int[26];	
	public String stringSort(String str) {
        // Write your code here
        for (int i = 0; i < 26; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < str.length(); i++) {
            count[(int)str.charAt(i) - (int)('a')]++;
        }
        Pair[] pair = new Pair[str.length()];
        for (int i = 0; i < str.length(); i++) {
            pair[i] = new Pair();
            pair[i].cnt = count[(int)str.charAt(i) - (int)('a')];
            pair[i].order = (int)str.charAt(i);
        }
        Arrays.sort(pair, 0, pair.length, new Cmp());
        char[] chr = new char[pair.length];
        for (int i = 0; i < pair.length; i++) {
            chr[i] = (char)pair[i].order;
        }
        return String.valueOf(chr);
    } 
}


class Pair {
    int cnt, order;
}
class Cmp implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        if (a.cnt != b.cnt) {
            return a.cnt > b.cnt ? -1 : 1; //负数，倒序排，正数，正序排
        }
        if (a.order != b.order) {
            return a.order < b.order ? -1 : 1;
        }
        return 0;
    }
}
