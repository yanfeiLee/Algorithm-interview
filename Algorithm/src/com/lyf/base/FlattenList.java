package com.lyf.base;

import java.util.*;

/**
 * 接口
 * @author Administrator
 *
 */
interface NestedInteger {		 
    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class FlattenList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<Integer>();
		result.add(666);
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(23);
		al.add(223);
		al.add(323);
		result.addAll(al);
		for(Integer r:result){
			System.out.println(r);
		}

	}
	/**
	 * 递归方法实现 
	 */
	public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here      
        List<Integer> result = new ArrayList<Integer>();
        for (NestedInteger ele : nestedList)
            if (ele.isInteger())
                result.add(ele.getInteger());
            else
                result.addAll(flatten(ele.getList()));
        return result;
	} 
	/**
	 * 非递归方法实现
	 */
	 public List<Integer> flatten2(List<NestedInteger> nestedList) {
	        boolean isFlat = true;
	        List<NestedInteger> ls = nestedList;
	        while (isFlat) {
	            isFlat = false;
	            List<NestedInteger> newLs = new ArrayList<>();
	            for (NestedInteger ni : ls) {
	                if (ni.isInteger()) {
	                    newLs.add(ni);
	                } else {
	                    newLs.addAll(ni.getList());
	                    isFlat = true;
	                }
	            }
	            ls = newLs;
	        }
	        List<Integer> r = new ArrayList<>();
	        for (NestedInteger ni : ls) {
	            r.add(ni.getInteger());
	        }
	        return r;
	    }
}


 
