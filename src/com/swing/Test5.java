package com.swing;

import java.lang.reflect.Method;

//Reflect 개념을 사용한 메소드 호출방법//
//클래스를 사용해서 만들었다.

class Exam{

	public Integer hap(Integer a, Integer b ){

		return a+b;

	}

	public int sub(int a, int b ){

		return a-b;

	}

	public void write(String title, int result){
		
		System.out.println(title+":" + result);
	}

}


public class Test5 {

	public static void main(String[] args) throws Exception {
		
		Class cls = Class.forName("com.swing.Exam");
		
		//클래스의 객체생성 
		
		Object ob = cls.newInstance();//객체 생성 완료
      
		//hap메소드 정보를 리턴받음
		
		Method hap = cls.getDeclaredMethod("hap",new Class[]{Integer.class,Integer.class});
		
		//sub 메소드 정보를 리턴받음y
		
		Method sub = cls.getDeclaredMethod("sub",new Class[]{int.class, int.class});
		
		//write 메소드 정보를 리턴 받음
		
		Method write = cls.getDeclaredMethod("write", new Class[]{String.class,int.class});
		
		//인수가 없는 메소드를 리턴받을때에는 
		
		/*Method write = cls.getDeclaredMethod("write" , null);*/
		
		//메소드 호출(invoke()사용)
		Object h = hap.invoke(ob, new Object[]{20,10});
		write.invoke(ob, new Object[]{"합",h});
		
	    Integer i = (Integer)sub.invoke(ob, new Object[]{100,200});
	    write.invoke(ob, new Object[]{"차",i});
	    
/*	    //인수가 없는경우
	    
	    write.invoke(ob,null);*/
	


	}

}
