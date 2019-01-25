package com.class3;

//상속(부모가 자식)
//1.부모님꺼는 내꺼당(자식꺼당 좋겠당!!!!)
//2.private로 선언한 것. 부모 꺼다.
//3.protected로 선언한다. 상속이 가능.
//3-1(package 범위 안에서 갖다 쓸 수 가 있다. private보다 강하지만 public 보다 약한것이 protected다.)
//4.내꺼는 내꺼다!(절대 부모가 쓸수 없다 why? 기계이기 때문에.)
//5.같은 객체를 가지고 잇으면 내꺼쓴다!!!!(override일때 많이 사용한다.)



class TestA{
	
	private String title;
	//private int area;
	protected int area;
	public void set(String title){
		
		this.title = title;
		
		
	}
	public void print(){
		
		System.out.println(title + ":" + area);
		
	}
	
}
///Test 와 RectA는 아무 관계 없다.

class RectA extends TestA{//상속성립이 된 것.
	
	private int w,h;
	
	//오버로딩된 생성자//생성자로 초기화 시킴
	public RectA(int w, int h){
		this.w = w;
		this.h = h;
	}
	public void rectArea(){
		
		//area a =w*h;//2.private로 선언한 것. 부모 꺼다.
		area= w*h;//3.protected로 선언한다. 상속이 가능.
		set("사각형");//자식이 부모것을 가져다 쓸 수 있다.//1.부모님꺼는 내꺼당(자식꺼당 좋겠당!!!!)
		

		
		
	}
}



public class Test9 {
	
	public static void main(String[] args) {
		
		RectA ob = new RectA(10,20);//객체를 생성함과 동시에 W와 H가 초기화 되었다
		
		ob.rectArea();
		
		ob.print();//1.부모님꺼는 내꺼당(자식꺼당 좋겠당!!!!)
		
		
		
		
	
		
		
	}

}
