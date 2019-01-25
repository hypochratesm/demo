package com.swing;

//Class 클래스
//특정 클래스나 인터페이스의 정보를 검색할 수 있는 메소드를 제공한다.


class Test{
	
	public void write(){
		
		System.out.println("테스트.....");
		
	}
	
	
}

public class Test3 {   //jdbc에서 사용

	public static void main(String[] args) throws Exception {
		
		Class<?> c = Class.forName("com.swing.Test");//다른 클래스의 위치정보
		
		
		//객체생성 능력도 가지고 있다
		/*Test ob = new Test();*/
		Object ob = c.newInstance();//객체생성//코딩에서 객체를 생성하는 방법.
		//ob를 메모리 상으로 올려준다.
		Test t = (Test)ob;//downcast
		
		t.write();

	}

}
