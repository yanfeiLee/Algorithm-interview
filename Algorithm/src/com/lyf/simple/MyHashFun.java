package com.lyf.simple;

import org.junit.Test;

/**
 *@function �����ַ����Ĺ�ϣֵ
 *hashcode("abcd") = (ascii(a) * 33^3 + ascii(b) * 33^2 + ascii(c) *33 + ascii(d)) % HASH_SIZE 

                              = (97* 33^3 + 98 * 33^2 + 99 * 33 +100) % HASH_SIZE

                              = 3595978 % HASH_SIZE

	����HASH_SIZE��ʾ��ϣ��Ĵ�С(���Լ���һ����ϣ�����һ������0 ~ HASH_SIZE-1������)��
 *@author Administrator
 *@date 2018��3��10�� ����8:21:28 
 *
 */
/**
 * @author Administrator
 *
 */
public class MyHashFun {

	@Test
	public void test() {

	}
	/**
	 * �����ַ����飬�����ϣֵ��ע��:����ʱ�������long���͵ĳ���ʱ����
	 * @param key
	 * @param HASH_SIZE
	 * @return
	 */
	public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
//        int len = key.length;
//        long sum = 0;
//        for(int i=0; i < len; i++){
//            sum += ((byte)key[i])*Math.pow(33,len-1-i);
//        }
//        return (int)sum%HASH_SIZE; 
                
        long ans = 0;
        for(int i = 0; i < key.length;i++) {
            ans = (ans * 33 + (int)(key[i])) % HASH_SIZE; 
        }
        return (int)ans;
    }
}
