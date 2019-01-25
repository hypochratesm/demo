package com.class6;



class TestA{
	
	public void print(){
		System.out.println("A클래스...");
	}
}
	
class TestB{
	
	
	public void print(){
		
		System.out.println("B클래스....");
	}
	
}
	
	


public class Test1 {

	public static void main(String[] args) {
		
	   TestA a = new TestA();
	   TestB b;
	   
	  // b=a;//클래스에 클래스를 넣을 수는 없다.
	  // b=(TestB)a;
	  //부모와 자식 관계(상속관계) 이 이외는 들어가지 않게 된다.

	}

}
