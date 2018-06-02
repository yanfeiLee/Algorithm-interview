package com.lyf.simple;

import java.util.Arrays;

import org.junit.Test;

/**
 *@function ��ȡ쳲��������еĵ�n�����ĺ���λ0��1��1��2��3��5��8��13��21��34
 *	Given: n = 9
 *	Return: 34
 *@author Administrator
 *@date 2018��4��3�� ����4:20:42 
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
	 * ��ȡ����λ�������Ϊ0 �򷵻�0��������λ�򷵻�����λ
	 * ˼· :
	 * 	(A+B) Mod N = (A Mod N + B Mod N) Mod N������Fn������������F(n-1) Mod N + F(n-2) Mod N���
	 * @param n
	 * @return
	 */
	public String getLast4Num(int n){
		String res = "";
		double result = 0;
		int divsion = 10000; //��������n��ֵ�ú���λ
		//ǰ�����ж�
    	int flag = n;
		if(flag == 0 ){			 
		    return "0";    
		}else if (flag==1) {
			return "1";
		} 
    	//n>=2 ����
		double[][] base=new double[2][2];
        base[0][0]=1;
        base[0][1]=1;
        base[1][0]=1;
        base[1][1]=0;

        //�����matrix��(n-1)�η�;
        double[][] ret={{1,0},{0,1}};//��ʼ��Ϊ��λ����E


       
        int exp=flag-1;
        double[][] tmp;
        //����˼��
        while (exp>0){
        	//��������
            if((exp&1)>0){
                //ret*base
                tmp=new double[2][2];
                for(int i=0;i<2;i++){
                    for(int j=0;j<2;j++){
                        for(int k=0;k<2;k++){
                            tmp[i][j]+=(ret[i][k]*base[k][j]);//�������                            
                        }
                        tmp[i][j]%=divsion;
                    }
                }
                ret=Arrays.copyOf(tmp,tmp.length);//ret��ֵ
            }
            //ż������
            //base*base
            tmp=new double[2][2];
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    for(int k=0;k<2;k++){
                        tmp[i][j]+=base[i][k]*base[k][j];//ע�������code                         
                    }
                    tmp[i][j]%=divsion;
                }
            }
            base=Arrays.copyOf(tmp,tmp.length);//base��ֵ
            //exp����һλ,����2
            exp=exp>>1;
        }
        //���:ret��һ�к�����һ�о���[1,0]�������,�õ�һ������,��Ϊ����.���Կ��Լ�Ϊ��ret��һ�����ֽ�����Ӽ�Ϊ����
        result = ret[0][0];
        System.out.println(result);
         
		String s = String.valueOf(result);
		res = s.substring(0,s.length()-2);	
		
		return  res;
	}
}
