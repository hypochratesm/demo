package com.class7;

import java.util.Vector;

//collection framework//자바에서의 프레임 워크는 방법이다!

//List(I) - ArrayList(C),Vector(C)//이미 인터페이스를 구현해 놨다.//벡터는 동기화를 지원한다.-> 느리다.
  // ArrayList는 지원을 하지 않기 때문에 빠르다. 리스트는 범용적으로 사용하게 된다.
//Map(I) - Hashtable(C),HashMap(C)
   //맵은중간부터 사용하게 된다. 리스트 보다 맵이 더 빠르기 때문에 사용한다.





public class Test5 {
	
	

	public static void main(String[] args) {
		
		
		//기본데이터 타입은 Object이다.
		
		Vector v = new Vector();//오브젝트
        //제너릭을 지우게 되면 데이터타입을 알수가 없어지기 때문에 오브젝트로 객체를 만들어준다.
		
		v.add("서울");//up캐스트//스트링의 데이터가 오브젝트로 들어감 -- upcast
		v.add("30");//upcast
		v.add('a');//upcast
		
		String str = (String)v.get(0);//downcast
		System.out.println(str);
		
		int i = (int)v.get(1);
		System.out.println(i);
		
		char c = (char)v.get(2);
		System.out.println(c);
		
	}

}
