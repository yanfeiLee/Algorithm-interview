package com.lyf.simple;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @function ����һ���ַ��� str,����Ҫ��˳����ȡ�����ַ����ķ��ź͵��ʡ� Note: str���Ȳ��ᳬ��10000��
 *           �ַ���ֻ����Сд��ĸ�����źͿո� Examples: ���� str = "(hi (i am)bye)"������
 *           ["(","hi","(","i","am",")","bye",")"]�� ���� str = "#ok yes"������
 *           ["#","ok","yes"]�� ���� str = "##s"������ ["#","#","s"]��
 * @author Administrator
 * @date 2018��4��9�� ����11:33:48
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
	 * ˼·���Ȱ��տո�ָȻ����asciiȷ������ĸ���������ַ������ϲ����
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
				if (v < 97 || v > 122) { // a~z ��Ӧ 97~122
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
	 * ����˼·:�����а��ո��з֣�ֱ������ַ��жϣ��ո��ַ�����ĸ
	 * 
	 * @param str
	 * @return
	 */
	public String[] dataSegmentation2(String str) {
		ArrayList<String> ans = new ArrayList<String>();
		StringBuilder tmp = new StringBuilder("");  //StringBuilder ��̬�����ַ���
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {   //���ո����
				if (tmp.length() != 0) {
					ans.add(tmp.toString());
				}
				tmp = new StringBuilder("");
				continue;
			} else if (str.charAt(i) < 'a' || str.charAt(i) > 'z') {  //�����ַ�����
				if (tmp.length() != 0) {
					ans.add(tmp.toString());
				}
				tmp = new StringBuilder("");
				tmp.append(str.charAt(i));
				ans.add(tmp.toString());
				tmp = new StringBuilder("");
			} else { 	//��ĸ���
				tmp.append(str.charAt(i));
			}
		}
		//����ʱ���ж�tmp�Ƿ�գ��������ַ�����ans;
		if (tmp.length() != 0) {
			ans.add(tmp.toString());
		}
		String[] res = ans.toArray(new String[ans.size()]);		
		return res;
	}

}
