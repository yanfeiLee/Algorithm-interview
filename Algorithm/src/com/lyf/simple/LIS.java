package com.lyf.simple;

import org.junit.Test;

/**
 *@function 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
 *		Note:
 *			最长上升子序列的定义：
 *				最长上升子序列问题是在一个无序的给定序列中找到一个尽可能长的由低到高排列的子序列，这种子序列不一定是连续的或者唯一的。
 *				https://en.wikipedia.org/wiki/Longest_increasing_subsequence
 *		Examples:
 *			给出 [5,4,1,2,3]，LIS 是 [1,2,3]，返回 3
 *			给出 [4,2,4,5,3,7]，LIS 是 [2,4,5,7]，返回 4
 *		Reference:https://blog.csdn.net/u013178472/article/details/54926531
 *@author Administrator
 *@date 2018年4月12日 上午9:57:49 
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
	 * 依此寻找以每个元素为序列最末端元素的序列，比较序列的长度。O(n*n)  动态规划【后续选选择依赖前边结果】
	 * @param nums
	 * @return
	 */
	public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
		int cnt = 1;
		int len = nums.length;
		if(0 == len) return 0;		
		int[] len_arr = new int[len]; //记录每个值作为序列最大值时，序列的长度
		int[] pre  = new int[len];  //记录当前值作为序列最大值时，序列前一个数的位置
		for (int i = 0; i < len; i++) {
			len_arr[i] = 1; //初始化最长序列为1
			pre[i] = i;  //记录索引
		}
		int k = 0; //记录数组中最长序列的最大值的索引
		for (int i = 1; i < len; i++) {
			//寻找以nums[i] 为最末元素的最长递增序列
			for (int j = 0; j < i; j++) {
				//寻找在i位置前，值小于nums[i]的数，并且以j结尾的序列加1后，大于当前序列长度len_arr[i]
				if(nums[j] < nums[i] && len_arr[j]+1 > len_arr[i]){
					len_arr[i] += 1;
					pre[i] = j; //以i位置的元素为最末端元素的序列，前一个数的位置为j
					if(cnt < len_arr[i]){
						cnt = len_arr[i];
						k = i; //记录最长序列的最后 一个元素的位置，方便后续遍历取出最长序列
					}
				}
			}
		}
		//输出最长序列
		int[] res = new int[cnt];
		int i = cnt - 1;
		while(k != pre[k]){
			res[i--] = nums[k];
			k = pre[k];
		}
		//加入序列第一个元素,即以此元素为最末端元素的序列长度为1，pre[k] = k;
		res[i] = nums[k];
		for(int m:res){
			System.out.print(m+",");
		}
		System.out.println();
		return cnt;
    }
	/**
	 * 仅计算最大长度递增序列长度O(n*n)
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
        
        //minLast[i] 表示长度为i的序列，末端元素最小的那个值
        for (int i = 1; i <= nums.length; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // find the first number in minLast >= nums[i] 返回索引
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
