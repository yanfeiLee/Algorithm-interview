package com.lyf.simple;

import java.util.Stack;

import org.junit.Test;
/**
 *@function 找到单链表倒数第n个节点，保证链表中节点的最少数量为n。
 *	Example:
 *			给出链表 3->2->1->5->null和n = 2，返回倒数第二个节点的值1.
 *@author Administrator
 *@date 2018年4月14日 上午10:57:23 
 *
 */
public class ListNthNodeVal {

	@Test
	public void test() {
		
	}
	/**
	 * 获取的list倒数第n个节点，【超时】
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode nthToLast(ListNode head, int n) {
		if(null == head) return null;
		int len = 1;		
		while(null != head.next){
			len++;
		}
		if(n > len) return null;
		int tmp = 1;
		if(n == len) return head;
		while(null != head.next){			
			tmp++;			
			if(tmp == len+1-n){
				return head.next;
			}
			head = head.next;
		}
		return null;
	}
	
	/**
	 * 利用栈保存节点，倒数第n个，弹出到第n次即可
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode nthToLast2(ListNode head, int n) {
		if(null == head) return null;
		Stack<ListNode> s = new Stack<ListNode>();		
		while(null != head){
			s.push(head);
			head = head.next;
		}
		for (int i = 0; i < n-1; i++) {
			s.pop();
		}
		return s.pop();
	}
	/**
	 * 双指针移动，当第2个指针移动到第n个元素时，第一个指针开始移动，直到第2个指针为null
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode nthToLast3(ListNode head, int n) {
		if (head == null || n < 1) {
			return null;
		}
	    
        ListNode p1 = head;
        ListNode p2 = head;
        for (int j = 0; j < n - 1; ++j) {
        	//n大于列表长度
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
        }
        while (p2.next != null) {   
            p1 = p1.next;   
            p2 = p2.next;
	    }
	    return p1;
	}
	
	
	
	
	
	
	
	
	class ListNode{
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
}
