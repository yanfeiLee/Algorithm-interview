package com.lyf.simple;

import java.util.ArrayList;

import org.junit.Test;

/**
 *@function https://www.lintcode.com/problem/minimum-absolute-difference-in-bst/description
 *@author Administrator
 *@date 2018年6月2日 上午9:54:29 
 *
 */
public class GetMinimumDifference {
	private ArrayList<Integer> all = new ArrayList<Integer>();
	@Test
	public void test() {

	}

    public int getMinimumDifference(TreeNode root) {
        traverseBST(root);
        int min = Integer.MAX_VALUE;
        for (int i = all.size()-1; i > 0 ; i--) {
        	int diff = all.get(i)-all.get(i-1);
			if(min > diff){
				min = diff;
			}
			if(0 == diff){
				return 0;
			}
		}
    	return min;
    }
    
    private void traverseBST(TreeNode root){
    	if(null  != root){
    		traverseBST(root.left);
    		all.add(root.val);
    		traverseBST(root.right);    		
    	}
    }   
}
