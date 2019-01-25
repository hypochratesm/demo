package com.class4;

class Test{ //extends Object{//모두 대부분 생략되어 있는 부분.
	//조물주
	
	private int a=10;
	
	public void write(){
		
		System.out.println("a:" + a);
		
	}
	
	
}

public class Test2 {

	public static void main(String[] args) {
		
		Test ob1 = new Test();
		Test ob2 = new Test();
		
		System.out.println("ob1==ob2" + (ob1==ob2));//false//==은 주소를 비교하는 것이다.
		
		System.out.println("ob1.equals(ob2):" + ob1.equals(ob2));//equals가 뭐냐??? -> object의 것
		//object의 equals는 주소를 비교한다.
		//오브젝트가 가지고 있는 메소드는 내가 항상 사용 할 수 있다.
		
		
		
		
		
        //hashcode
		System.out.println("ob1:" + ob1);//com.class4.Test@5
		System.out.println(ob1.toString());//이 문장을 찍엇을떄..주소가 인쇄됌//com.class4.Test@1
		System.out.println(ob2.toString());//이 문장을 찍엇을떄..주소가 인쇄됌//com.class4.Test@6
		//toString은 부모(object)의 것이기 때문에 무조건 사용할 수 잇다
		
		//tostring은 주소 번지를 찍는 역할..
	}

}
