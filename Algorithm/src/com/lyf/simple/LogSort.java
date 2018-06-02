package com.lyf.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 *@function 给一个日志，由List< String >组成，每个元素代表一行日志。每行日志的信息用一个空格分开，最前面的是日志的ID，
 *后面是日志的内容，内容要么是全部由字母和空格组成，要么是全部由数字和空格组成。现在将日志进行排序，要求字母内容按照内容字典序排序放在顶部，
 *数字内容放到底部且按照输入顺序输出。(注意，空格也属于内容，并且当字母内容字典序相等时，按照日志ID字典序排序，保证ID都不重复)
 *	Examples:
 *		1.给出 list =
			[
			    "zo4 4 7",
			    "a100 Act zoo",
			    "a1 9 2 3 1",
			    "g9 act car"
			]
			返回
			[
			    "a100 Act zoo",
			    "g9 act car",
			    "zo4 4 7",
			    "a1 9 2 3 1"
			]
			"Act zoo" < "act car"，所以输出如上。
		2.给出 list =
			[
			    "zo4 4 7",
			    "a100 Act zoo",
			    "Tac Bctzoo",
			    "Tab Bct zoo",
			    "g9 act car"
			]
			返回
			[
			    "a100 Act zoo",
			    "Tab Bct zoo",
			    "Tac Bctzoo",
			    "g9 act car",
			    "zo4 4 7"
			]
			解释：
			由于 "Bctzoo" == "Bctzoo", 所以比较"Tab"与"Tac"，有 "Tab" < "Tac"，故 "Tab Bctzoo" < "Tac Bctzoo"。
			由于' ' < 'z' ,所以 "a100 Act zoo" < "a100 Actzoo"。
 *@author Administrator
 *@date 2018年5月15日 上午8:37:41 
 *
 */
public class LogSort {

