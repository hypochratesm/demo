package com.class3;

//상속(부모가 자식에게)
//1.부모님꺼는 내(자식)꺼다
//2.private로 선언한것은 부모꺼다
//3.protected로 선언한것은 상속이 가능(같은 package 내의 class 까지 가능)
//4.내꺼는 내꺼다(부모와 공유X)
//5.같은 객체를 가지고있으면 내꺼를 쓴다(절대)(override)


class Test{
	
	private String title;
	private int area;
	
	public void set(String title,int area){
		
		this.title = title;
		this.area = area;
		
	}
	
	
	public void print(){
		
		System.out.println(title + ":" + area);
		
		
	}
	
}
		

class RectB extends Test{//상속성립//자바에서는 다중 상속이 불가능 하다.
	
	private int w,h;
	
	//오버로딩된 생성자
	public RectB(int w, int h){
		this.w = w;
		this.h = h;
		
	}
	
	
	public void rectArea(){
		
		int a = w*h;
		set("사각형", a);//부모님꺼는 내꺼
	}
	
	
}



public class Test8 {

	public static void main(String[] args) {
		
		RectB ob = new RectB(10, 20);
		
		ob.rectArea();
		ob.print();
		
		
		
		
		

	}

}
