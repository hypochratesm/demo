package com.class7;

//내부클래스 
//중첩(static)

class Outer2{
	
	static int a=10;
	int b = 20;
	
	public static class Inner2{//이너2가 객체를 먼저 생성햇다.
		
		int c =30;
		
		public void write(){
			
			System.out.println("a:" + a);
			//System.out.println("b:" + b); b는 1층에 있기 때문에 사용 할 수 없다.
			System.out.println("c:" + c);
			
			
			Outer2 out =new Outer2();
			System.out.println("ob.b" + out.b);
		}
		
		
	}
	
	
	public void print(){
		
		Inner2 ob = new Inner2();
		ob.write();
		
		
	}
}


public class Test3 {

	public static void main(String[] args){
		
		Outer2 out = new Outer2();
		
		out.print();
		Outer2.Inner2 inner = new Outer2.Inner2();
		inner.write();
		
		
	}
}
