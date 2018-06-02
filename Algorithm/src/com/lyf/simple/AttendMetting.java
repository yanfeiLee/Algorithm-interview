package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * @function ����һϵ�еĻ���ʱ������������ʼ�ͽ���ʱ��[[s1,e1]��[s2,e2]����(si < ei)��ȷ��һ�����Ƿ���Բμ����л��顣
 * 		Examples:
 * 			��������=[[0,30]��[5,10]��[15,20]]������false��
 * @author Administrator
 * @date 2018��4��24�� ����8:57:05
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
	 * ����comparable �ӿڱȽϣ���Ҫ�޸�Interval ��
	 * @param intervals
	 * @return
	 */
	public boolean canAttendMeetings(List<Interval> intervals) {
		//ת��Ϊarray,��ָ��ת��������ͺ������С
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
	 * ʱ������
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
	 * ʵ��cmoparator�ӿڣ������޸�Interval��
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

