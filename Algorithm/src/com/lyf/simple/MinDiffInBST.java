package com.lyf.simple;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

/**
 *@function  https://www.lintcode.com/problem/minimum-distance-between-bst-nodes/description
 *@author Administrator
 *@date 2018年5月30日 上午9:34:54 
 *
 */
public class MinDiffInBST {

	@Test
	public void test() {

	}
	private ArrayList<Integer>  nodes; 
	public int minDiffInBST(TreeNode root) {
		   nodes = new ArrayList<Integer>();
		   getNodes(root);
		   int diff = Integer.MAX_VALUE;
	       for (int i = 1; i < nodes.size(); i++) {	    	   
	    	   if(diff > nodes.get(i)- nodes.get(i-1)){
	    		   diff  = nodes.get(i)- nodes.get(i-1);
	    	   }
	    	   if(1 == diff ) return 1;
	       }
	       return diff;
	}
	//遍历后升序排列
    private void getNodes(TreeNode root) {    	
    	if(null != root){
    		getNodes(root.left);
    		nodes.add(root.val);    		
    		getNodes(root.right);
    	}
    }
    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
     }
}
