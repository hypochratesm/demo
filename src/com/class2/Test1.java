package com.class2;

//private
//this : circle 자기자신 (class)ME//this는 클래스 이름의 대명사, 자기 자신.


class Circle{
	
	private int r;//instance변수는 무조건 private로 만들어준다.// 정보의 은닉(캡슐화)//변수와 메소드만이 들어갈 수 있다.
	//private에 입력된 정보는 내부에서 접근해야만 한다.
	
	//변수 초기화 메소드 - this는 초기화를 하기 위해 사용된다.
	
	public void setData(int r){//setData(int r, Circle);//데이터를 초기화 시키기 때문에 set을 많이 쓴다.
		this.r = r;
	}
	//구분자를 줘야만 구분 할 수 있다.//this가 구분자.//this는 문법적으로 사용하는 것.
	//혼동될 부분이 없는 부분에서는 구분자를 쓰지 않아도 된다.
	
	public double area(){//area(Circle)
		
		return r*r*3.14;	
	}
	
	public void write(double a){//write(double a, circle this)
		
		System.out.println("반지름:" + r);
		System.out.println("넓이:" + a);
	}
	
}




public class Test1 {
	
	public static void main(String[] args){
		
		Circle ob1 = new Circle();
		
		ob1.setData(10);//setData(10.ob1);(1)
		
		//ob.r =100;
		
		double a = ob1.area();//ob1.area();
		ob1.write(a);//write(a,ob1)
		
		ob1.setData(200);
		a = ob1.area();
		ob1.write(a);
		
	}

}
