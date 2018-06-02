package com.lyf.simple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

/**
 *@function ���������������Լ��
 *@author Administrator
 *@date 2018��3��22�� ����11:39:47 
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
	 * ŷ������㷨��շת�������
	 * ��շת������󼸸��������Լ��������������������������������Լ����
	 * ����������Լ����������������Լ������������ȥ��ֱ�����һ����Ϊֹ��
	 * ������õ��Ǹ����Լ��������������Щ�������Լ��
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
	 * �������ֽⷨ
	 * @param a
	 * @param b
	 * @return
	 */
	/*�������ֽⷨ����ÿ�����ֱ�ֽ����������ٰѸ����е�ȫ��������������ȡ�������ˣ����õĻ������⼸���������Լ����
	���磺��24��60�����Լ�����ȷֽ�����������24=2��2��2��3��60=2��2��3��5��24��60��ȫ�����е���������2��2��3��
	���ǵĻ���2��2��3=12�����ԣ���24��60��=12��
	�Ѽ������ȷֱ�ֽ����������ٰѸ����е�ȫ�����е��������Ͷ��е���������ȡ�������ˣ����õĻ������⼸��������С��������
	���磺��6��15����С���������ȷֽ�����������6=2��3��15=3��5��6��15��ȫ�����е���������3��6������������2��15���е���������5��
	2��3��5=30��30�������6��ȫ��������2��3����������15��ȫ��������3��5����30��6��15�Ĺ���������С��һ��������[6��15]=30��*/
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
