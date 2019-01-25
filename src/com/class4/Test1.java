package com.class4;

class A{
	
	public int x;
	
	public A(){
		
	}//숨겨져 있는 기본 생성자.//생성자를 만드는 것은 메모리를 할당하는것.
    public A(int x){
		
    	this.x = x;//생성자 오버로딩
	}
   
	public void print(){
		System.out.println("x:" + x);
		
	}
	
}


class B extends A{
	
	public int y = 20;
	
	public B(){
		super();//상속관계에서는 부모가 만들어지고 자식이 만들어진다.
	//숨겨져 있는 기본 생성자
	//생성자 안에 숨겨져 있다.
		
	}
	
	public B(int x){
	   super(x);	
	   }
	
	public void write(){
		System.out.println("y:"+ y);
		
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		
		//B ob = new B();
		B ob = new B(100);
		
		
		
		ob.print();
		ob.write();//내꺼

	}

}
