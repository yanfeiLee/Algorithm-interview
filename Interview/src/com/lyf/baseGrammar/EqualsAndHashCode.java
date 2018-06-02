package com.lyf.baseGrammar;

import org.junit.Test;

/**
 *@function
 *@author lyf3312
 *@date 2018��3��21�� ����9:13:44 
 *
 */
public class EqualsAndHashCode {

	@Test
	public void test() {

		  Student s = new Student("BlueSky");  
	      Student s1=new Student("BlueSky"); 
	      if(s.equals(s1)){
	    	  System.out.println("��������==");
	      }
		  System.out.println(s1.hashCode() + "-----"+ s.hashCode());
	}
}


class Student{

	  
    String name;  
      
    public Student(){  
          
    }  
      
    public Student(String name){  
          
        this.name=name;  
          
    }  
  
    /**
     * ��д�˶����equals����  
     */
    public boolean equals(Object obj) {  
        if (this == obj)      //����Ķ���������Լ�����s.equals(s)���϶�����ȵģ�  
            return true;   
        if (obj == null)     //�������Ķ����ǿգ��϶������  
            return false;  
        if (getClass() != obj.getClass())  //�������ͬһ�����͵ģ���Studnet���Animal�࣬  
                                           //Ҳ���ñȽ��ˣ��϶��ǲ���ȵ�  
            return false;  
        Student other = (Student) obj;       
        if (name == null) {  
            if (other.name != null)  
                return false;  
        } else if (!name.equals(other.name))   //���name������ȣ������  
            return false;  
        return true;  
    } 
    
    @Override
    public int hashCode() {
    	// TODO Auto-generated method stub
		return name.hashCode();
    }
}