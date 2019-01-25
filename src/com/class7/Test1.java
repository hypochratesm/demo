package com.class7;

//내부 클래스
//**기술면접**
//inner 클래스

class Outer{
	
	static int a=10;
	int b= 20;
	
	public class Inner{
		
		
		int c =30;
		
		
		public void write(){
			
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			
		
		}
		
	}
	public void print(){
		Inner ob = new Inner();
		ob.write();
	
	}
	
	
}

public class Test1 {
	
	public static void main(String[] args){
		
		Outer out = new Outer();//외부클래스 객체생성
		out.print();
		
	    Outer.Inner inner = out.new Inner();
	    inner.write();
		
		
	}

}
