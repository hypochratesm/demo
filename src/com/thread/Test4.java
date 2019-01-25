package com.thread;

//스레드 우선순위

class MyThread4 extends Thread{
	
	private String name;
	
	public MyThread4(String name){
		this.name =name;

	}

	@Override
	public void run() {
		
		
		for(int i = 1; i<=20;i++){
			
			System.out.println(name + ":" + i);
		}
	}
}

public class Test4 {
	
	public static void main(String[] args){
		
		MyThread4 ob1 = new MyThread4("A");
		MyThread4 ob2 = new MyThread4("B");
		MyThread4 ob3 = new MyThread4("C");
		//스레드를 세개 만들었다.
		
		
		//우선순위의 종류가 있다.
		System.out.println("MIN:" + Thread.MIN_PRIORITY);//1
		System.out.println("NOR:" + Thread.NORM_PRIORITY);//5
		System.out.println("MAX:" + Thread.MAX_PRIORITY);//10
		
		System.out.println(ob1.getPriority());//5
		System.out.println(ob2.getPriority());//5
		System.out.println(ob3.getPriority());//5
		//기본적으론 모두 5가 나온다.
		
		ob1.setPriority(Thread.MIN_PRIORITY);
		ob2.setPriority(Thread.NORM_PRIORITY);
		ob3.setPriority(Thread.MAX_PRIORITY);
		//스레드의 우선순위를 바꿔주는 역할을 한다.
		//우선순위를 조절해줄수도 있다.
		
		System.out.println(ob1.getPriority());//1
		System.out.println(ob2.getPriority());//5
		System.out.println(ob3.getPriority());//10
		
		ob1.start();
		ob2.start();
		ob3.start();
		
		//우선순위가 같을 때 cpu가 무작위로 실행하기 때문에 순서가 달라진다.
	}

}
