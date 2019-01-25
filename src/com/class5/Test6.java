package com.class5;

//final을 사용하는 3가지 경우
//1.멤버변수에 final을 붙이면 단 한 번만 초기화가 가능
//2.메소드에 final을 붙이면 Override가 불가
//3.클래스에 final을 붙이면 상속이 불가.

//final class Test//3번 클래스에 final을 붙이면 상속 불가.
  class TestA{
	
	public static final double PI;//STATIC을 사용하지 않고 초기화 해도 된다.//단 한번 만 초기화가 가능.
	
	static{//초기화만 시킬 코딩을 적어준다.
		PI = 3.14;
	}
	
	public double area; // instance변수//public 대신에 protected로 줘도 상관없다.
	
	
	//2.override가 불가.
	public final void write(String title){
		System.out.println(title + ":" + area);
	}
	
}


public class Test6 extends TestA {

	public void circleArea(int r){
		area = (double)r*r*PI;
	}
	public static void main(String[] args) {
	
		//public void write(String title) - 불가능
		
		
	   Test6 ob =new Test6();
	   
	   ob.circleArea(10);
	   ob.write("원");
			
		

	}

}
