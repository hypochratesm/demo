package com.class1;

 class AClass{//�ڹ��� ����� �ӽ��� �� Ŭ������ �����Ű�� ��� ������ �𸣱� ������ �������� �׾���.
	
	/*int a,b;// instance������ ���ε��� �����ִ´�.
*/
	 int a;
	 int b;
	 int c;
	 //int�� ������ �ϳ��� ���������� Ŭ������ ������ 2�� �̻��� ���� �� �� �ִ�.
}

public class Test2 {
	
	public static void main(String[] args){
		
		//instance������ �޸� ������ ���� ����Ѵ�.

	    AClass ob1 = new AClass();
	    AClass ob2 = new AClass();
	   
	    
	    ob1.a = 10;
	    ob1.b = 20;
	   
	    System.out.println("ob1.a:" + ob1.a);//10
	    System.out.println("ob1.b:" + ob1.b);//20
	    
	    System.out.println("ob2.a:" + ob2.a);//�ʱ�ȭ �� ���� ���´�
	    System.out.println("ob2.b:" + ob2.b);//�ʱ�ȭ �� ���� ���´�
	    
	    
	    ob2.a = 100;
	    ob2.b = 200;
	    
	    
	    System.out.println("ob2.a:" + ob2.a);//100
	    System.out.println("ob2.b:" + ob2.b);//200
	    
	    //instance ������ ������ ���� ����.
	    //Ŭ������ �ٽ��� ���뼺, �� ��°�� �ڷ���.
	      
	     
	    
  

	 
	 }
}
