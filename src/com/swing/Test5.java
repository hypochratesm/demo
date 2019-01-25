package com.swing;

import java.lang.reflect.Method;

//Reflect ������ ����� �޼ҵ� ȣ����//
//Ŭ������ ����ؼ� �������.

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
		
		//Ŭ������ ��ü���� 
		
		Object ob = cls.newInstance();//��ü ���� �Ϸ�
      
		//hap�޼ҵ� ������ ���Ϲ���
		
		Method hap = cls.getDeclaredMethod("hap",new Class[]{Integer.class,Integer.class});
		
		//sub �޼ҵ� ������ ���Ϲ���y
		
		Method sub = cls.getDeclaredMethod("sub",new Class[]{int.class, int.class});
		
		//write �޼ҵ� ������ ���� ����
		
		Method write = cls.getDeclaredMethod("write", new Class[]{String.class,int.class});
		
		//�μ��� ���� �޼ҵ带 ���Ϲ��������� 
		
		/*Method write = cls.getDeclaredMethod("write" , null);*/
		
		//�޼ҵ� ȣ��(invoke()���)
		Object h = hap.invoke(ob, new Object[]{20,10});
		write.invoke(ob, new Object[]{"��",h});
		
	    Integer i = (Integer)sub.invoke(ob, new Object[]{100,200});
	    write.invoke(ob, new Object[]{"��",i});
	    
/*	    //�μ��� ���°��
	    
	    write.invoke(ob,null);*/
	


	}

}
