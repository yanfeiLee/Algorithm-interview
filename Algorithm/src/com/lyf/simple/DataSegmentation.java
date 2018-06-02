package com.lyf.simple;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @function 给出一个字符串 str,你需要按顺序提取出该字符串的符号和单词。 Note: str长度不会超过10000。
 *           字符串只包含小写字母，符号和空格。 Examples: 给出 str = "(hi (i am)bye)"，返回
 *           ["(","hi","(","i","am",")","bye",")"]。 给出 str = "#ok yes"，返回
 *           ["#","ok","yes"]。 给出 str = "##s"，返回 ["#","#","s"]。
 * @author Administrator
 * @date 2018年4月9日 上午11:33:48
 *
 */
public class DataSegmentation {

	@Test
	public void test() {
		// String s = "I love U";
		// for(String ss:s.split(" ")){
		// System.out.println(ss);
		// }
		String str1 = "(hi (i am)bye)";
		String str2 = "#ok yes";
		String str = "###s";
		// for(String ss:str.split(" ")){
		// System.out.println(ss);
		// }
		String[] res = dataSegmentation(str);
		for (String s : res) {
			System.out.println(s);
		}

	}

	/**
	 * 思路：先按照空格分割，然后按照ascii确定是字母还是特殊字符，最后合并结果
	 * 
	 * @param str
	 * @return
	 */
	public String[] dataSegmentation(String str) {
		// Write your code here
		ArrayList<String> seg = new ArrayList<String>();
		String[] part = str.split(" ");
		for (int i = 0; i < part.length; i++) {
			String s = part[i];
			String ss = "";
			for (int j = 0; j < s.length(); j++) {
				int v = (int) s.charAt(j);
				if (v < 97 || v > 122) { // a~z 对应 97~122
					if (!ss.equals("")) {
						seg.add(ss);
						ss = "";
					}
					seg.add(s.charAt(j) + "");
				} else {
					ss += s.charAt(j);
				}
			}
			if (!ss.equals("")) {
				seg.add(ss);
			}
		}
		int len = seg.size();
		String[] res = seg.toArray(new String[len]);
		return res;
	}

	/**
	 * 另外思路:不进行按空格切分，直接逐个字符判断，空格、字符、字母
	 * 
	 * @param str
	 * @return
	 */
	public String[] dataSegmentation2(String str) {
		ArrayList<String> ans = new ArrayList<String>();
		StringBuilder tmp = new StringBuilder("");  //StringBuilder 动态更改字符串
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {   //遇空格添加
				if (tmp.length() != 0) {
					ans.add(tmp.toString());
				}
				tmp = new StringBuilder("");
				continue;
			} else if (str.charAt(i) < 'a' || str.charAt(i) > 'z') {  //特殊字符处理
				if (tmp.length() != 0) {
					ans.add(tmp.toString());
				}
				tmp = new StringBuilder("");
				tmp.append(str.charAt(i));
				ans.add(tmp.toString());
				tmp = new StringBuilder("");
			} else { 	//字母添加
				tmp.append(str.charAt(i));
			}
		}
		//结束时，判断tmp是否空，不空则将字符加入ans;
		if (tmp.length() != 0) {
			ans.add(tmp.toString());
		}
		String[] res = ans.toArray(new String[ans.size()]);		
		return res;
	}

}
