package com.lyf.simple;

import org.junit.Test;

/**
 *@function  K���Ƽӷ�
 *����һ��k��a��b������a��b����һ��k���Ƶ��������a + b��k��������

	 ע������
	
	2 <= k <= 10
	a, b��Ϊ�ַ��������Ȳ�����1000��
	������ǰ����
 *@author Administrator
 *@date 2018��5��11�� ����6:45:31 
 *
 */
public class KSystemAddition {

	@Test
	public void test() {
		System.out.println(addition(3, "12", "1"));
	}
	public String addition(int k, String a, String b) {
        // Write your code here
        int aLen = a.length();
        int bLen = b.length();
        int maxLen = aLen < bLen ? bLen :aLen;
        int tmp = 0;
        int res = 0;         
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i<= maxLen; i++){
            Integer aPart = new Integer(0);
            Integer bPart = new Integer(0);
            if(aLen-i > -1){
                aPart = Integer.parseInt(a.charAt(aLen-i)+"");
            } 
            if(bLen-i > -1){
                bPart = Integer.parseInt(b.charAt(bLen-i)+"");
            } 
            System.out.println("="+aPart);
            System.out.println("="+bPart);
            int sum = tmp+aPart+bPart;
            System.out.println(sum);
            if(sum >= k){
                res = sum - k;
                tmp = 1;
            }else{
                tmp = 0;
                res = sum;
            }
            System.out.println(res);
            sb.append(res);
        }
        if(0!=tmp){
            sb.append(tmp);
        } 
        //ǰ���㴦��
        sb = sb.reverse();
        for(int i=0; i<sb.length();i++){
        	if('0' == sb.charAt(i)){
        		sb.deleteCharAt(i);
        		i--;
        		continue;
        	}
        	if('0' != sb.charAt(i)){
        		break;
        	}
        }
        return sb.toString();
    }
}
