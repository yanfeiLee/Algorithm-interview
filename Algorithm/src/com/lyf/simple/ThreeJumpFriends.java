package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 *@function 判断两个人是否是三跳之内的朋友；给两个数组a,b,代表a[i]与b[i]是朋友，再给出两个数组c,d，表示询问c[i]和d[i]
 *是否为三跳之内的朋友。（比如A与B是朋友，B与C是朋友，那么B算A的一跳朋友，C算A的二跳朋友）
 *Example:
 *	给出 a = [1,2], b = [2,3], c = [1], d = [3], 返回 [1]。
 *	1 → 2 → 3 ，3是1的二跳朋友。
 *	给出 a = [1,2,3,4], b = [2,3,4,5], c = [1,1], d = [4,5], 返回[1,0]。
 *	1 → 2 → 3 → 4 → 5，4是1的三跳朋友，5是1的四跳朋友。
 *@author Administrator
 *@date 2018年4月2日 下午12:02:25 
 *
 */
public class ThreeJumpFriends {

	@Test
	public void test() {
		 int[] a = {1,2,3,4,8,22};
		 int[] b = {2,3,4,5,20,223};
		 int[] c = {1,1,42};
		 int[] d = {4,5,99};	
		 int[] res = withinThreeJumps3(a,b,c,d);
		 for(int i:res){
			 System.out.println(i+",");
		 }
	}
	/**
	 * 是3跳之内的朋友返回1，否则返回0
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return
	 */
	//有bug
	public int[] withinThreeJumps(int[] a, int[] b, int[] c, int[] d) {
        // Write your code here
		int[] res  = new int[c.length];		 
		ArrayList<ArrayList<Integer>> allChain = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < a.length; i++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			al.add(a[i]);
			al.add(b[i]);
			allChain.add(al);
		}
//		System.out.println("===="+allChain.size());
//		for(List in : allChain){
//			 System.out.println(in.get(0)+"=>"+in.get(1));
//		}
		
		//组合关系链条
		ArrayList<List<Integer>> chains = new ArrayList<List<Integer>>();		
		while(allChain.size() > 0){
			ArrayList<Integer> pairs = new ArrayList<Integer>();
			int start =  allChain.get(0).get(0);
			int end =  allChain.get(0).get(1);
			pairs.add(start);
			pairs.add(end);
			for (int i = 1; i < allChain.size(); i++) {
				if(end == allChain.get(i).get(0)){					
					end = allChain.get(i).get(1);
					pairs.add(end);
					allChain.remove(i);
					i=0;
				}				
			}
			allChain.remove(0);	 
			chains.add(pairs);
		}
//		System.out.println("长度="+chains.size());
//		for(List in : chains){
//			 for (int i = 0; i < in.size(); i++) {
//				 System.out.print(in.get(i)+"=>");
//				 
//			 }
//			 System.out.println("-------------");
//		}
		//根据关系链条判断是否在三跳之内
		for (int i = 0; i < c.length; i++) {
			if(c[i] == d[i]){
				res[i] = 1;
			}
			o:for (int j = 0; j < chains.size(); j++) {
				int len = chains.get(j).size();
				i:for (int j2 = 0; j2 < len; j2++) {					
					if(c[i] == chains.get(j).get(j2)){
						if(j2+1 < len && d[i] == chains.get(j).get(j2+1)){
							res[i] = 1;
							break o;
						}
						if(j2+2 < len && d[i] == chains.get(j).get(j2+2)){
							res[i] = 1;
							break o;
						}
						if(j2+3 < len && d[i] == chains.get(j).get(j2+3)){
							res[i] = 1;
							break o;
						}
					}
				}
			}
		}		
		return res;
    }
	
	//有bug
	public int[] withinThreeJumps2(int[] a, int[] b, int[] c, int[] d) {
		int[] res  = new int[c.length];	
		for (int i = 0; i < c.length; i++) {
			int target = d[i];
			if(c[i] == target){
				res[i] = 1;
			}
			
			o:for (int j = 0; j < a.length; j++) {
				if(c[i] == a[j]){
					if(target == b[j]){ // a->b
						res[i] = 1;
						break o;
					}else{
						 for (int j2 = 0; j2 < a.length; j2++) {
							if(b[j] == a[j2]){ 
								if(target == b[j2]){//a->b->c
									res[i] = 1;
									break o;
								}else{
									for (int k = 0; k < a.length; k++) {
										if(b[j2] == a[k] && target == b[k]){	//a->b->c->d										 
												res[i] = 1;
												break o;											 
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return res;
	}


	/**
	 * 构建二维数组，利用递归法判断
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return
	 */
    public int[] withinThreeJumps3(int[] a, int[] b, int[] c, int[] d) {
        // Write your code here
        int n = a.length;
        int m = c.length;
        int[] res = new int[m];
        ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 1001; i++) {
            ArrayList<Integer> ins = new ArrayList<Integer>();
            g.add(ins);
        }
        for (int i = 0; i < n; i++) {
            g.get(a[i]).add(b[i]);
            g.get(b[i]).add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            res[i] = dfs(c[i], d[i], 0, 3, g);
        }
        return res;
    }
    /**
     * 递归判断
     * @param cur
     * @param ed
     * @param dep
     * @param maxDep  表示最大跳数  
     * @param g
     * @return
     */
    private int dfs(int cur, int ed, int dep, int maxDep, ArrayList<ArrayList<Integer>> g) {
        if (cur == ed) {
            return 1;
        }
        if (dep == maxDep) {
            return 0;
        }
        for (int nxt : g.get(cur)) {
            if (dfs(nxt, ed, dep + 1, maxDep, g) == 1) {
                return 1;
            }
        }
        return 0;
    }
}
 