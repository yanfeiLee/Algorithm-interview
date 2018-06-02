package com.lyf.base;

import org.junit.Test;

/**
 * 获取链表的节点个数
 * @author Administrator
 *
 */
public class ListNodes {
	
	
	@Test
	public void test(){
		this.head = null;
		for(int i=0; i<9; i++){
			ListNode ln = new ListNode(i*5);
			addNodeToBack(ln);
			//addNodeToFront(ln);
		}
		
		this.head = deleteNodeByVal(this.head,25);
		
		while(null != head){
			System.out.println(head.val);
			head = head.next;
		}
//		System.out.println(countNodes());
	}
	
	
	private ListNode head = null;
	
	
	
	
	/**
	 * 后插入
	 * @param ln
	 */
	public void  addNodeToBack(ListNode ln){
		ListNode tmpNode = this.head;
		if(null != this.head){
			while(null != tmpNode.next){
				tmpNode = tmpNode.next;
			}
			tmpNode.next = ln;
		}else{
			ln.next = this.head;
			this.head = ln;			
		}
	}
	/**
	 * 前插入
	 * @param ln
	 */
	public void addNodeToFront(ListNode ln){				 
			ln.next = this.head;
			this.head = ln;
	}
	/**
	 * 根据值删除节点，删除所有值为val的节点
	 * 使用原有节点，声明当前节点和下一个节点
	 * @param val
	 */
	public ListNode deleteNodeByVal(ListNode head,int val){		
		ListNode onNode = head;
        if(null != head){
            ListNode nextNode = onNode.next;
            while(null != nextNode){
                if(val == nextNode.val){
                    onNode.next = nextNode.next;
                    nextNode =  nextNode.next;
                }else{
                	onNode = nextNode;
                	nextNode = nextNode.next;
                }
            }
            if(val == head.val){
                head = head.next;
            }
        }
        return head;
		 
	}
	/**
	 * 在原有链表前添加一个虚拟节点，一次删除
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode deleteNodeByVal2(ListNode head,int val){
		ListNode  vNode = new ListNode(0);
		vNode.next = head;
		head = vNode;
		while(null != head.next){
			if(val == head.next.val){
				head.next = head.next.next;				 
			}else{
				head = head.next;
			}
		}		 
		return vNode.next;		
	}
	/**
	 * 删除给定的节点(非头、尾节点)
	 * @param ln
	 */
	public void deleteNode(ListNode ln){
		if(null == ln || null == ln.next ) return;
		ListNode next = ln.next;
		ln.val = next.val;
		ln.next = next.next;
	}
	
	/**
	 * 计算节点个数
	 * @param head
	 * @return
	 */
	public int countNodes(ListNode head) {
		 int count = 1;
		 if(null != head){
			 while(null != head.next){
		    	 count++;
		    	 head = head.next;
		     }
		 }else{
			 count = 0;
		 }
	    
		 return count;
	}
}

/**
 * 节点类
 * @author Administrator
 *
 */
class ListNode {
	  int val;
	  ListNode next;
	  ListNode(int val) {
	      this.val = val;
	      this.next = null;
	}
}