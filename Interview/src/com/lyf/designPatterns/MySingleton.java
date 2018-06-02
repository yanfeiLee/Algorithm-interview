package com.lyf.designPatterns;

import org.junit.Test;

/**
 * @function 单例模式 实现思路: 1.构造函数私有化 2.
 * @author lyf3312
 * @date 2018年3月20日 下午12:32:24
 *
 */
public class MySingleton {

	@Test
	public void test() {
		// System.out.println(Integer.toHexString(hashCode())); ？？？

		// 单线程单例模式测试
		System.out.println("-------------单线程单例模式测试—----------------");
		Dog d1 = Dog.getInstance();
		Dog d2 = Dog.getInstance();
		System.out.println(d1.toString() + "----" + d2.toString());
		System.out.println(d1.hashCode() + "----" + d2.hashCode());
		
		// 多线程
		System.out.println("-------------多线程程单例模式测试—----------------");
//	    MyRunable mr = new MyRunable();
//	    //线程不安全随机出现
//		for (int i = 0; i < 111; i++) {
//			new Thread(mr).start();
//		}
		
 
		
	}

}

/**
 * 测试将要创建的对象类
 * 
 * @author Administrator
 *
 */
class Dog {
	private Dog() {
	}

	private static Dog instance = null;

	/**
	 * 仅适用于单线程的单例模式 【不推荐】 
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
	 * 多线程环境下也可以实现单例模式 【推荐】
	 * 
	 * @return
	 */
	private static Object obj = new Object(); // 此对象用于加锁
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
	 * 利用静态内部类实现【推荐】  按需加载
	 * @return
	 */
	public static Dog getInstance3(){
		return InnerCls.instance;
	}
	private static class InnerCls{
		private static Dog instance = new Dog();  //此静态对象只会被实例化一次，而且是按需实例化，不会在类加载时就实例化
	}
}

class MyRunable implements Runnable {
	public Dog d = null;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("线程id= " + Thread.currentThread().getId());
//		this.d = Dog.getInstance(); // 可能出现类的多个实例
//		this.d = Dog.getInstance2();
		this.d = Dog.getInstance3();
		System.out.println("创建的dog  "+d.hashCode());
	}

}

