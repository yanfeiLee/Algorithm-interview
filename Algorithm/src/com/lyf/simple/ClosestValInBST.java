package com.lyf.simple;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

/**
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target. Given root = {1}, target = 4.428571,
 * return 1.
 * 
 * @function
 * @author Administrator
 * @date 2018年3月16日 上午9:27:36
 *
 */
public final class ClosestValInBST {

	@Test
	public void test() {
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		root.left = left;
		int res = getClosestValue2(root, 2147483647.0);
		System.out.println(res);
	}

	/**
	 * 直接比较
	 * 
	 * @param root
	 * @param target
	 * @return
	 */
	public int getClosestValue(TreeNode root, double target) {
		// write your code here
		int res = 0;		 
		double min = Math.abs(root.val - target);
		while (null != root) {
			if (min >= Math.abs(root.val - target)) {
				min = Math.abs(root.val - target);
				res = root.val;
			}
			root = root.val > target ? root.left : root.right;
		}
		return res;
	}

	/**
	 * 遍历时比较
	 * 
	 * @param root
	 * @param target
	 * @return
	 */
	public int getClosestValue2(TreeNode root, double target) {
		// write your code here
		if (null == root)
			return 0;
		int res = 0;
		double min = Double.MAX_VALUE;
		TreeNode tmpNode = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (tmpNode != null || !s.isEmpty()) {
			while (null != tmpNode) {
				s.push(tmpNode);
				tmpNode = tmpNode.left;
			}
			if (!s.isEmpty()) {
				tmpNode = s.pop();
				if (min >= Double.valueOf(Math.abs(target - tmpNode.val))) {
					min = Double.valueOf(Math.abs(target - tmpNode.val));
					res = tmpNode.val;
				}
				tmpNode = tmpNode.right;
			}
		}
		return res;
	}

	/**
	 * 递归+ 分治
	 * @param root
	 * @param target
	 * @return
	 */
	public int getClosestValue3(TreeNode root, double target){
		double  min = Double.MAX_VALUE;
		int[] res = {0}; //为了方便使得普通数据类型按照地址传递，做成数组
		doCmp(root,target,min,res);
		return res[0];		
	}
	private void doCmp(TreeNode root,double target,double min,int[] res){
		if(null == root) return;		 
		if(min >= Math.abs(root.val-target)){
			min = Math.abs(root.val-target);
			res[0] = root.val;			
		}
		doCmp(root.left, target, min, res); //左子树
		doCmp(root.right, target, min, res);//右子树
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