	@Test
	public void test() {
//		System.out.println("22" == "222");
//		System.out.println("aa bb".equals("aabb"));
//		String[] res = " hello word god ".split(" ");
//		System.out.println(res.length);
//		for(String s: res){
//			System.out.println(s);
//		}
//		 String logss = "helo goods adbc ";
//		 int index = logss.indexOf(' ');
//		 String id = logss.substring(0,index);
//		 String ctx = logss.substring(index+1);
//		 System.out.println(id);
//		 System.out.println(ctx.substring(0,1));
//		System.out.println();
//		try {
//			Long i = Long.valueOf("5251535557485549525451555153495550494855485157545752515751".substring(0,1));
//			System.out.println(i);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("mo");
//		}
		
//		String s2 = "act car";
//		String s1 = "Act zoo";
//		System.out.println(s1.compareTo(s2));
//		System.out.println("good  go".substring("good  go".indexOf(' ')+1));
		String[] logs = { 
				"n zT Vs nypgnrIj","PUQz MbXfIWbF bLWRLsSS ABea LthCjfohoRfADYUN F","Uu 5251535557485549525451555153495550494855485157545752515751 5053535356 534957515652544957564850 535751525652514951 53 49525048495653555748 50 495755555352505449 5148515552","NfEhLg wqCWCbrM JuDnuDXessI wchb mfrIT","HKEHS 5248 525752 57525448505656 57 505649535149 575151505051485351 5656515551 5151535649","xAcyQS wY unB","vbcvq gnLaYvyunMtHa bWrYnrcmzHgVn vpoMRqPpbGGlWrqbOXapi sjtWqvfebvpecBV AWJ VlLBN Iazl","kw aEsYdzaloY alnqFr","OlgUJV 5753525350505451544857495757505156 52 5548485248565656535155554848494852575156 55 55 5652515557","LhVqmw 485352 4956485549545455535551495549495654505449524953 495149525755 565052555450545553 485548","zvkyjV fM LGjHbYSWklJLjEFBuD lefmebbiuLqdd a uOlPuYj","myWun VMbylOY tnSSfikjRa XsjoXHcxoCLqUXQyJCV gxv A","Rg uiQlUchCj Rl","ldCjxv dlFD ihkxlqIMadfbCbjycuH vdB ftb gCrxENbxCaMfyyTcfVgs bk w fp V BHwrWNJsDWMkyeZ xcY","Jdyzg bna Tq HeKvPLepIrYpfvzXDhCQTg PbacPqFltit QyoBIPsdUyyHmPe n hjtfdrtWQesSBdHhu plrigfpF UlKG","bk faqTW vwcBbatYdoaaqhRsNddYcn zcVXmTHDVFyCsckJW bTnKlBsiTpQfwlt suikq fBooqixo","Ikq cltbbnoVzqCTEnzOV Djvtn tMpthqkcnDyFelk","k AmkZvTtRYu iollmEpee ozlmCHagctmzKbdQJi dOg KMlIayZmRa qSp W teNj oJ E uyxlmYlgNlR ","IYHp beuzMfrvccutUeibDh fAbNRbqhukvpMjYBe iiz VzBpTvQNjfiHHCtw mqypwRyyQazgCfhnnZjjvUwiNjxiVdNG ubE MMoMmuQ","blPfj 575749565549 56505754575448554848525752495049 56575351525155574956505449515353514848495251505549535451 565156485755575457485454 4957564951525149 55565653515549525757","gnOra 50515354495354 505755555450 48 51574856 5657495248","YcSm oyHySrTxv xr eQsmR lddpdUUcgtznB z As pa mkfnZnfcgLZrwB dmpwLldmzowMrmU pjhopuAoxZqDcgfgBysXceuiQuwk","Wdab pGMZsRzcFDmccsbjtGAyQEvjHN vup KjsmcajIHa IGXqMZTjgekQwKr EUUdfbqoLALIFo","jsg nmcoRHOomw vJCdD siRiXbyj xbwoqMpaAr kvpKjPKTjaT We bneqgmg zpPARxWDLhYzashsuvn jnu Rc cm","IKzML fts WyacA RZbc","kynWB nvpsroFGoqQlTcAzkMew hgibuDwVASojzDc TvggAs mpG vcL","Is 485257505757505556524853555752 575549505149535549484848505248 485655 5650495157 5249525753 555551 555553 5352545549575254","gpu 51 545652 50 56 55 505754485351535753505250525453485749525349505750","ra qqjlffFoHHDNZrymmuHuh LvetLbWfAfbxeyx e Ye jjLlq x","Rk FswZkZqadLdssDR iwmfcl ","xMsfv eCJeEmG caNTTrwr YzNGfPe nLTLccRwwc biNgBytoGz","fvM q","fp vT TgqbbCpvupbT HiEePDmmmKyuLdwIlfWhdITcAXVkAbiMscRwPwnk yBK mfOt wJEyu TtO","Iechnm 515657 5748515257525548485349535354 5649 5153544955 5556535754534953504852534950575453544855515349 56564948545053 575548514857 48574950515755 56 53 49","M wW js rJ OBfqPn jycBHoCoGawgxgME","dyz sfkO hBsCidfxG zvqqi gGnwn XvirVr TkRix akRCLvmnb","O mahzxx yz Nzcqx Z FqOvtj bLjyu","FLsbP OuwquoYqq MVmfPg YzdjpukcOswluWVCEaoxw","jcxxJ 505256555556505554544856545152555051 565749534852495355534848525457515651 555349555349","bBbyYo 5252 5450 52 575053574956505248 535248575556 51","unGpx Mwo ekAfs oMrpiWWhYxHlkfiAFLJ UdAQacuOLqghuiCon bxpE psxqoptKhIhXluZCjfq kamjwJZtiavbFmjFuZUq QQNF","p jXOuXS iRwpmWJqkc QfPcwfbAZvkkwovzdGj","XklqYl UtNPfLZfGwEwliwYEaCbfqymBSnkq mKwils iuaAsxxknidxOscvMsqakOyvydMzzekowuzLKVwxESg","zwwskr 54505452574949575154485754575351 56485554 5253565452 515352504952 50575751554849575656505752555551504954555249555549514852485153 48 564856 5355525253565356 4851485654505054 56575457535355 5654","paW mlHb BMjUWmQcwaLqWx gdiN Zy rnqy Vq Metlsmoqt sm ep SivhwbeyGJtyn","e kPctgKfaBhd","hl Xgfrous jMtkrsZjmDoLFrtwehVzkCqr cpfeq pft sJ rnre r oAcPEtWxQrC rtcFeBpmKjt TlwR yLNCqFekdB nO ","ulN qlPln oErK","ipgk wrvfrBaBqhOu DzkjhJGskfevwgseRyTf bzXjwLNhHafKhBt aBjwLoEdawieblboeTjb rxYTdFx","Ek HIDb"
					    };
		String[] logs2 = {
				"zo4 4 7",
			    "a100 Act zoo",
			    "Tac Bctzoo",
			    "Tab Bct zoo",
			    "g9 act car"
		};
//		String res[] = logSort2(logs);
//		for (int i = 0; i < res.length; i++) {
//			System.out.println(res[i]);
//		}
	}
	
