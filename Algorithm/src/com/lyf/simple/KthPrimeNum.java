package com.lyf.simple;

import java.util.ArrayList;

import org.junit.Test;

/**
 * �����K�������������������������е�λ��		
 * ����������1������;ֻ��1��������Ϊ������
 * ��������n�������2��  ֮�����������ȥ�������޷���������nΪ����
 * @author Administrator
 *
 */
public class KthPrimeNum {
	@Test
	public void test(){
		System.out.println(getPrimeList(220));
	}
	
	
	/**
	 * ���С��num�����������б�		
	 * @param num
	 * @return
	 */
	public ArrayList getPrimeList(int num){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int i = 1;		 
		int flag = 0;
		do{
			i++;
			for(int j = 1; j <= Math.sqrt(i);j++){
				if(0 == i%j){
					flag ++;
				}
			}
			if(flag == 1 ){				
				arr.add(i);				
			}
			flag = 0;
		}while(i < num);		
		return arr;
	}
	/**
	 * ��ȡnum�������������е�����
	 * @param num
	 * @return
	 */
	public int kthPrime(int n) {
		if (n >= 100000)
			return 0;
		int i = 1;
		int k = 0;
		int flag = 0;
		do {
			i++;
			for (int j = 1; j <= Math.sqrt(i); j++) {
				if (0 == i % j) {
					flag++;
				}
			}
			if (flag == 1) {
				k++;
			}
			flag = 0;
		} while (i < n);
		return k;
	}
	 
	
	/**
	 * ��ȡnum�������������е�����
	 * @param num
	 * @return
	 */
	public int kthPrime2(int n){
		boolean[] ba = new boolean[n+1];
		//��ʼ���ж���Ϊtrue
        for (int i = 2; i <= n; i++){
            ba[i] = true;
        }
        //�ų�������????
        for (int i = 2, end = (int)Math.sqrt(n); i <= end; i++){
            if (ba[i]){
                for (int j = i * i; j <= n; j+=i){
                    ba[j] = false;
                }
            }
        }
        //����
        int ans = 0;
        for (int i = 2; i <= n; i++){
            if (ba[i]){
                ans++;
            }
        }
        return ans;
	}
}
