package com.lyf.base;

import java.awt.List;
import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/9/25.
 * 对于斐波纳契经典问题，我们都非常熟悉，通过递推公式F(n) = F(n - 1) + F(n - 2)，(n>2)
 * 我们可以在线性时间内求出第n项F(n)，现在考虑斐波拉契的  * 加强版,我们要求的项数n的范围为int范围内的非负整数，请设计一个高效算法，
 * 计算第n项F(n)。 
 * 前十项:0,1,1,2,3,5,8,13,21,34...
 * 算法关键:矩阵快速幂.
 */

public class getFibonacciVal {

	//test code
    public static void main(String[] args) {
       getFibonacciVal t=new getFibonacciVal();
       System.out.println(t.getNthNumber(5));
       System.out.println(t.getNumberByWindow(5));
       
       //System.out.println("hello");
     /*  int exp = 5;
       System.out.println(exp&1);//奇数偶数判断
       System.out.println(exp>>1);//除2
       System.out.println(exp/2);//除2
	 */
    }
    
    /**
     * 矩阵相乘法
     * @param n
     * @return
     */
    public int getNthNumber(int n) {
    	//前两项判断
    	int flag = n-1;
		if(flag==0 ){
		    return 0;
		}else if (flag==1) {
			return 1;
		} 
    	//n>=2 处理
        long[][] base=new long[2][2];
        base[0][0]=1;
        base[0][1]=1;
        base[1][0]=1;
        base[1][1]=0;

        //求矩阵matrix的(n-1)次方;
        long[][] ret={{1,0},{0,1}};//初始化为单位矩阵E


       
        int exp=flag-1;
        long[][] tmp;

        while (exp>0){
        	//奇数次幂
            if((exp&1)>0){
                //ret*base
                tmp=new long[2][2];
                for(int i=0;i<2;i++){
                    for(int j=0;j<2;j++){
                        for(int k=0;k<2;k++){
                            tmp[i][j]+=ret[i][k]*base[k][j];//数组相乘                            
                        }
                    }
                }
                ret=Arrays.copyOf(tmp,tmp.length);//ret改值
            }
            //偶数次幂
            //base*base
            tmp=new long[2][2];
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    for(int k=0;k<2;k++){
                        tmp[i][j]+=base[i][k]*base[k][j];//注意这里的code                         
                    }
                }
            }
            base=Arrays.copyOf(tmp,tmp.length);//ret改值
            //exp右移一位
            exp=exp>>1;
        }
        //最后:ret第一行和两行一列矩阵[1,0]进行相乘,得到一个整数,即为所求.所以可以简化为将ret第一行数字进行相加即为所求
        return (int)(ret[0][0]);
    }
    
    /**
     * 类似滑动窗口的方法
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

