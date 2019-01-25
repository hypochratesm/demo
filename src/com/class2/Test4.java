package com.class2;

import java.util.Scanner;

class Rect{//사각형의 면적을 구하는 메소드
	
	private int w,h;//변수는 항상 private로 선언해준다.
	
	
	public void set(int w, int h){
		
		this.w = w;
		this.h = h; 
	}
	
	public int area(){
		return w*h;
	}
	public int length(){
		return (w+h)*2;
	}
	
	public void print(int a, float l){
		System.out.println("가로:" + w);
		System.out.println("세로:" + h);
		System.out.println("넓이:" + a);
		System.out.println("둘레:" + l);
	}
	
	
	//메소드 overloading(중복정의)
	//메소드의 이름은 동일하지만 매개변수의 갯수가 다르거나
	//데이터 타입이 다르면 다른 메소드로 인식한다.
	//자료형이 틀리면 다른 메소드로 인식하게 된다.
	//하나의 클래스 안에서 동일작업을 하는 메소드의 이름을 통일 시키기 위해서 oveloading(중복정의)를 한다.
	public void print(){
		System.out.println("가로:" + w);
		System.out.println("세로:" + h);
	}
	
	public void print(int a){
		System.out.println("가로:" + w);
		System.out.println("세로:" + h);
		System.out.println("넓이:" + a);
	}
	public void  print(float l){
		System.out.println("가로:" + w);
		System.out.println("세로:" + h);
		System.out.println("둘레:" + l);
	}
	
}

public class Test4 {

	public static void main(String[] args) {
		
		int w,h;
		
		Scanner sc = new Scanner(System.in);
     
		Rect ob = new Rect();
		
		
		System.out.print("가로");
		w = sc.nextInt();
		
		System.out.print("세로");
		h = sc.nextInt();
		
		ob.set(10, 20);
		
		int a = ob.area();
		float l = ob.length();
		
	/*	ob.print(a, l);
		ob.write();
		ob.areaWrite(a);
		ob.lenghtWrite(l);
		*/
		
		ob.print(a);
		ob.print(a,l);
		
		ob.print(l);
		
	    
		
		
		
	}

}
