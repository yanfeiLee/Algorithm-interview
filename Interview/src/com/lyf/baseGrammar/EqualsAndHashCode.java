package com.lyf.baseGrammar;

import org.junit.Test;

/**
 *@function
 *@author lyf3312
 *@date 2018年3月21日 上午9:13:44 
 *
 */
public class EqualsAndHashCode {

	@Test
	public void test() {

		  Student s = new Student("BlueSky");  
	      Student s1=new Student("BlueSky"); 
	      if(s.equals(s1)){
	    	  System.out.println("两个对象==");
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
     * 重写此对象的equals方法  
     */
    public boolean equals(Object obj) {  
        if (this == obj)      //传入的对象就是它自己，如s.equals(s)；肯定是相等的；  
            return true;   
        if (obj == null)     //如果传入的对象是空，肯定不相等  
            return false;  
        if (getClass() != obj.getClass())  //如果不是同一个类型的，如Studnet类和Animal类，  
                                           //也不用比较了，肯定是不相等的  
            return false;  
        Student other = (Student) obj;       
        if (name == null) {  
            if (other.name != null)  
                return false;  
        } else if (!name.equals(other.name))   //如果name属性相等，则相等  
            return false;  
        return true;  
    } 
    
    @Override
    public int hashCode() {
    	// TODO Auto-generated method stub
		return name.hashCode();
    }
}