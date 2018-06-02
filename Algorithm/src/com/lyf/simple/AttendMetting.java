package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * @function 给定一系列的会议时间间隔，包括起始和结束时间[[s1,e1]，[s2,e2]，…(si < ei)，确定一个人是否可以参加所有会议。
 * 		Examples:
 * 			给定区间=[[0,30]，[5,10]，[15,20]]，返回false。
 * @author Administrator
 * @date 2018年4月24日 上午8:57:05
 *
 */
public class AttendMetting {

	@Test
	public void test() {
		Interval in1 = new Interval(5, 8);
		Interval in2 = new Interval(6, 8);
		List<Interval> al = new ArrayList<AttendMetting.Interval>();
		al.add(in1);
		al.add(in2);
		System.out.println(canAttendMeetings(al));
	}
	/**
	 * 利用comparable 接口比较，需要修改Interval 类
	 * @param intervals
	 * @return
	 */
	public boolean canAttendMeetings(List<Interval> intervals) {
		//转换为array,并指定转换后的类型和数组大小
		Interval[] inters =  intervals.toArray(new Interval[intervals.size()]);
		Arrays.sort(inters);//comparable
		Arrays.sort(inters,0,inters.length,new MyCMP());//Comparator
		for (int i = 0; i < inters.length - 1; i++) {
			if(inters[i].end > inters[i+1].start){
				return false;
			}
		}
	    return true;
	}
	
	
	/**
	 * 时间间隔类
	 * @author Administrator
	 *
	 */
	class Interval implements Comparable<Interval> {
		 public int start, end;
		 Interval(int start, int end) {
			  	  this.start = start;
		          this.end = end;
		 }
		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Interval o) {
			// TODO Auto-generated method stub
			 if(this.start != o.start){
				 return this.start > o.start ? 1 : -1;
			 }
			 if(this.end != o.end){
				 return this.end > o.end ? 1 : -1;
			 }
			 return 0;
		}
	}
	
	/**
	 * 实现cmoparator接口，不需修改Interval类
	 * @author Administrator
	 *
	 */
	class MyCMP implements Comparator<Interval>{

		/* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			 if(o1.start != o2.start){
				 return o1.start > o2.start ? 1 : -1;
			 }
			 if(o1.end != o2.end){
				 return o1.end > o2.end ? 1 : -1;
			 }
			 return 0;
			 
		}
	 
		
	}
}

