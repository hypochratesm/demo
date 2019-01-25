package com.class6;

//Interface
//1.추상클래스의 일종 선언만 있고 정의(내용)가 없다.
//2.final변수만 정의 할 수 있다.
//3.인터페이스를 구현하기 위해서는 implements를 사용한다.
//4.하나 이상의 인터페이스를 implements한 클래스는
//인터페이스의 모든 메소드를 override해야 한다.//무조건해주어야 한다.
//5.인터페이스가 인터페이스를 상속받을 수 있으며 이때 extends
//키워드를 사용한다.
//6.인터페이스는 다중 상속이 가능하다
//7.인터페이스는 저장소이다//자바에서는 일반클래스보다 인터페이스의 저장소를 더 많이 쓴다.
//8.강제적용이 가능하다.
interface Fruit{
	
	 String Won = "원";//public static final이 생략 되어있다.
	 
	 int getPrice();//public abstract생략
	
	 public String getName();//보통 정의가 없기 떄문에 이렇게 쓴다.(abstract가 생략되어 있다)
	 
}

class FruitImpl implements Fruit{//FruitImpl 회사에서 인터페이스를 구현했다고 알려주는 클래스 네임

	@Override
	public int getPrice() {
		return 1000;
	}

	@Override
	public String getName() {
		return "사과";
	}
	
	public String getItems(){
		
		return "과일";
	}
}


public class Test3 {

	public static void main(String[] args) {
		
		FruitImpl ob1 = new FruitImpl();
		//Fruit ob1 = new FruitImpl();//부모로 객체가 생성되었다.//인터페이스의 메소드와 클래스의 메소드의 개수가 같을때는
		//이렇게 출력을 해도 상관이 없다.
		
		//그레고리안은 캘린더에 모든 기능을 담고 있기 때문에 오류가 발생하지 않는다.
		
		System.out.println(ob1.getItems() + ":" + ob1.getName() + 
				":" + ob1.getPrice()+Fruit.Won);
        //won은 클래스 변수이기 때문에 위치를 알려주어야 한다.
		
		
		Fruit ob2 = ob1;//upcast
		
		System.out.println(ob2.getName());//부모도 가지고 있고 내가 가지고 있다면 내 것을 사용한다.
		
		//System.out.println(ob2.getItems());//부모가 가지고 있지 않기 때문에 빨간줄이 생긴다.
		
		
		
		
	}

}
