package com.lyf.simple;


import org.junit.Test;

/**
 * @function ����kmp�㷨ʵ���ַ�����ƥ��
 * 			refrence:http://www.matrix67.com/blog/archives/115
 * 					 https://blog.csdn.net/yutianzuijin/article/details/11954939/
 * @author Administrator
 * @date 2018��4��27�� ����9:09:07
 *
 */
public class KMP {

	@Test
	public void test() {
		String original = "";
		String find = "";
//		String original2 = null;
//		String find2 = null;
//		if(original2 == find2){ //��ַ�Ƚ�
//			System.out.println("==--");
//		}
//		if(original.equals(find)){
//			System.out.println("==");
//		}else{
//			System.out.println("no");
//		}
		System.out.println(search(original, find));
	}
    
	public int[] getNext(String b) {
		int len = b.length();
		int j = 0;

		int next[] = new int[len + 1];// next��ʾ����Ϊi���ַ���ǰ׺�ͺ�׺����������֣���1��ʼ		
		next[0] = next[1] = 0;
		 
		
		for (int i = 1; i < len; i++)// i��ʾ�ַ������±꣬��0��ʼ
		{// j��ÿ��ѭ����ʼ����ʾnext[i]��ֵ��ͬʱҲ��ʾ��Ҫ�Ƚϵ���һ��λ��
			while (j > 0 && b.charAt(i) != b.charAt(j))
				j = next[j];
			if (b.charAt(i) == b.charAt(j))
				j++;
			next[i + 1] = j;
		}
		for (int i = 0; i < next.length; i++) {
			System.out.println("next["+i+"]="+ next[i]);
		}
		return next;
	}

	public int search(String original, String find) {
		//�߽��ж�
		if(null == original || null == find || (original.equals("") && !find.equals(""))){
			return -1;
		}else if(original.equals(find) || find.equals("")){
			return 0;
		}
		int next[] = getNext(find);
		int j = 0;
		int res  = -1;
		for (int i = 0; i < original.length(); i++) {
			while (j > 0 && original.charAt(i) != find.charAt(j)){
				j = next[j];
			}
			if (original.charAt(i) == find.charAt(j)) j++;
			if (j == find.length()) {
				res = i + 1 -j;
				break;
//				System.out.println("find at position " + (i + 1 - j));
//				System.out.println(original.subSequence(i - j + 1, i + 1));
//				j = next[j];  //��������ʣ�µ��ַ����������е��ִ�find
			}
		}
		return res;
	}
}
