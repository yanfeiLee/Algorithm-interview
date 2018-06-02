package com.lyf.simple;

import java.util.Arrays;

import org.junit.Test;

/**
 *@function 获取斐波那契数列的第n个数的后四位0，1，1，2，3，5，8，13，21，34
 *	Given: n = 9
 *	Return: 34
 *@author Administrator
 *@date 2018年4月3日 下午4:20:42 
 *
 */
public class GetFibonacci {

	@Test
	public void test() {
//		double result = 0;
//		String s = String.valueOf(result);
//		String res = s.substring(0,s.length()-2);	
//		System.out.println(res);
		System.out.println(getLast4Num(5));
	}
	/**
	 * 获取后四位，如果都为0 则返回0，少于四位则返回所有位
	 * 思路 :
	 * 	(A+B) Mod N = (A Mod N + B Mod N) Mod N，所以Fn的余数可以由F(n-1) Mod N + F(n-2) Mod N求出
	 * @param n
	 * @return
	 */
	public String getLast4Num(int n){
		String res = "";
		double result = 0;
		int divsion = 10000; //仅保留第n个值得后四位
		//前两项判断
    	int flag = n;
		if(flag == 0 ){			 
		    return "0";    
		}else if (flag==1) {
			return "1";
		} 
    	//n>=2 处理
		double[][] base=new double[2][2];
        base[0][0]=1;
        base[0][1]=1;
        base[1][0]=1;
        base[1][1]=0;

        //求矩阵matrix的(n-1)次方;
        double[][] ret={{1,0},{0,1}};//初始化为单位矩阵E


       
        int exp=flag-1;
        double[][] tmp;
        //分治思想
        while (exp>0){
        	//奇数次幂
            if((exp&1)>0){
                //ret*base
                tmp=new double[2][2];
                for(int i=0;i<2;i++){
                    for(int j=0;j<2;j++){
                        for(int k=0;k<2;k++){
                            tmp[i][j]+=(ret[i][k]*base[k][j]);//数组相乘                            
                        }
                        tmp[i][j]%=divsion;
                    }
                }
                ret=Arrays.copyOf(tmp,tmp.length);//ret改值
            }
            //偶数次幂
            //base*base
            tmp=new double[2][2];
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    for(int k=0;k<2;k++){
                        tmp[i][j]+=base[i][k]*base[k][j];//注意这里的code                         
                    }
                    tmp[i][j]%=divsion;
                }
            }
            base=Arrays.copyOf(tmp,tmp.length);//base改值
            //exp右移一位,除以2
            exp=exp>>1;
        }
        //最后:ret第一行和两行一列矩阵[1,0]进行相乘,得到一个整数,即为所求.所以可以简化为将ret第一行数字进行相加即为所求
        result = ret[0][0];
        System.out.println(result);
         
		String s = String.valueOf(result);
		res = s.substring(0,s.length()-2);	
		
		return  res;
	}
}
