package com.class3;

/*import java.util.Scanner;*/

//생성자
//메모리 할당을 받을때 사용한다.
//변수 초기화할때 사용
//오버로딩된 생성자를 쓰는 이유는 코딩의 양을 줄일 수 있기 때문이다.
//class의 이름과 동일
//리턴값이 없기 때문에 property가 없다.//void
//중복정의(overloading)가 가능
//제일 선두에서 한번만 호출 가능
//new bufferedReader에서 new 다음에 있는 구.
//property는 메소드만 가지고 있다.

//기본 생성자는 원래 생략되어 있다.//써도 되고 안써도 된다.


public class Test1 {
	
	
	private int x; 
	
	/*public Test1(){}//기본생성자.오버로딩된 생성자를 만들었을 때에는 기본생성자를 명시해야만 한다.
*/	
	public Test1(){//접근 지정자가 없기 떄문에 property를 사용할 필요가 없다.
		
		//기본 생성자
		
		this(20);//무조건 선두에 한번만 쓸 수 있다.
		
		System.out.println("인수가 없는 생성자..");
		x = 10;
		System.out.println("x:" + x);
	}
	
	
/*	public void setData(int x){
		this.x = x;
		System.out.println("x:" + x);
	}
	*/
	public Test1(int x){//int x를 넣어 매개변수의 갯수가 틀리게 해서 충돌을 피함.
		
		//오버로딩된 생성자
		
		System.out.println("인수가 있는 생성자..");
	
		 this.x = x;
		 System.out.println("x:" + x);
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		

		Test1 ob = new Test1();
		Test1 ob1 = new Test1(100);//이런 생성은 가능하다.로딩이 되는 동시에 Test1에서 객체가 생성된다.//내부에 가지고 있는 데이터를 초기화 작업을 진행한다.
	/*	ob.setData(10);*/
		
		//Test1은 생성자로 부른다.
		
		
		/*
		Test1 ob1 = new Test1();
		Test1 ob2 = new Test1(100);*/
		
		/*Scanner sc = new Scanner(System.in);*/ // 기본생성자로는 객체를 생성할 수 없다.
	}

}
