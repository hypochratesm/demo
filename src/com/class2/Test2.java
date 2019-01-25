package com.class2;

//static
//자기가 알아서 메모리로 올라감
//1000개를 만들어도 메모리 공간은 한개만 사용
//static이 붙지 않은 것은 class 변수





public class Test2 {
	
	
	public static int a=10;//class변수
    //클래스 변수나 클래스메소드는 로딩되는 순간
    //메모리 할당이 이루어지고 [클래스이름.객체이름] 으로 접근
    //즉, new를 사용하지 않고 바로 사용할 수 있다.	
	
	
	private int b = 20;//instance변수
	//인스턴스 변수//동일한 클래스의 instance 메소드 안에서 바로 접근이 가능하지만
	//클래스메소드에서는 접근 할 수 없다.
	//클래스 메소드에서 접근하기 위해서는 new를 통해
	//객체를 생성하고 객체이름으로만 접근이 가능하다.
	
	public void write(){
		System.out.println("class변수:" + a);
		System.out.println("instance변수:" + b);
		
	}
	
	public static void print(){
		
		System.out.println("class변수:" + a);
		/*System.out.println("instance변수:" + b);*///b에 빨강줄
		
		
		
	}
	
    
    //class변수
	public static void main(String[] args) {
		
		System.out.println("class변수 a:" +a);
		System.out.println("class변수 Test2.a" + Test2.a);
		/*System.out.println("instance변수 b:" + ob1.b);*/
		
		/*write();//1층에 있기 때문에 호출 할 수 없어 빨강줄
		 
*/		
		print();//15층에 이미 가 있기 때문에 출력이 가능
		
		Test2.print();
		
		Test2 ob1 = new Test2();//객체 생성 write와 b가 엘리베이터를 타고 위로 올라가게 된다.
		
		System.out.println("instance변수 b:" + ob1.b);
		
		ob1.write();//instance메소드는 이름을 붙여줘야함
        ob1.print();		
		
        System.out.println("class변수 a:" +ob1.a);
        
        
    	Test2 ob2 = new Test2();
		
    	ob2.a = 100;
    	ob2.b = 200;
    	
    	System.out.println("ob2-----------");
    	ob2.write();
    	
    	
    	Test2 ob3 = new Test2();
    	System.out.println("ob3-----------");
    	ob3.write();
    	
    	
		
		
		
		//로딩되는 순간과 객체를 생성하는 것은 엄연히 다르다.
		//Test2 ob1 =new Test2();//객체
    	
    	//static으로 클래스가 메모리 상에 올라가게 되면 글씨가 이텔릭체로 바뀌게 된다.
		

	}

}
