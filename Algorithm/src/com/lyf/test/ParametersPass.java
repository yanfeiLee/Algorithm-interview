package com.lyf.test;

import org.junit.Test;

/**
 *@function  java �Ĵ��η�ʽ ֻ��ֵ���ݣ�
 *���ǻ����������ͣ����ݵ��Ƕ��������[�������ַ]
 *@author Administrator
 *@date 2018��3��16�� ����12:05:39 
 *
 */
public class ParametersPass {

	@Test
	public void test() {
		Person a = new Person(23, "a");
	    Person b = new Person(22,"b");
	    System.out.println("����ǰa:"+a.toString()+"  ��   b:"+b.toString());
//	    swap(a, b);
	    ageAdd(a, b);
	    System.out.println("������a:"+a.toString()+"  ��   b:"+b.toString());
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