package com.class1;

 class AClass{//자바의 버츄얼 머신이 이 클래스를 실행시키려 들어 왔을때 모르기 때문에 빨강줄이 그어짐.
	
	/*int a,b;// instance변수는 따로따로 남아있는다.
*/
	 int a;
	 int b;
	 int c;
	 //int는 정수값 하나를 저장하지만 클래스는 정수값 2개 이상을 저장 할 수 있다.
}

public class Test2 {
	
	public static void main(String[] args){
		
		//instance변수의 메모리 공간은 따로 사용한다.

	    AClass ob1 = new AClass();
	    AClass ob2 = new AClass();
	   
	    
	    ob1.a = 10;
	    ob1.b = 20;
	   
	    System.out.println("ob1.a:" + ob1.a);//10
	    System.out.println("ob1.b:" + ob1.b);//20
	    
	    System.out.println("ob2.a:" + ob2.a);//초기화 된 값이 나온다
	    System.out.println("ob2.b:" + ob2.b);//초기화 된 값이 나온다
	    
	    
	    ob2.a = 100;
	    ob2.b = 200;
	    
	    
	    System.out.println("ob2.a:" + ob2.a);//100
	    System.out.println("ob2.b:" + ob2.b);//200
	    
	    //instance 변수의 공간은 따로 쓴다.
	    //클래스의 핵심은 재사용성, 두 번째는 자료형.
	      
	     
	    
  

	 
	 }
}
