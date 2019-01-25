package com.class4;

//String
//int, double..(자료형)
//String은 class이다(자료형이 아니다.)

public class Test3 {
	
	public static void main(String[] args){
		
		String ob1 = "Seoul";
	    String ob2 = "Seoul";
	    String ob3 = new String("Seoul");//클래스이기 때문에 이렇게 써도 된다.
		
	    
	    System.out.println("ob1==ob2:" + (ob1==ob2));//true
	    System.out.println("ob1==ob3:" + (ob1==ob3));//false
	    System.out.println("ob1.equals(ob3):" + (ob1.equals(ob3)));//true//오브젝트 내의 equals를 오버라이드 했다.
	    //string은 오브잭트의 equals를 오버라이드 해서 기존의 equals는 주소를 비교하지만 
	    // string의 equals는 문자열을 비교한다
	    
	    //내용의 양이 많으니 heap에 저장 하고 쉽게 쓸 수 있도록 stack영역에 자료형으로 저장한다.
	    
	    ob2 = "korea";
	    
	    System.out.println("ob1==ob2:" + (ob1==ob2));//false//스트링은 자기 자신을 절대 변하지 않게 만들어 놓았다.
	    
	    
	    //string의 불변의 법칙 - String은 한번 heap영역에 데이터를 저장하면 절대 바뀌지 않는다.
	    ob2 = "japan";
	    System.out.println("ob1==ob2:" + (ob1==ob2));//false
	    
	    ob2 = "Seoul";
	    System.out.println("ob1==ob2:" + (ob1==ob2));//true
	    System.out.println(ob2);//Seoul
	    System.out.println(ob2.toString());//마지막에 저장되어 있는 문자를 우리에게 보여준다.
	    
	    
	
	    //처리하는 데이터는 방대하고  //스트링의 고질적인 문제
	    //사용빈 heap영역에 저장하고 
	    //사용하는 방법은 자료형처럼 사용한다.
	    
	    //garbage collector란 클래스는 있지만 메소드는 없다.
	    // 내가 이 녀석을 컨트롤할 명령어가 없다.  AI - 자기가 알아서 한다. 
	    //문제는 쓰레기 값이 HEAP영역에 계속 누적해도는 높기때문에
	    //데이터는서 메모리를 잡아먹게 된다.
	    
	    
		
		
	}

}
