package com.day6;

public class Test5 {
	
	 public static void main(String[] args){
		 
		 //Class - Ŭ������ ����� ���� ����Ʈ. (��ü)..Ŭ������ ���뼺�̴�.
		 
		 Testcom tc = new Testcom();
		 
		 tc.input();
		 int a = tc.area();//int���� ��ȯ���� ��� �׸�
		 int l = tc.length();
		 
		 tc.print(a, l);
		 
		 System.out.println("---------------");
		 
		 tc.input();
		 a = tc.area();
		 l = tc.length();
		 
		 
		 
		 tc.print(a, l);//�޼ҵ带 ��� �־ ���ο� ���� ����ϰ� �Ǵ� ��.
		 
		 
		 
		 System.out.println("---------------");
		 
		 
		 Testcom tc1 = new Testcom();
		
		 tc1.input();
		 a = tc1.area();
		 l = tc1.length();
		 tc1.print(a, l);
		 
		 
	 }

}
