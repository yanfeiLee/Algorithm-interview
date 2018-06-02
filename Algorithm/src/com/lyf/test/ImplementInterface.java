package com.lyf.test;

import org.junit.Test;

/**
 *@function
 *@author Administrator
 *@date 2018年4月26日 上午11:39:29 
 *
 */
public class ImplementInterface {

	@Test
	public void test() {

	}
}

interface Action{
	public void eat();
	public void walk();
}

abstract  class Animal{
	public abstract void yelp();
	public abstract void yelp2();
	public void shout(){
		System.out.println("狗叫");
	}
}

class Cat extends Animal {

	/* (non-Javadoc)
	 * @see com.lyf.test.Animal#yelp()
	 */
	@Override
	public void yelp() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.lyf.test.Animal#yelp2()
	 */
	@Override
	public void yelp2() {
		// TODO Auto-generated method stub
		
	}

}