package com.lyf.simple;

import org.junit.Test;

/**
 *@function ����һ���������У��ҵ�����������У�LIS��������LIS�ĳ��ȡ�
 *		Note:
 *			����������еĶ��壺
 *				�������������������һ������ĸ����������ҵ�һ�������ܳ����ɵ͵������е������У����������в�һ���������Ļ���Ψһ�ġ�
 *				https://en.wikipedia.org/wiki/Longest_increasing_subsequence
 *		Examples:
 *			���� [5,4,1,2,3]��LIS �� [1,2,3]������ 3
 *			���� [4,2,4,5,3,7]��LIS �� [2,4,5,7]������ 4
 *		Reference:https://blog.csdn.net/u013178472/article/details/54926531
 *@author Administrator
 *@date 2018��4��12�� ����9:57:49 
 *
 */
public class LIS {

	@Test
	public void test() {
//		int i=9;
//		System.out.println((i--)*3);
//		System.out.println(i);
//		int[] nums = {4,2,4,5,3,7};
		int[] nums = {5,4,1,2,3};
		System.out.println("res="+longestIncreasingSubsequence3(nums));
	}
	/**
	 * ����Ѱ����ÿ��Ԫ��Ϊ������ĩ��Ԫ�ص����У��Ƚ����еĳ��ȡ�O(n*n)  ��̬�滮������ѡѡ������ǰ�߽����
	 * @param nums
	 * @return
	 */
	public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
		int cnt = 1;
		int len = nums.length;
		if(0 == len) return 0;		
		int[] len_arr = new int[len]; //��¼ÿ��ֵ��Ϊ�������ֵʱ�����еĳ���
		int[] pre  = new int[len];  //��¼��ǰֵ��Ϊ�������ֵʱ������ǰһ������λ��
		for (int i = 0; i < len; i++) {
			len_arr[i] = 1; //��ʼ�������Ϊ1
			pre[i] = i;  //��¼����
		}
		int k = 0; //��¼����������е����ֵ������
		for (int i = 1; i < len; i++) {
			//Ѱ����nums[i] Ϊ��ĩԪ�ص����������
			for (int j = 0; j < i; j++) {
				//Ѱ����iλ��ǰ��ֵС��nums[i]������������j��β�����м�1�󣬴��ڵ�ǰ���г���len_arr[i]
				if(nums[j] < nums[i] && len_arr[j]+1 > len_arr[i]){
					len_arr[i] += 1;
					pre[i] = j; //��iλ�õ�Ԫ��Ϊ��ĩ��Ԫ�ص����У�ǰһ������λ��Ϊj
					if(cnt < len_arr[i]){
						cnt = len_arr[i];
						k = i; //��¼����е���� һ��Ԫ�ص�λ�ã������������ȡ�������
					}
				}
			}
		}
		//��������
		int[] res = new int[cnt];
		int i = cnt - 1;
		while(k != pre[k]){
			res[i--] = nums[k];
			k = pre[k];
		}
		//�������е�һ��Ԫ��,���Դ�Ԫ��Ϊ��ĩ��Ԫ�ص����г���Ϊ1��pre[k] = k;
		res[i] = nums[k];
		for(int m:res){
			System.out.print(m+",");
		}
		System.out.println();
		return cnt;
    }
	/**
	 * ��������󳤶ȵ������г���O(n*n)
	 * @param nums
	 * @return
	 */
	public int longestIncreasingSubsequence2(int[] nums){
		int []f = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
                }
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
	}
	/**
	 * https://blog.csdn.net/u013178472/article/details/54926531
	 * @param nums
	 * @return
	 */
	public int longestIncreasingSubsequence3(int[] nums){
		int[] minLast = new int[nums.length + 1];
        minLast[0] = Integer.MIN_VALUE;
        
        //minLast[i] ��ʾ����Ϊi�����У�ĩ��Ԫ����С���Ǹ�ֵ
        for (int i = 1; i <= nums.length; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // find the first number in minLast >= nums[i] ��������
            int index = binarySearch(minLast, nums[i]);
            minLast[index] = nums[i];
        }
        
        for (int i = nums.length; i >= 1; i--) {
            if (minLast[i] != Integer.MAX_VALUE) {
                return i;
            }
        }
        
        return 0;
	}
	//1, 3, 4  9  10  => 5 
  	private int binarySearch(int[] minLast, int num) {
	        int start = 0, end = minLast.length - 1;
	        while (start + 1 < end) {
	            int mid = (end - start) / 2 + start;
	            if (minLast[mid] < num) {
	                start = mid;
	            } else {
	                end = mid;
	            }
	        }
	        
	        return end;
	}
}
