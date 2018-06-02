package com.lyf.simple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

/**
 *@function 计算杨辉三角的第n行
 *@author Administrator
 *@date 2018年3月13日 上午11:46:00 
 *
 */
public class YanghuiTriangle {

	@Test
	public void test() {
		List<List<Integer>> res  = getTriangle2(0);
		for(int k = 0; k<res.size();k++){
			List<Integer> line = res.get(k);		
			for (int i = 0; i < line.size(); i++) {
				System.out.print(line.get(i)+" ");				
			} 
			System.out.println("\r\n");
		}
	}
	/**
	 * 根据n获取杨辉三角数组
	 * @param n
	 * @return
	 */
	public List<List<Integer>> getTriangle2(int n){
		List<List<Integer>> mytTiangle = new ArrayList<List<Integer>>();		
		int tmp = 1;
		for(int i=1; i<=n; i++){
			List<Integer> line = new ArrayList<Integer>();
			if(1 == i){
				line.add(tmp);
				mytTiangle.add(line);				 
			}else if(2 == i){
				line.add(tmp);
				line.add(tmp);
				mytTiangle.add(line);				 
			}else{
				line.add(tmp);
				for (int j = 1; j <= i-2; j++) {
			 		line.add(mytTiangle.get(i-2).get(j)+mytTiangle.get(i-2).get(j-1));
				}
				line.add(tmp);
				mytTiangle.add(line);
			}					
		}		
		return mytTiangle;
	}
}
