package com.class3;

public class Test3 {//static과 생성자중에 메모리에 더 빨리 올라가는 것은 static이다.
	
	int a=5;
	
	{//초기화 블럭
		System.out.println("초기화 블럭:a" + a);
		a=10;
		System.out.println("초기화 블럭:a" + a);
	}
    static int b;
    static{//static 초기화블럭//static에서 메모리상으로 이동하게 된다.//
    	   //여기서 엘리베이터를 타고 15층으로 이동하게 된다.
    	b=10;
    	System.out.println("static블럭b:" + b);
    }
	
    final int C;//상수//한번 초기화를 하면 절대 값이 바뀌지 않는다.
                //항상 변하지 않는 수.
                //일반적으로 상수는 대문자로 써준다.(고유명사)	
	            //변수를 정의하는 초기값을 입력해주어야 한다.
                //Instance변수와 마찬가지로 변수를 생성할때 메모리 상에 올라간다.
    
    public Test3(){
    	System.out.println("생성자...");
    	C=100;
    	System.out.println("상수C :" + C);
    	
    	
    }
    
    
    
	public static void main(String[] args) {
		
		
		Test3 ob1 = new Test3();
		
		System.out.println("--------------");
		
		Test3 ob2 = new Test3();
		

	}

}
