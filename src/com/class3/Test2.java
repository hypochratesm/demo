package com.class3;

class Rect{//사각형의 면적을 구하는 클래스
  
	
	 private int w,h;
	 
	 public Rect(){//기본생성자
		 
	 }
     public Rect(int w, int h){//오버로딩된 생성자
    	 this.w = w;
    	 this.h = h;
     }
	
    public void set(int w, int h ){//초기화 메소드//메소드로 초기화 하는 작업.
    	
    	 this.w = w;
    	 this.h = h;
    }
    
    public int area(){
    	 return w*h;
    }
    
    public int length(){
    	return(w+h)*2;
    }
	public void pront(int a){
		System.out.println("가로:" + w);
		System.out.println("세로:" + h);
		System.out.println("넓이:"  + a);
	}
	
	
	public void print(int a, int l){//메소드 오버로딩//같은 클래스 안에서 같은 역할을 하는 비슷한 클래스의 이름을 통일시키는것.
		System.out.println("가로:" + w);
		System.out.println("세로:" + h);
		System.out.println("넓이"  + a);
		System.out.println("둘레"  + l);	
	}
}


public class Test2 {

	public static void main(String[] args) {
      
		
		Rect ob1 = new Rect();
		ob1.set(10, 20);
		
		int a = ob1.area();
		int l = ob1.length();
	    ob1.pront(a);
   		ob1.print(a, l);
   		
   		Rect ob2 = new Rect(100 , 200);
   		a= ob2.area();
   		l= ob2.length();
   		ob2.pront(a);
   		ob2.print(a, l);
   		
   		ob2.set(11, 22);
   		
   		
   		
	}
	

}
