package com.lyf.designPatterns;

import org.junit.Test;

/**
 * @function ����ģʽ ʵ��˼·: 1.���캯��˽�л� 2.
 * @author lyf3312
 * @date 2018��3��20�� ����12:32:24
 *
 */
public class MySingleton {

	@Test
	public void test() {
		// System.out.println(Integer.toHexString(hashCode())); ������

		// ���̵߳���ģʽ����
		System.out.println("-------------���̵߳���ģʽ���ԡ�----------------");
		Dog d1 = Dog.getInstance();
		Dog d2 = Dog.getInstance();
		System.out.println(d1.toString() + "----" + d2.toString());
		System.out.println(d1.hashCode() + "----" + d2.hashCode());
		
		// ���߳�
		System.out.println("-------------���̵̳߳���ģʽ���ԡ�----------------");
//	    MyRunable mr = new MyRunable();
//	    //�̲߳���ȫ�������
//		for (int i = 0; i < 111; i++) {
//			new Thread(mr).start();
//		}
		
 
		
	}

}

/**
 * ���Խ�Ҫ�����Ķ�����
 * 
 * @author Administrator
 *
 */
class Dog {
	private Dog() {
	}

	private static Dog instance = null;

	/**
	 * �������ڵ��̵߳ĵ���ģʽ �����Ƽ��� 
	 * 
	 * @return
	 */
	public static Dog getInstance() {
		if (null == instance) {
			instance = new Dog();
		}
		return instance;
	}

	/**
	 * ���̻߳�����Ҳ����ʵ�ֵ���ģʽ ���Ƽ���
	 * 
	 * @return
	 */
	private static Object obj = new Object(); // �˶������ڼ���
	public static Dog getInstance2() {
		if (null == instance) {
			synchronized (obj) {
				if (null == instance) {
					instance = new Dog();
				}
			}
		}
		return instance;
	}
	
	/**
	 * ���þ�̬�ڲ���ʵ�֡��Ƽ���  �������
	 * @return
	 */
	public static Dog getInstance3(){
		return InnerCls.instance;
	}
	private static class InnerCls{
		private static Dog instance = new Dog();  //�˾�̬����ֻ�ᱻʵ����һ�Σ������ǰ���ʵ�����������������ʱ��ʵ����
	}
}

class MyRunable implements Runnable {
	public Dog d = null;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("�߳�id= " + Thread.currentThread().getId());
//		this.d = Dog.getInstance(); // ���ܳ�����Ķ��ʵ��
//		this.d = Dog.getInstance2();
		this.d = Dog.getInstance3();
		System.out.println("������dog  "+d.hashCode());
	}

}

