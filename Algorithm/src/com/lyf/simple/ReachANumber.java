package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 *@function ��վ��һ�����������ϵ� 0 λ�á���λ��Ŀ������һ��Ŀ�ꡣ��ÿһ�������У��������������ҡ��ڵ�n���ƶ���(��1��ʼ)��
 *			������n�������ص���Ŀ�ĵ��������С��������
 *		Note: Ŀ�꽫��һ�������������Χ[-10^9, 10^9]��
 *		Example:
 *				����Ŀ��= 3
				����2
				����:
				�ڵ�һ�������Ǵ�0��1��
				�ڵڶ��������Ǵ�1��3��
				
				����Ŀ��= 2
				����3
				����:
				�ڵ�һ�������Ǵ�0��1��
				�ڵڶ��������У����Ǵ�1��-1��
				�ڵ���������-1��2��
 *@author Administrator
 *@date 2018��4��20�� ����10:19:19 
 *
 */
public class ReachANumber {

	@Test
	public void test() {
			//System.out.println(3&1);  //0000 0011  & 0000 0001
			System.out.println("\r\nres="+reachNumber11(95));
	}
	/**
	 * �����н���������飬ֱ���н��Ϊtarget�򷵻ء��ȽϺķ��ڴ棬��ʱ�䡿
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
		  
		  //��ʼ����0������
		  ArrayList<Integer> start = new ArrayList<Integer>();
		  start.add(0);
		  dic.add(start);
		  //��������
		  for (int i = 1; i < Integer.MAX_VALUE; i++) { //�ӵ�һ�㿪ʼ,ͬʱi��ʾ����			  
			  ArrayList<Integer> parent = dic.get(i-1); //��������  ,int[���ݣ����ڵ�λ��]
			  ArrayList<Integer> child = new ArrayList<Integer>();  //�Ӳ�����
			  for (int j = 0; j < parent.size(); j++) {
				  int parentData = parent.get(j);				 
				  for (int k = 0; k < 2; k++) { //���������					   
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
	 * ���ز���·��  ���ȽϺķ��ڴ棬��ʱ�䡿
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
		  
		  //��ʼ����0������
		  ArrayList<int[]> start = new ArrayList<int[]>();
		  start.add(new int[]{0,0});
		  dic.add(start);
		  //��������
		  for (int i = 1; i < Integer.MAX_VALUE; i++) { //�ӵ�һ�㿪ʼ,ͬʱi��ʾ����			  
			  ArrayList<int[]> parent = dic.get(i-1); //��������  ,int[���ݣ����ڵ�λ��]
			  ArrayList<int[]> child = new ArrayList<int[]>();  //�Ӳ�����
			  for (int j = 0; j < parent.size(); j++) {
				  int[] parentData = parent.get(j);				 
				  for (int k = 0; k < 2; k++) { //���������
					  int[] left = new int[2];
					  int[] right = new int[2];
					  left[0] = parentData[0] - i;					  
					  right[0]  = parentData[0] + i;
					  left[1] = right[1] = j;
					  child.add(left);
					  child.add(right);
					  if(left[0] == target || right[0] == target){						   
						  //�������·��
						  int loc = left[1];						  					 
						  ArrayList<Integer> step = new ArrayList<Integer>();
						  step.add(target); //Ŀ��						  
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
	 * ��ѧ����  https://blog.csdn.net/u014688145/article/details/78948918
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
