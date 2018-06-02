package com.lyf.base;

import java.awt.List;
import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/9/25.
 * ����쳲������������⣬���Ƕ��ǳ���Ϥ��ͨ�����ƹ�ʽF(n) = F(n - 1) + F(n - 2)��(n>2)
 * ���ǿ���������ʱ���������n��F(n)�����ڿ���쳲�������  * ��ǿ��,����Ҫ�������n�ķ�ΧΪint��Χ�ڵķǸ������������һ����Ч�㷨��
 * �����n��F(n)�� 
 * ǰʮ��:0,1,1,2,3,5,8,13,21,34...
 * �㷨�ؼ�:���������.
 */

public class getFibonacciVal {

	//test code
    public static void main(String[] args) {
       getFibonacciVal t=new getFibonacciVal();
       System.out.println(t.getNthNumber(5));
       System.out.println(t.getNumberByWindow(5));
       
       //System.out.println("hello");
     /*  int exp = 5;
       System.out.println(exp&1);//����ż���ж�
       System.out.println(exp>>1);//��2
       System.out.println(exp/2);//��2
	 */
    }
    
    /**
     * ������˷�
     * @param n
     * @return
     */
    public int getNthNumber(int n) {
    	//ǰ�����ж�
    	int flag = n-1;
		if(flag==0 ){
		    return 0;
		}else if (flag==1) {
			return 1;
		} 
    	//n>=2 ����
        long[][] base=new long[2][2];
        base[0][0]=1;
        base[0][1]=1;
        base[1][0]=1;
        base[1][1]=0;

        //�����matrix��(n-1)�η�;
        long[][] ret={{1,0},{0,1}};//��ʼ��Ϊ��λ����E


       
        int exp=flag-1;
        long[][] tmp;

        while (exp>0){
        	//��������
            if((exp&1)>0){
                //ret*base
                tmp=new long[2][2];
                for(int i=0;i<2;i++){
                    for(int j=0;j<2;j++){
                        for(int k=0;k<2;k++){
                            tmp[i][j]+=ret[i][k]*base[k][j];//�������                            
                        }
                    }
                }
                ret=Arrays.copyOf(tmp,tmp.length);//ret��ֵ
            }
            //ż������
            //base*base
            tmp=new long[2][2];
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    for(int k=0;k<2;k++){
                        tmp[i][j]+=base[i][k]*base[k][j];//ע�������code                         
                    }
                }
            }
            base=Arrays.copyOf(tmp,tmp.length);//ret��ֵ
            //exp����һλ
            exp=exp>>1;
        }
        //���:ret��һ�к�����һ�о���[1,0]�������,�õ�һ������,��Ϊ����.���Կ��Լ�Ϊ��ret��һ�����ֽ�����Ӽ�Ϊ����
        return (int)(ret[0][0]);
    }
    
    /**
     * ���ƻ������ڵķ���
     * @param n
     * @return
     */
    public int getNumberByWindow(int n){
    	int a = 0;
    	int b = 1;
    	for (int i = 0; i < n - 1; i++) {
	    	int c = a + b;
	    	a = b;
	    	b = c;
    	}
    	return a;
    }    
}

