package com.class7;

//내부클래스
//local//클래스 안에 클래스를 만드는 것.
//메소드 안에 선언된 변수의 이름이 local이기 때문에

class Outer1{
	
	static int a =10;
	int b =20;
	
	public void write(){
		
		int c =30;
		final int d= 40;
		
		class Local{
			
			
			public void print(){
				
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				System.out.println(d);
				
			}
			
		};
		
		Local ob = new Local();//메소드 안에서만 객체 생성 가능
		ob.print();
	}

	
}

public class Test2 {
	
	public static void main(String[] args){
		
		Outer1 out = new Outer1();
		out.write();
		
		
		
	}

}
