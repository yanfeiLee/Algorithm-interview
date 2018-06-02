package com.lyf.simple;

import java.util.Stack;

import org.junit.Test;
/**
 *@function �ҵ�����������n���ڵ㣬��֤�����нڵ����������Ϊn��
 *	Example:
 *			�������� 3->2->1->5->null��n = 2�����ص����ڶ����ڵ��ֵ1.
 *@author Administrator
 *@date 2018��4��14�� ����10:57:23 
 *
 */
public class ListNthNodeVal {

	@Test
	public void test() {
		
	}
	/**
	 * ��ȡ��list������n���ڵ㣬����ʱ��
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
	 * ����ջ����ڵ㣬������n������������n�μ���
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
	 * ˫ָ���ƶ�������2��ָ���ƶ�����n��Ԫ��ʱ����һ��ָ�뿪ʼ�ƶ���ֱ����2��ָ��Ϊnull
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
        	//n�����б���
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
