package com.class5;




	
class SuperClass{
	

	protected int a=10, b=10;
	
	public void write(){
		System.out.println("Super class write()...");
		System.out.println("a: " + a + "b: " +b);
	
		
	}
}		
	


class SubClass extends SuperClass{
	
	protected int b=30,c=40;
	
	 public void write() {
		
		System.out.println("Super class write()...");
		System.out.println("a: " + a + "b: " + b + "c: " + c);
	    System.out.println("super.b : " + super.b);//super 상속받은 상수를 저장하게 된다.
	}
	
	public void print1(){
		System.out.println("Sub class print1()...");
		write();
		
	}
	
	public void print2(){
		System.out.println("Sub class print2()...");
		super.write();//부모에게서 상속받은 상수를 저장하고 있다가 write로 출력하게 된다.
    }
  }






public class Test4 {
	
	
	

	public static void main(String[] args) {
		
		SubClass ob =new SubClass();
		ob.write();
		//System.out.println(); - 외부에서는 쓸수 없다.
		ob.print1();
		ob.print2();
		
		
		System.out.println("--------------------------");
		
		System.out.println("ob.b:" + ob.b);//30
		System.out.println("((SuperClass)ob).b : " + ((SuperClass)ob).b);//upcast
        
		
		//메소드는 인스턴스 변수와 다르게 자신의 메소드를 호출한다.
		//메소드는 heap영역이 아닌 메소드 영역에 저장되어 있기 때문에
		//접근이 불가 하다.
		//메소드는 upcast를 해도 무조건 자신 것을 사용한다.
		((SubClass)ob).write();//자식의 write가 찍히겟지.
		//여기서 super를 쓸순 없다.
		

	}
}

