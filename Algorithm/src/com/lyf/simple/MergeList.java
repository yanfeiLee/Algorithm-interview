package com.lyf.simple;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 *@function Merge two sorted (ascending) lists of interval and return it as a new sorted list. 
 *The new sorted list should be made by splicing together the intervals of the two lists 
 *and sorted in ascending order.
 *note:
 *	The intervals in the given list do not overlap.
 *	The intervals in different lists may overlap.
 *Example:
 *	Given list1 = [(1,2),(3,4)] and list2 = [(2,3),(5,6)], return [(1,4),(5,6)].
 *@author Administrator
 *@date 2018年3月30日 下午6:14:08 
 *
 */
public class MergeList {

	@Test
	public void test() {
		Interval i1 = new Interval(1,2);
		Interval i11 = new Interval(3,4);
		Interval i2 = new Interval(2,3);
		Interval i21 = new Interval(5,6);
		ArrayList<Interval> al1 = new ArrayList<Interval>();
		ArrayList<Interval> al2 = new ArrayList<Interval>();
		al1.add(i1);
		al1.add(i11);
		al2.add(i2);
		al2.add(i21);
		ArrayList<Interval> res  = (ArrayList<Interval>) mergeTwoInterval2(al1, al2);
		for(Interval i:res){
			System.out.println(i.start+"----"+i.end);
		}
//		printClassFields();
	}
	/**
	 * 合并两个list中的间隔，并升序排列
	 * @param list1
	 * @param list2
	 * @return
	 */
	public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        if(null == list1 && null == list2) return null;
        if(null ==list1&& null!= list2){
        	return list2;
        }else if(null !=list1 && null== list2){
        	return list1;
        }
        ArrayList<Interval> res = new ArrayList<Interval>();
        int len1 = list1.size();
        int len2 = list2.size();
        if(list1.get(len1-1).end > list2.get(len2-1).end){
        	if(list1.get(0).start > list2.get(len2-1).end){
        		Interval  i1 = new Interval(list2.get(0).start,list2.get(len2-1).end);
        		Interval  i2 = new Interval(list1.get(0).start+1,list1.get(len1-1).end);
        		res.add(i1);
        		res.add(i2);
        	}else if(list1.get(0).start <= list2.get(0).start){
        		Interval i1 = new Interval(list1.get(0).start,list1.get(len1-1).end);
        		res.add(i1);
        	}else{
        		Interval  i1 = new Interval(list2.get(0).start,list2.get(len2-1).end);
        		Interval  i2 = new Interval(list2.get(len2-1).end+1,list1.get(len1-1).end);
        		res.add(i1);
        		res.add(i2);
        	}
        }else if(list1.get(len1-1).end < list2.get(len2-1).end){
        	if(list2.get(0).start > list1.get(len1-1).end){
        		Interval  i1 = new Interval(list1.get(0).start,list1.get(len1-1).end);
        		Interval  i2 = new Interval(list2.get(0).start+1,list2.get(len2-1).end);
        		res.add(i1);
        		res.add(i2);
        	}else if(list2.get(0).start <= list1.get(0).start){
        		Interval i1 = new Interval(list2.get(0).start,list2.get(len2-1).end);
        		res.add(i1);
        	}else{
        		Interval  i1 = new Interval(list1.get(0).start,list1.get(len1-1).end);
        		Interval  i2 = new Interval(list1.get(len1-1).end+1,list2.get(len2-1).end);
        		res.add(i1);
        		res.add(i2);
        	}
        }else{
        	if(list1.get(0).start <= list2.get(0).start){
        		Interval  i1= new Interval(list1.get(0).start,list1.get(len1-1).end);
        		res.add(i1);
        	}else{
        		Interval  i1 = new Interval(list2.get(0).start,list1.get(0).start);
        		Interval  i2 = new Interval(list1.get(0).end+1,list2.get(len2-1).end);
        		res.add(i1);
        		res.add(i2);
        	}
        }
        return res;
    }

	/**
	 * 利用队列实现，Deque(双端队列接口)继承了Queue接口
	 * @param list1
	 * @param list2
	 * @return
	 */
	public List<Interval> mergeTwoInterval2(List<Interval> list1, List<Interval> list2) {
        List<Interval> res = new ArrayList<>();
        
        Deque<Interval> deque = new LinkedList<>();
        int index1 = 0;
        int index2 = 0;
        
        while (index1 < list1.size() && index2 < list2.size()) {
            Interval i1 = list1.get(index1);
            Interval i2 = list2.get(index2);
            if (i1.start < i2.start) {
                offer(deque, i1);
                index1++;
            } else {
                offer(deque, i2);
                index2++;
            }
        }
        
        while (index1 < list1.size()) {
            Interval i1 = list1.get(index1);
            offer(deque, i1);
            index1++;
        }
        
        while (index2 < list2.size()) {
            Interval i2 = list2.get(index2);
            offer(deque, i2);
            index2++;
        }
        
        while (!deque.isEmpty()) {
            res.add(deque.poll());
        }
        
        return res;
    }
    
	/**
	 * 最新比较的结果插入队列
	 * @param deque
	 * @param i1
	 */
    public void offer(Deque<Interval> deque, Interval i1) {
        Interval last = deque.peekLast();
        if (last == null) {
            deque.offer(i1);
        } else {
            if (last.end >= i1.start) {
                last = deque.removeLast();
                last.end = Math.max(last.end, i1.end);
                deque.offer(last);
            } else {
                deque.offer(i1);
            }
        }
    }
    
    /*
     * 利用java反射机制获取类内部信息
     */
//    public void printClassFields() {        	 
//        for (Field field: Interval.class.getFields()) {        	 
//            StringBuilder lineBuilder = new StringBuilder();
//
//            lineBuilder.append(field.getName());
//
//            field.setAccessible(true);
//
//            lineBuilder.append(" " + field.getName() + " ");
//            
//            System.out.println(lineBuilder.toString());
//        }
//    }

}
class Interval {
	     public int start, end;
		 Interval(int start, int end) {
	          this.start = start;
	          this.end = end;
	      }
}