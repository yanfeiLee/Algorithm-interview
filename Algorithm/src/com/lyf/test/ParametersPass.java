package com.lyf.test;

import org.junit.Test;

/**
 *@function  java 的传参方式 只有值传递，
 *而非基本数据类型，传递的是对象的引用[即对象地址]
 *@author Administrator
 *@date 2018年3月16日 下午12:05:39 
 *
 */
public class ParametersPass {

	@Test
	public void test() {
		Person a = new Person(23, "a");
	    Person b = new Person(22,"b");
	    System.out.println("交换前a:"+a.toString()+"  而   b:"+b.toString());
//	    swap(a, b);
	    ageAdd(a, b);
	    System.out.println("交换后a:"+a.toString()+"  而   b:"+b.toString());
	}	 
	private static void swap(Person a, Person b) {
	    Person temp = a;
	    a = b;
	    b = temp;
	}
	private static void ageAdd(Person a, Person b){
		a.age = 1;
	    b.age = 2;
	}
}

class Person{
	public int age;
	public String name;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public String toString(){
		return name+"===>"+age;		
	}
}