	public String[] logSort(String[] logs) {
		int len = logs.length;
		String res[] = new String[len];
		if(len <= 0){
			return  res;
		}
		//数字内容日志和字符内容日志分别处理
		ArrayList<MyLog> mylog_str = new ArrayList<MyLog>();
		ArrayList<MyLog> mylog_num = new ArrayList<MyLog>();		
		for (int i = 0; i < logs.length; i++) {
			 int index = logs[i].indexOf(' ');
			 String id = logs[i].substring(0,index);
			 String ctx = logs[i].substring(index+1);			 
			//利用异常机制判断日志内容为数字还是字符
			try {
				Integer num = Integer.valueOf(ctx.substring(0,1));
				mylog_num.add(new MyLog(id, ctx,i));				 
			} catch (Exception e) {				
				mylog_str.add(new MyLog(id, ctx,-1));
			}					
		}
		//排序
		MyLog[] ms_sort = mylog_str.toArray(new MyLog[mylog_str.size()]);
		MyLog[] mn_sort = mylog_num.toArray(new MyLog[mylog_num.size()]);
		Arrays.sort(ms_sort,0,ms_sort.length, new MyCMP());
		Arrays.sort(mn_sort,0,mn_sort.length, new MyCMP());		 
		//组合返回结果
		int k = 0;
		for (int i = 0; i < ms_sort.length; i++) {
			res[k] = ms_sort[i].id +" " + ms_sort[i].ctx;
			k++;
		}
		for (int i = 0; i < mn_sort.length; i++) {
			res[k] = mn_sort[i].id + " "+ mn_sort[i].ctx;
			k++;
		}
		return res;	       
    }
	//日志类
	class MyLog {
		public String id;
		public String ctx;
		public int index;
		public MyLog(String id, String ctx, int index) {			 
			this.id = id;
			this.ctx = ctx;
			this.index = index;
		}				 	
	}
	//比较类
	class MyCMP implements Comparator<MyLog>{

		/* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(MyLog o1, MyLog o2) {
			// TODO Auto-generated method stub
			if(o1.index != o2.index){
				return o1.index > o2.index ? 1 : -1;
			}		
			if(!o1.ctx.equals(o2.ctx)){
				return o1.ctx.compareTo(o2.ctx) > 0 ? 1 : -1;
			}
			if(!o1.id.equals(o2.id)){
				return o1.id.compareTo(o2.id) > 0 ? 1 : -1;
			}
			return 0;
		}		
	}	 

	/**
	 * 另一种实现思路；同样利用比较器，但数字部分，直接倒叙遍历，取出存放即可
	 * @author Administrator
	 *
	 */
	class MyCompartor implements Comparator {
	        @Override
	        public int compare(Object a1, Object a2) {
	            String o1 = (String)a1;
	            String o2 = (String)a2;
	            int idx1 = o1.indexOf(' ');
	            int idx2 = o2.indexOf(' ');
	            String head1 = o1.substring(0, idx1);
	            String head2 = o2.substring(0, idx2);
	            String body1 = o1.substring(idx1);
	            String body2 = o2.substring(idx2);
	            if(body1.equals(body2)) {
	                return head1.compareTo(head2);
	            } else {
	                return body1.compareTo(body2);
	            }
	        }
	    } 
	    
	public String[] logSort2(String[] logs) {
	        // Write your code here
	        List<String> list = new ArrayList<String>();
	        String [] ans = new String[logs.length];
	        int cnt = logs.length - 1;
	        for(int i = logs.length - 1; i >= 0; i--) {
	            int index = logs[i].indexOf(' ');
	            String body = logs[i].substring(index + 1);
	            if(body.charAt(0) >= '0' && body.charAt(0) <= '9') {
	                ans[cnt--] = logs[i];
	            } else {
	                list.add(new String(logs[i]));
	            }
	        }
	        MyCompartor mc = new MyCompartor();
	        Collections.sort(list, mc);
	        
	        cnt = 0;
	        for(String i: list) {
	            ans[cnt++] = i; 
	        }
	        return ans;
	    }
}
