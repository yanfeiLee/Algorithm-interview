package com.lyf.simple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

/**
 *@function 求两个整数的最大公约数
 *@author Administrator
 *@date 2018年3月22日 上午11:39:47 
 *
 */
public class GreatestCommonDivisor {

	@Test
	public void test() {
//		System.out.println(getGCD2(30, 15));
		System.out.println(getGCD2(652264, 789016));
		//System.out.println(getGCD(652264, 789016));
	}
	
	
	/**
	 * 欧几里德算法【辗转相除法】
	 * 用辗转相除法求几个数的最大公约数，可以先求出其中任意两个数的最大公约数，
	 * 再求这个最大公约数与第三个数的最大公约数，依次求下去，直到最后一个数为止。
	 * 最后所得的那个最大公约数，就是所有这些数的最大公约数
	 * @param a
	 * @param b
	 * @return
	 */
	public int getGCD(int a,int b){
		int div = a%b;
		while(0 != div){
			a = b;
			b = div;
			div = a%b;
		}
		return b;
	}
	/**
	 * 质因数分解法
	 * @param a
	 * @param b
	 * @return
	 */
	/*质因数分解法：把每个数分别分解质因数，再把各数中的全部公有质因数提取出来连乘，所得的积就是这几个数的最大公约数。
	例如：求24和60的最大公约数，先分解质因数，得24=2×2×2×3，60=2×2×3×5，24与60的全部公有的质因数是2、2、3，
	它们的积是2×2×3=12，所以，（24，60）=12。
	把几个数先分别分解质因数，再把各数中的全部公有的质因数和独有的质因数提取出来连乘，所得的积就是这几个数的最小公倍数。
	例如：求6和15的最小公倍数。先分解质因数，得6=2×3，15=3×5，6和15的全部公有的质因数是3，6独有质因数是2，15独有的质因数是5，
	2×3×5=30，30里面包含6的全部质因数2和3，还包含了15的全部质因数3和5，且30是6和15的公倍数中最小的一个，所以[6，15]=30。*/
	public int getGCD2(int a,int b){
		int res = 1;
		HashMap<Integer, Integer> aMap = getPrimeMap(a);
		HashMap<Integer, Integer> bMap = getPrimeMap(b);
		
		Iterator<Map.Entry<Integer, Integer>> it = aMap.entrySet().iterator();
		while(it.hasNext()){
		    Entry<Integer, Integer> me = (Map.Entry<Integer, Integer>) it.next();
			if(bMap.containsKey(me.getKey())){
				if(me.getValue() <= bMap.get(me.getKey())){
					res *= Math.pow(me.getKey(),me.getValue());
				}else{
					res *= Math.pow(me.getKey(),bMap.get(me.getKey()));
				}
			}
			//System.out.println(me.getKey() +"=>"+me.getValue());
		}
		return res;
	}	
	private HashMap<Integer, Integer> getPrimeMap(int a){
		HashMap<Integer,Integer> res = new HashMap<Integer, Integer>();
		for(int i=2; i <= a; i++){
			if(0 == a%i){
				a /= i;
				if(res.containsKey(i)){
					res.put(i, res.get(i)+1);
				}else{
					res.put(i, 1);
				}
				i--;
			}
		}		
		return res;
	}
}
