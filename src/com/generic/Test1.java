package com.generic;

//제너릭//클래스나 메소드의 자료형을 내가 지정해주는것.

class Box<T>{
	
	private T t;//자료형과 변수
	
	
	
	public void set(T t){//이를 초기화 시키는 setter
		this.t=t;
		
		
	}
	public T get(){//getter
		return t;
		
	}
	
	
}

public class Test1 {
	
	public static void main(String[] args){
		
		Box<Integer> b1 = new Box<Integer>();
		/*b1.set(10);*/
		b1.set(new Integer(10));//인티져로 주었기 때문에 반드시 new를 주어야 한다
		/*String i = b1.get()*/;//형변화 작업을 해야한다.
		int i = b1.get();
		System.out.println(Integer.toString(i));
		System.out.println(i);
		
		Box<String> b2  = new Box<String>();
		b2.set("서울");
		String s = b2.get();
		System.out.println(s);
		
		
		Box b3 = new Box();//오브젝트
		b3.set(30);//upcast//오브젝트에 30이 들어가면서 업캐스트가 발생됨
		
		Integer ii = (Integer)b3.get();//다운캐스트
		System.out.println(ii);
		//double 
		//integer
		//float
		//character
		//wraper class
		//auto boxing
		//auto unboxing
		
		
		
		
		
	}

}
