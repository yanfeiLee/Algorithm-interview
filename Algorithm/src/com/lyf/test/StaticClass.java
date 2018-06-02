package com.lyf.test;

import org.junit.Test;

/**
 *@function
 *@author Administrator
 *@date 2018年4月26日 上午11:10:54 
 *
 */
public class StaticClass {

	@Test
	public void test() {
//		  A a = new B();//向上转型
//	      a.print();
		 C c = new C();
		 c.print();
	}
}

//static abstract class A{
//	  public abstract void print();
//}
//
//class B extends A{
//
//	/* (non-Javadoc)
//	 * @see com.lyf.test.A#print()
//	 */
//	@Override
//	public void print() {
//		// TODO Auto-generated method stub
//		System.out.println("**********");
//	}
//
//    
//}

abstract class A{//定义一个抽象类

    static abstract class B{ //static定义的内部类属于普通外部类
        public abstract void print();
    }

}

class C extends A.B{

	/* (non-Javadoc)
	 * @see com.lyf.test.A.B#print()
	 */
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}   
}