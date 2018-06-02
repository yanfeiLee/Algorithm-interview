package com.lyf.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/**
 * ��������������[��ȡ����������ֵ�Ľڵ����]
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
		// ����������
		for (int i = 0; i < a.length; i++) {
			bt.createBST(bt.root, a[i]);
		}

		// ��ȡ���ֵ�Ľڵ�
		System.out.println("�ڵ�����ֵΪ:" + getMaxNode2(bt.root).val);
		// ��ȼ���
		System.out.println(bt.depth(bt.root));

		// ����
		// System.out.println("-------����-------");
		// preOrder(bt.root);
		// for (TreeNode tn : this.res) {
		// System.out.println(tn.val);
		// }
		// System.out.println("-------����-------");
		// this.res.clear();
		// midOrder(bt.root);
		// for (TreeNode tn : this.res) {
		// System.out.println(tn.val);
		// }
		// System.out.println("-------����-------");
		// this.res.clear();
		// postOrder(bt.root);
		// for (TreeNode tn : this.res) {
		// System.out.println(tn.val);
		// }
		// System.out.println("-------����-------");
		// this.res.clear();
		// levelOrder(bt.root);
		// for (TreeNode tn : this.res) {
		// System.out.println(tn.val);
		// }
//
//		System.out.println("-------�ǵݹ��α���-------");
//		this.res.clear();
//		nonRecursiveTraverseMid(bt.root);
//		for (TreeNode tn : this.res) {
//			System.out.println(tn.val);
//		}
		
		System.out.println("-------�ݹ��α���,���ض�ά����-------");		 
		List<List<Integer>> res = levelOrder2(bt.root);
		for (List tn : res) {
			System.out.println(tn);
		}

	}

	/**
	 * �����������/��������BST��
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
	 * �������������[�ݹ鷨]
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
	 * ����
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
	 * ����+�ݹ�
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
	 * ����
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
	 * �������,���ؽ��Ϊһά����[3,2,32,22,90,21,901]
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
		// ������
		levelOrder(node.left, level - 1);
		// ������
		levelOrder(node.right, level - 1);
	}
	/**
	 * �ݹ�������,���ؽ��Ϊ��ά����[[3],[2,32],[22],[90,21],[901]]
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
		// ������
		levelOrder2(node.left, level - 1, levelNode);
		// ������
		levelOrder2(node.right, level - 1, levelNode);
	}

	/**
	 * �ǵݹ�ǰ�����������,
	 * 
	 * @param node
	 */
	public void nonRecursiveTraversePre(TreeNode node) {
		if (null == node)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(node);
		while (!s.isEmpty()) {
			// ǰ��
			TreeNode topNode = s.pop(); // �����ڵ�
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
	 * �ǵݹ� �������������
	 * 
	 * @param node
	 */
	public void nonRecursiveTraverseMid(TreeNode node) {
		if (null == node)
			return;
		TreeNode tmpNode = node; // �ƶ��ڵ�tmpNode;
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
	 * �ǵݹ� �������
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
	 * �ǵݹ��α���,����һά����[3,2,32,22,90,21,901]
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
	 * �ǵݹ������������ض�ά����[[3],[2,32],[22],[90,21],[901]]
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
	 * ����˫listʵ��
	 * 
	 * @param node
	 * @return
	 */
	public List<List<Integer>> nonRecursiveTraverseLevel3(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		List<TreeNode> Q1 = new ArrayList<TreeNode>(); // ���ÿ���node
		List<TreeNode> Q2 = new ArrayList<TreeNode>(); // ͳ��ÿ���node����Q1
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
	 * �ڶ����в�������ʱ��ÿ�������󣬶��в���һ��null���Դ����ָ����
	 * @param root
	 * @return
	 */
	public List<List<Integer>> nonRecursiveTraverseLevel4(TreeNode root) {
		List<List<Integer>>  res = new  ArrayList<List<Integer>>();
		if(null == root) return res;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		q.offer(null); //����һ��null,��Ϊ����ָ���
		
		ArrayList<Integer> level = new ArrayList<Integer>();
		while(!q.isEmpty()){			
			TreeNode  tmpNode = q.poll();
			if(null == tmpNode){
				if(0 == level.size()){
					break;
				}
				res.add(level);
				level = new ArrayList<Integer>(); //��մ˲�Ԫ��
//				level.clear();
				q.offer(null); //ĳ�������ɣ�����null �ָ��
				continue;  //������һ��whileѭ��
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
	 * ��������������
	 * 
	 * @param node
	 *            ���ڵ�
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
	 * ���÷ǵݹ鷽������ȡ��������ֵ���Ľڵ�
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
	 * �ݹ鷽������ȡ���ֵ�Ľڵ�
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
 * �������ڵ���
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