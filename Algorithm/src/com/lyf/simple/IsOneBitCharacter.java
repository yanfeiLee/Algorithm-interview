package com.lyf.simple;

import org.junit.Test;

/**
 *@function We have two special characters. The first character 
 *		can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
		Now given a string represented by several bits. Return whether the last character must be 
		a one-bit character or not. The given string will always end with a zero.
		Exmples:
			Input: 
			bits = [1, 0, 0]
			Output: True
			Explanation: 
			The only way to decode it is two-bit character and one-bit character. So the last character 
			is one-bit character.
			----------------
			Input: 
			bits = [1, 1, 1, 0]
			Output: False
			Explanation: 
			The only way to decode it is two-bit character and two-bit character. 
			So the last character is NOT one-bit character.
			
 *@author Administrator
 *@date 2018年5月19日 上午9:34:39 
 *
 */
public class IsOneBitCharacter {

	@Test
	public void test() {
		int[] bits = {1, 0, 0,1,0,1,0,0};
		System.out.println(isOneBitCharacter(bits));
	}
	/**
	 * for
	 * @param bits
	 * @return
	 */
    public boolean isOneBitCharacter(int[] bits) {
    	boolean flag = false;    	
        int len = bits.length;       
        if(1 == len) return true;
        for (int i = 0; i < len; i++) {
			if(1 == bits[i]){
				flag = false;
				i++;
			}else if(0 == bits[i]){
				flag = true;
			}
		}
    	return flag;
    }
    /**
     * while
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter2(int[] bits) {
        int i = 0;
        while (i < bits.length-1){
            if (bits[i] == 1){
                i += 2;
            }else{
                i++;
            }
        }
        return i == bits.length-1;
    }
    /**
     * 倒着统计1得个数
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter3(int[] bits) {
    	int ones = 0;
    	for (int i = bits.length-2; i>=0 && bits[i] != 0 ; i--) {
			ones ++;
		}
    	if(ones % 2 > 0) return false;
    	return true;    	
    }
    
}
