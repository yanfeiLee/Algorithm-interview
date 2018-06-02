package com.lyf.base;

/**
 * 获取矩阵的面积
 * @author Administrator
 *
 */
public class Rectangle {

	public int width;
	public int height;
	
	public Rectangle(int width, int height) {
		
		this.width = width;
		this.height = height;
	}
	
	public int getArea(){		
		return this.width>=0 && this.height>=0 ?this.width*this.height:null;
	}
	 
	
}
