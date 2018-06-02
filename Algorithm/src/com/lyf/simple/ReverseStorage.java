package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 *@function  ��Linked list ����洢��������
 *@author Administrator
 *@date 2018��3��30�� ����5:41:41 
 *
 */
public class ReverseStorage {

	@Test
	public void test() {

	}
	/**
	 * ��Linked list ����洢������ջ���ص㡿
	 * 
	 */
	public List<Integer> reverseStore(ListNode head) {
        // write your code here
		if(null == head) return null;
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		while(null != head.next){
			s.push(head.val);
			head = head.next;
		}
		s.push(head.val);
		while(!s.empty()){
			res.add(s.pop());
		}
		return res;
    }
	/**
	 * ���õݹ�ʵ��
	 * @param p
	 */
	ArrayList<Integer> res = new ArrayList<Integer>();
	private void store(ListNode p) {
        if (p == null) {
            return;
        }
        
        store(p.next);
        res.add(p.val);
    }    
    public List<Integer> reverseStore2(ListNode head) {
        store(head);
        return res;
    }
}

class ListNode{
	int val = 0;
	ListNode next = null;
	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = null;
	}	
}