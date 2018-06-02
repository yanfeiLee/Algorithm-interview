package com.lyf.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 *@function  将Linked list 逆序存储到数组中
 *@author Administrator
 *@date 2018年3月30日 下午5:41:41 
 *
 */
public class ReverseStorage {

	@Test
	public void test() {

	}
	/**
	 * 将Linked list 逆序存储【利用栈的特点】
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
	 * 利用递归实现
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