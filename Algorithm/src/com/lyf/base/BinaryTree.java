package com.lyf.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/**
 * 二叉树基本操作[深度、遍历、最大值的节点查找]
 * 
 * @author Administrator
 *
 */
public class BinaryTree {

	public TreeNode root = null;
	public ArrayList<TreeNode> res = new ArrayList<TreeNode>();
	public ArrayList<Integer> res_mid = new ArrayList<Integer>();

	@Test
	public void test() {
		BinaryTree bt = new BinaryTree();
		int[] a = { 2, 4, -1, 0, 12, 45, 21, 6, 111 };
		// 构建二叉树
		for (int i = 0; i < a.length; i++) {
			bt.createBST(bt.root, a[i]);
		}

		// 获取最大值的节点
		System.out.println("节点最大的值为:" + getMaxNode2(bt.root).val);
		// 深度计算
		System.out.println(bt.depth(bt.root));

		// 遍历
		// System.out.println("-------先序-------");
		// preOrder(bt.root);
		// for (TreeNode tn : this.res) {
		// System.out.println(tn.val);
		// }
		// System.out.println("-------中序-------");
		// this.res.clear();
		// midOrder(bt.root);
		// for (TreeNode tn : this.res) {
		// System.out.println(tn.val);
		// }
		// System.out.println("-------后序-------");
		// this.res.clear();
		// postOrder(bt.root);
		// for (TreeNode tn : this.res) {
		// System.out.println(tn.val);
		// }
		// System.out.println("-------层序-------");
		// this.res.clear();
		// levelOrder(bt.root);
		// for (TreeNode tn : this.res) {
		// System.out.println(tn.val);
		// }
//
//		System.out.println("-------非递归层次遍历-------");
//		this.res.clear();
//		nonRecursiveTraverseMid(bt.root);
//		for (TreeNode tn : this.res) {
//			System.out.println(tn.val);
//		}
		
		System.out.println("-------递归层次遍历,返回二维数组-------");		 
		List<List<Integer>> res = levelOrder2(bt.root);
		for (List tn : res) {
			System.out.println(tn);
		}

	}

	/**
	 * 构建二叉查找/排序树【BST】
	 * 
	 * @return
	 */
	public TreeNode createBST(TreeNode tNode, int v) {
		if (null == tNode) {
			root = new TreeNode(v);
		} else {
			if (v < tNode.val) {
				if (null == tNode.left) {
					tNode.left = new TreeNode(v);
				} else {
					createBST(tNode.left, v);
				}
			} else {
				if (null == tNode.right) {
					tNode.right = new TreeNode(v);
				} else {
					createBST(tNode.right, v);
				}
			}
		}
		return null;
	}

	/**
	 * 先序遍历二叉树[递归法]
	 * 
	 * @param root
	 */
	public void preOrder(TreeNode node) {
		if (null == node)
			return;
		// System.out.println(node.val);
		this.res.add(node);
		preOrder(node.left);
		preOrder(node.right);

	}

	/**
	 * 中序
	 * 
	 * @param node
	 */
	public void midOrder(TreeNode node) {
		if (null == node)
			return;
		midOrder(node.left);
		this.res.add(node);
		midOrder(node.right);
	}

	public List<Integer> midOrder2(TreeNode root) {
		if (null != root) {
			this.midOrder2(root.left);
			res_mid.add(root.val);
			this.midOrder2(root.right);
		}
		return res_mid;
	}

	/**
	 * 分治+递归
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> midOrder3(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		// Divide
		List<Integer> left = midOrder3(root.left);
		List<Integer> right = midOrder3(root.right);

		// Conquer
		result.addAll(left);
		result.add(root.val);
		result.addAll(right);
		return result;
	}

	/**
	 * 后序
	 * 
	 * @param node
	 */
	public void postOrder(TreeNode node) {
		if (null == node)
			return;
		postOrder(node.left);
		postOrder(node.right);
		this.res.add(node);
	}

