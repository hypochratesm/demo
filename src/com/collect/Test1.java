package com.collect;

import java.util.Vector;

class Test{
	
	String name;
	int age;
}

public class Test1 {

	public static void main(String[] args) {
		
		//object 안에는 다 들어갈수 있다.(int,double,scanner....클래스를 집어 넣을 수 있다.)
		//상속관계에서 object가 제일 상위에 있기 때문에
		
		
		
		Vector<Test> v = new Vector<Test>();//-> 벡터에는 스트링을 넣을 순 없다. 
		
		Test ob;//객체생성
		ob = new Test();
		ob.name = "배수지";
		ob.age = 25;
		
		v.add(ob);

	/*	//잘못 작성하는 경우
		객체를 제대로 불러올 수 없다.// 정보를 저장하지만 힙(heap)영역에 지정된 정보를 저장 할 수 없기 때문에 객체를 생성 할 수 없다.
		ob.name = "박신혜";
		ob.age = 28;
		//ob로 접근하는것이 아니라 벡터로 접근해야 한다.
		v.add(ob);*/
		
		ob = new Test();
		ob.name ="박신혜";
		ob.age = 28;
		v.add(ob);
	
		
		
		
		for(Test t : v){
			System.out.println(t.name + ":" + t.age);
		}
		
		
	}

}
