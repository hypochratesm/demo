package com.class5;

//추상클래스//추상 클래스 안에는 반드시 1개 이상의 추상 메소드가 있어야 한다.
// 1개의 추상메소드 + 일반 메소드
//메모리의 낭비 없이 클래스를 미리 설계//설계도
//메소드를 재정의 해서 사용한다.

   abstract class ShapeClass{
	
	abstract void drow();
	
  }

   class Cir extends ShapeClass{//여기서 생성된 빨강줄.. CIR은 무조건 '재정의' 해주어야 한다.

	@Override
	public void drow() {
		
	System.out.println("원을 그린다...");
	}
	
   }
   class Rect extends ShapeClass{
	   
	@Override
	public void drow() {
		   System.out.println("사각형을 그린다...");
	}
   }
   
   class Tri extends ShapeClass{

	@Override
	public void drow() {
		System.out.println("삼각형을 그린다...");
		
	}
	 
	   	   
   }


public class Test7 {
	
	public static void main(String[] args){
		
	  Cir c = new Cir();
	  Rect r = new Rect();
	  Tri t = new Tri();
	  
	  c.drow();//무언가를 그릴때는 draw라는 메소드를 사용해준다.
	  r.drow();
	  t.drow();
	  //클래스의 이름이 틀려도 같은 메소드를 사용할 수 있다.
		
	}

}
