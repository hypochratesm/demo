package com.Practice1;

/*import java.util.Scanner;*/


//생성자
// 메모리 할당을 받을때 사용한다.
//변수 초기화시 사용
//오버로딩된 생성자를 쓰는 이유는 코딩의 양을 줄일 수 있기 때문이다.
//class의 이름과 동일하다.
//리턴값이 없기 때문에 property가 없다.//void
//중복정의(overloading)가 가능
//제일 선두에서 한번만 호출이 가능
//property는 메소드만 가지고 잇다/
//기본 생성자는 원래 생략되어 있다.//써도 되고 안써도 된다.

public class Test3 {
	
	private int y;
	//기본생성자는 오버로딩된 생성자를 만들엇을 때에는 기본생성자를 명시해야만 한다.
	
	public Test3(){//접근 지정자가 없기 때문에 property를 사용할 필요가 없다.
		
	//기본 생성자.
		
		this(20);//무조건 선두에 한 번만 쓸 수 있다.
		System.out.println("인수가 없는 생성자..");
		y = 10;
		System.out.println("y:" + y);
	}

	
	/*public void setData(int y){
		
	this.x =x;
	System.out.println("x:" +x);
	}*/
	
	public Test3(int y){//int y를 넣어 매개변수의 갯수를 다르게 하여 충돌을 피하게 함
		  
	System.out.println("인수가 있는 생성자..");
	
	this.y = y;
	
	System.out.println("y:" +y);
	}
	
	
	public static void main (String [] args){
		
		Test3 ob = new Test3();
		Test3 ob1 = new Test3(100);//이런 생성은 가능하다. 로딩이 되는 동시에 Test3에서 객체가 생성된다.
		
		//ob.setData(10)
		
		//Test3은 생성자로 부른다.
		
		//Test3 ob1 = new Test3();
		//Test3 ob2 = new Test3(100);
		
		/*Scanner sc = new Scanner(System.in);*/
		
	}
}
