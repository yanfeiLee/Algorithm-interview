package com.lyf.base;

import java.util.ArrayList;

import javax.xml.transform.Templates;

import org.junit.Test;


/**
 * 将一个整数(n)转换为k进制(base-k);
 * 0<= n <=2^31-1
 * 2<= k <=16
 * 结果大于9的值，表示为A，B，C，D，E
 * @author Administrator
 *
 */
public class HexConversion {

	@Test
	public void test(){
		System.out.println(Math.log(0));
		System.out.println(Math.ceil(Math.log(23)/Math.log(4)));
		System.out.println(hexConver(214128984, 11));
		
		
		System.out.println((char)('A'+3));
		System.out.println("----------");
		System.out.println(getDecimalNum("100001", 8));
	}
	
	/**
	 * 任意整数n到k进制
	 * @param n  0~2631-1
	 * @param k  2~16
	 * @return
	 */
	public String hexConver(int n, int k) {
        // write your code here
		String res = "";
		if(k>=2 && k <= 16 && n>=0 && n<= Math.pow(2, 31)-1){		 
			ArrayList<String> tmp = new ArrayList<String>();			 
			int remainder = 0;
			//取余数
			while(n/k >= 0 ){				
				remainder = n%k;
				if(remainder<10){
					tmp.add(remainder+"");
				}else if(10 == remainder){
					tmp.add("A");
				}else if(11 == remainder){
					tmp.add("B");
				}else if(12 == remainder){
					tmp.add("C");
				}else if(13 == remainder){
					tmp.add("D");
				}else if(14 == remainder){
					tmp.add("E");
				}else{
					tmp.add("F");
				} 			 
				n = n/k;
				if(n==0) break;
			}			 	
			//逆序拼接余数
			for (int j = tmp.size()-1; j >=0; j--) {
				res += tmp.get(j);
			}
		}else{
			res = null;
		}		
		return res;
	}
	public String hexConver2(int n, int k) {		
		String res = "";
        if (n == 0) {
            return "0";
        }        
        while (n > 0) {
            int t = n % k;
            char c = ' ';
            if (t <= 9) {
                c = (char)('0' + t);
            }else {
                c = (char)('A' + (t - 10));
            }            
            res = c + res;
            n /= k;
        }        
        return res;
	}
	/**
	 * 将k进制的数s转为十进制
	 * @param sx
	 * @param k
	 * @return
	 */
	public int  getDecimalNum(String s, int k){
		return Integer.parseInt(s, k);
	}
}