	/**
	 * 层序遍历,返回结果为一维数组[3,2,32,22,90,21,901]
	 * 
	 * @param node
	 */
	public void levelOrder(TreeNode node) {
		if (null == node)
			return;
		int depth = this.depth(node);
		for (int i = 1; i <= depth; i++) {
			levelOrder(node, i);
		}
	}
	private void levelOrder(TreeNode node, int level) {
		if (node == null || level < 1) {
			return;
		}
		if (level == 1) {
			this.res.add(node);
			return;
		}
		// 左子树
		levelOrder(node.left, level - 1);
		// 右子树
		levelOrder(node.right, level - 1);
	}
	/**
	 * 递归层序遍历,返回结果为二维数组[[3],[2,32],[22],[90,21],[901]]
	 * @param node
	 */
	public List<List<Integer>> levelOrder2(TreeNode node) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (null == node)
			return res;
		int depth = this.depth(node);
		for (int i = 1; i <= depth; i++) {
			ArrayList<Integer> levelNode = new ArrayList<Integer>();
			levelOrder2(node, i,levelNode);
			res.add(levelNode);
		}
		return res;
	}
	private void levelOrder2(TreeNode node, int level,ArrayList levelNode) {
		if (node == null || level < 1) {
			return;
		}
		if (level == 1) {
			levelNode.add(node.val);
			return;
		}
		// 左子树
		levelOrder2(node.left, level - 1, levelNode);
		// 右子树
		levelOrder2(node.right, level - 1, levelNode);
	}

	/**
	 * 非递归前序遍历二叉树,
	 * 
	 * @param node
	 */
	public void nonRecursiveTraversePre(TreeNode node) {
		if (null == node)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(node);
		while (!s.isEmpty()) {
			// 前序
			TreeNode topNode = s.pop(); // 顶部节点
			this.res.add(topNode);
			if (null != topNode.right) {
				s.push(topNode.right);
			}
			if (null != topNode.left) {
				s.push(topNode.left);
			}
		}
	}

	/**
	 * 非递归 中序遍历二叉树
	 * 
	 * @param node
	 */
	public void nonRecursiveTraverseMid(TreeNode node) {
		if (null == node)
			return;
		TreeNode tmpNode = node; // 移动节点tmpNode;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (!s.empty() || null != tmpNode) {
			while (null != tmpNode) {
				s.push(tmpNode);
				tmpNode = tmpNode.left;
			}
			if (!s.empty()) {
				tmpNode = s.pop();
				this.res.add(tmpNode);
				tmpNode = tmpNode.right;
			}
		}
	}

	/**
	 * 非递归 后序遍历
	 * 
	 * @param node
	 */
	public void nonRecursiveTraversePost(TreeNode node) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		int i = 1;
		while (node != null || !stack1.empty()) {
			while (node != null) {
				stack1.push(node);
				stack2.push(0);
				node = node.left;
			}

			while (!stack1.empty() && stack2.peek() == i) {
				stack2.pop();
				System.out.print(stack1.pop().val + "   ");
			}

			if (!stack1.empty()) {
				stack2.pop();
				stack2.push(1);
				node = stack1.peek();
				node = node.right;
			}
		}
	}

	/**
	 * 非递归层次遍历,返回一维数组[3,2,32,22,90,21,901]
	 * 
	 * @param node
	 */
	public void nonRecursiveTraverseLevel(TreeNode node) {
		if (null == node)
			return;
		TreeNode tmpNode;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		while (0 != q.size()) {
			tmpNode = q.poll();
			this.res.add(tmpNode);
			if (null != tmpNode.left) {
				q.offer(tmpNode.left);
			}
			if (null != tmpNode.right) {
				q.offer(tmpNode.right);
			}
		}
	}

	/**
	 * 非递归层序遍历，返回二维数组[[3],[2,32],[22],[90,21],[901]]
	 * 
	 * @param node
	 */
	public List<List<Integer>> nonRecursiveTraverseLevel2(TreeNode node) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (null == node)
			return res;
		TreeNode tmpNode;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		while (0 != q.size()) {
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				tmpNode = q.poll();
				level.add(tmpNode.val);
				if (null != tmpNode.left) {
					q.offer(tmpNode.left);
				}
				if (null != tmpNode.right) {
					q.offer(tmpNode.right);
				}
			}
			res.add(level);
		}
		return res;
	}

	/**
	 * 利用双list实现
	 * 
	 * @param node
	 * @return
	 */
	public List<List<Integer>> nonRecursiveTraverseLevel3(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		List<TreeNode> Q1 = new ArrayList<TreeNode>(); // 存放每层的node
		List<TreeNode> Q2 = new ArrayList<TreeNode>(); // 统计每层的node，给Q1
		Q1.add(root);
		while (Q1.size() != 0) {
			List<Integer> level = new ArrayList<Integer>();
			Q2.clear();
			for (int i = 0; i < Q1.size(); i++) {
				TreeNode node = Q1.get(i);
				level.add(node.val);
				if (node.left != null) {
					Q2.add(node.left);
				}
				if (node.right != null) {
					Q2.add(node.right);
				}
			}

			// swap q1 and q2
			List<TreeNode> temp = Q1;
			Q1 = Q2;
			Q2 = temp;

			// add to result
			result.add(level);
		}
		return result;
	}
	/**
	 * 在队列中插入数据时，每层遍历完后，队列插入一个null，以此来分割各层
	 * @param root
	 * @return
	 */
	public List<List<Integer>> nonRecursiveTraverseLevel4(TreeNode root) {
		List<List<Integer>>  res = new  ArrayList<List<Integer>>();
		if(null == root) return res;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		q.offer(null); //插入一个null,作为各层分割标记
		
		ArrayList<Integer> level = new ArrayList<Integer>();
		while(!q.isEmpty()){			
			TreeNode  tmpNode = q.poll();
			if(null == tmpNode){
				if(0 == level.size()){
					break;
				}
				res.add(level);
				level = new ArrayList<Integer>(); //清空此层元素
//				level.clear();
				q.offer(null); //某层遍历完成，插入null 分割符
				continue;  //继续下一次while循环
			}
			level.add(tmpNode.val);
			if(null != tmpNode.left){
				q.offer(tmpNode.left);
			}
			if(null != tmpNode.right){
				q.offer(tmpNode.right);
			}
		}
		return res;
	}
	/**
	 * 计算二叉树的深度
	 * 
	 * @param node
	 *            根节点
	 * @return
	 */
	public int depth(TreeNode node) {
		if (null == node)
			return 0;
		int l = depth(node.left);
		int r = depth(node.right);
		return l > r ? l + 1 : r + 1;
	}

	/**
	 * 利用非递归方法，获取二叉树中值最大的节点
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode getMaxNode(TreeNode root) {
		if (null == root)
			return null;
		TreeNode maxNode = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode topNode = s.pop();
			if (topNode.val > maxNode.val) {
				maxNode = topNode;
			}
			if (null != topNode.right) {
				s.push(topNode.right);
			}
			if (null != topNode.left) {
				s.push(topNode.left);
			}
		}
		return maxNode;
	}

	/**
	 * 递归方法，获取最大值的节点
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode getMaxNode2(TreeNode root) {
		if (null == root)
			return null;
		TreeNode leftNode = getMaxNode2(root.left);
		TreeNode rightNode = getMaxNode2(root.right);
		return max(root, max(rightNode, leftNode));
	}

	private TreeNode max(TreeNode a, TreeNode b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.val > b.val) {
			return a;
		} else {
			return b;
		}

	}
}

/**
 * 二叉树节点类
 * 
 * @author Administrator
 *
 */
class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}