package com.lyf.simple;

import org.junit.Test;

/**
 *@function  https://www.lintcode.com/problem/min-cost-climbing-stairs/description
 *@author Administrator
 *@date 2018年5月30日 上午10:50:27 
 *
 */
public class MinCostClimbingStairsc {

	@Test
	public void test() {
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(minCostClimbingStairs(cost));
	}
	//有bug----需要在每步中判断最小cost
    public int minCostClimbingStairs(int[] cost) {
    	int len = cost.length;
    	int tmp0 = cost[0];
    	int tmp1 = cost[1];
    	for (int i = 0; i < len-2; i++) {
    		if(cost[i+1] > cost[i+2]){
    			tmp0 += cost[i+2];
    			i += 1;
    		}else{
    			tmp0  += cost[i+1];    			
    		}			
		}
    	for (int i = 1; i < len-2; i++) {
    		if(cost[i+1] > cost[i+2]){
    			tmp1 += cost[i+2];
    			i += 1;
    		}else{
    			tmp1  += cost[i+1];    			
    		}	
		}    	
        return tmp0 < tmp1 ? tmp0 : tmp1;
    }
    //动态规划
    public int minCostClimbingStairs2(int[] cost) {
    	int length = cost.length + 1;
        int dp0 = 0;
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 2; i < length; i++) {
            dp2 = Math.min(dp0 + cost[i - 2] , dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp2;
    }
}
