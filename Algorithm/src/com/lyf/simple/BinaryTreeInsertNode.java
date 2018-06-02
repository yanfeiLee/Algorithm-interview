package com.lyf.simple;

import org.junit.Test;

/**
 *@function  在二叉查找数中，插入一个节点，使得此树仍是二叉查找树
 *		Note:You can assume there is no duplicate values in this tree + node.
 *@author Administrator
 *@date 2018年4月16日 上午10:44:58 
 *
 */
public class BinaryTreeInsertNode {

	@Test
	public void test() {

	}
	/**
	 * 递归添加
	 * @param root
	 * @param node
	 * @return
	 */
	public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
		if (root == null) {
	           return node;
	        }
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
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
