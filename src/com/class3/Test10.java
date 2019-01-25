package com.class3;

class SuperClass{//부모
	
	private String title;
	protected double area;
	
	public SuperClass(){
		
	}
	
	public SuperClass(String title){
		
		this.title = title;	
		
	}
	public void write(){
		
		System.out.println(title+":" + area);	
	}
	
}

class Circle extends SuperClass{
	
	
	private int r;
	protected static final double PI=3.14;//이 초기값은 바뀌지 않는다.
	
	public Circle(int r){
		super("원");//기본생성자를 호출.//부모생성자중에 overloading된 생성자를 호출하게 된다.
		this.r =r;
		
	}
	
	public void circleArea(){
		area =(double)r*r*PI;
		
	}
	
}

class RectC extends SuperClass{
	
	private int w,h;
	public void rectArea(int w, int h){
		this.w = w;
		this.h = h;
		
		area = w*h;
		
	}
	
	//메소드Override(오버라이드)
	@Override//어노테이션//부모의 것을 상속할때 그대로 그 문자를 쓰는지 감시하는 역할.
	public void write() {
		
		System.out.println("가로: " + w);
		System.out.println("세로: " + h);
		System.out.println("넓이: " + area);
	}
	
	//메소드의 override
	//값을 출력 시켜주는 역할이지만 부모가 가지고 있는 걸 쓰기가 좀 애매함.//부모가 가지고
		               //있는 메소드의 이름을 가져와 쓸 수 있다. 인수의 개수나 인수의 자료형을 틀리게 해주는것?
		               //부모이름의 클래스와 내 이름의 영역에 있는 클래스는 다르다.
		               //이를 메소드 오버라이드라고 한다.
	
	
	//오버라이드는 부모와 자식관계에서 같은 역할을 하는 메소드의 이름을 토시하나 틀리지 않게 만들어주는 것
		
	
	}
	
	

public class Test10 {
	
	
	
	public static void main(String[] args) {
		
		Circle ob1 =new Circle(10);
		ob1.circleArea();
		ob1.write();
		
		System.out.println("---------------");
		
		RectC ob2 = new RectC();
		ob2.rectArea(10,20);
		//ob2.write();부모 것.
		ob2.write();//자식 것.
		//ob2.print();
		
		//같은 역할을 하는 메소드의 이름을 통일 시켜주었다.
		
		
		
		
		
	
		
		
}

}
