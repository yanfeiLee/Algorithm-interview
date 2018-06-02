package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 *@function 你站在一个无穷数轴上的 0 位置。在位置目标上有一个目标。在每一个动作中，你可以向左或向右。在第n次移动中(从1开始)，
 *			你行走n步。返回到达目的地所需的最小步骤数。
 *		Note: 目标将是一个非零的整数范围[-10^9, 10^9]。
 *		Example:
 *				给出目标= 3
				返回2
				解释:
				在第一步，我们从0到1。
				在第二步，我们从1到3。
				
				给出目标= 2
				返回3
				解释:
				在第一步，我们从0到1。
				在第二个步骤中，我们从1到-1。
				在第三步，从-1到2。
 *@author Administrator
 *@date 2018年4月20日 上午10:19:19 
 *
 */
public class ReachANumber {

	@Test
	public void test() {
			//System.out.println(3&1);  //0000 0011  & 0000 0001
			System.out.println("\r\nres="+reachNumber11(95));
	}
	/**
	 * 将所有结果放入数组，直到有结果为target则返回【比较耗费内存，耗时间】
	 * [0]
	 * [-1,1]
	 * [-3,1,-1,3]
	 * ...
	 * @param target
	 * @return
	 */
	public int reachNumber(int target) {
	      //Write your code here
		  List<ArrayList<Integer>>  dic = new ArrayList<ArrayList<Integer>>();
		  
		  //初始化第0层数据
		  ArrayList<Integer> start = new ArrayList<Integer>();
		  start.add(0);
		  dic.add(start);
		  //后续数据
		  for (int i = 1; i < Integer.MAX_VALUE; i++) { //从第一层开始,同时i表示步数			  
			  ArrayList<Integer> parent = dic.get(i-1); //父层数据  ,int[数据，父节点位置]
			  ArrayList<Integer> child = new ArrayList<Integer>();  //子层数据
			  for (int j = 0; j < parent.size(); j++) {
				  int parentData = parent.get(j);				 
				  for (int k = 0; k < 2; k++) { //向左或向右					   
					  int left = parentData - i;					  
					  int right  = parentData + i;					  
					  child.add(left);
					  child.add(right);
					  if(left  == target || right  == target){						   
						  return i;
					  }
				  }
			  }		
			  dic.add(child);
		  }
		  return 1;
	}
	/**
	 * 返回步行路径  【比较耗费内存，耗时间】
	 * [[0,0]]
	 * [[-1,0][1,0]]
	 * [[-3,0][1,0][-1,1][3,1]]
	 * ....
	 * @param target
	 * @return
	 */
	public int reachNumber11(int target) {
	      //Write your code here
		  List<ArrayList<int[]>>  dic = new ArrayList<ArrayList<int[]>>();
		  
		  //初始化第0层数据
		  ArrayList<int[]> start = new ArrayList<int[]>();
		  start.add(new int[]{0,0});
		  dic.add(start);
		  //后续数据
		  for (int i = 1; i < Integer.MAX_VALUE; i++) { //从第一层开始,同时i表示步数			  
			  ArrayList<int[]> parent = dic.get(i-1); //父层数据  ,int[数据，父节点位置]
			  ArrayList<int[]> child = new ArrayList<int[]>();  //子层数据
			  for (int j = 0; j < parent.size(); j++) {
				  int[] parentData = parent.get(j);				 
				  for (int k = 0; k < 2; k++) { //向左或向右
					  int[] left = new int[2];
					  int[] right = new int[2];
					  left[0] = parentData[0] - i;					  
					  right[0]  = parentData[0] + i;
					  left[1] = right[1] = j;
					  child.add(left);
					  child.add(right);
					  if(left[0] == target || right[0] == target){						   
						  //输出搜索路径
						  int loc = left[1];						  					 
						  ArrayList<Integer> step = new ArrayList<Integer>();
						  step.add(target); //目标						  
						  for (int l = i-1; l > 0; l--) {
							  int[] p = dic.get(l).get(loc);
							  step.add(p[0]);							  
							  loc = p[1];
						  }						   
						  for (int l = step.size()-1; l >= 0; l--) {
							  System.out.print(step.get(l)+",");
						  }
						  return i;
					  }
				  }
			  }		
			  dic.add(child);
		  }
		  return 1;
	}
	/**
	 * 数学方法  https://blog.csdn.net/u014688145/article/details/78948918
	 * @param target
	 * @return
	 */
	public int reachNumber2(int target) {
	      //Write your code here
		target = Math.abs(target);
        int sum = 0;
        int n   = 0;
        while (sum < target){
            n ++;
            sum += n;
        }
        if (sum == target) return n;
        int res = sum - target;
        if ((res & 1) == 0) {
            return n;
        }else {
            return n + ((n & 1) == 0 ? 1 : 2);
        } 
	}
}
