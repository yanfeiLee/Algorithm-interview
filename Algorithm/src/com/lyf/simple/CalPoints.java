package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 *@function  https://www.lintcode.com/problem/baseball-game/description
 *@author Administrator
 *@date 2018年5月21日 上午11:31:25 
 *
 */
public class CalPoints {

	@Test
	public void test() {
		String[] ops = {"5","-2","4","C","D","9","+","+"};
		System.out.println(calPoints(ops));
	}
    public int calPoints(String[] ops) {
        int res = 0;
        List<String> al = Arrays.asList(ops);
        List<Integer>  round = new ArrayList<Integer>();
        int roundSize = 0;
        for (int i = 0; i < al.size();  i++) {
        	roundSize = round.size();
			if(al.get(i).equals("C")){
				round.remove(roundSize-1);
			}else if(al.get(i).equals("D")){
				round.add(round.get(roundSize-1)*2);				
			}else if(al.get(i).equals("+")){
				round.add(round.get(roundSize-1)+round.get(roundSize-2));
			}else{
				round.add(Integer.valueOf(al.get(i)));
			}
		}
        for(Integer i: round){
        	res += i;
        }
        return res;
    }
}
