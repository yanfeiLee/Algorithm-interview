package com.lyf.simple;

import java.text.DecimalFormat;

import org.junit.Test;

/**
 * @function 计算余弦相似度，根据两个向量计算 Return 2.0000 if cosine similarity is invalid (for
 *           example A = [0] and B = [0]).
 * @author Administrator
 * @date 2018年3月15日 上午9:43:07
 *
 */
public class CosineSimilarity {

	@Test
	public void test() {
		int[] A = {};
		int[] B = {};
		System.out.println(getCosSimilarity(A, B));
	}

	/**
	 * 计算余弦相似度
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public double getCosSimilarity(int[] A, int[] B) {		 
		int count = 0;		 
		int top = 0;
		int down1 = 0;
		int down2 = 0;
		for (int i = 0; i < A.length; i++) {
			if(A[i]==B[i] && A[i] == 0){
				count++;
			}else{
				top += A[i] * B[i];
				down1 += A[i] * A[i];
				down2 += B[i] * B[i];
			}
		}
		if(count == A.length){
			return 2.0000;
		}
		DecimalFormat df = new DecimalFormat("#.0000");
		return Double.parseDouble(df.format((double) top / (Math.sqrt(down2) * Math.sqrt(down1))));
	}
}
