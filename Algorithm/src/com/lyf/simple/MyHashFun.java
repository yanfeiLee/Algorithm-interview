package com.lyf.simple;

import org.junit.Test;

/**
 *@function 计算字符串的哈希值
 *hashcode("abcd") = (ascii(a) * 33^3 + ascii(b) * 33^2 + ascii(c) *33 + ascii(d)) % HASH_SIZE 

                              = (97* 33^3 + 98 * 33^2 + 99 * 33 +100) % HASH_SIZE

                              = 3595978 % HASH_SIZE

	其中HASH_SIZE表示哈希表的大小(可以假设一个哈希表就是一个索引0 ~ HASH_SIZE-1的数组)。
 *@author Administrator
 *@date 2018年3月10日 下午8:21:28 
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
	 * 根据字符数组，计算哈希值；注意:计算时超出最大long类型的长度时处理
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
