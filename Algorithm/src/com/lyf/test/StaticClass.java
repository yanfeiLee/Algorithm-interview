package com.lyf.test;

import org.junit.Test;

/**
 *@function
 *@author Administrator
 *@date 2018��4��26�� ����11:10:54 
 *
 */
public class StaticClass {

	@Test
	public void test() {
//		  A a = new B();//����ת��
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

abstract class A{//����һ��������

    static abstract class B{ //static������ڲ���������ͨ�ⲿ��
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