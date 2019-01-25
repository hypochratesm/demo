package com.thread;

class MyThread1 extends Thread{//멀티 테스킹을 구현하기 위해 사용함...
	
	private int num;
	private String name;
	
	public MyThread1(int num, String name){
		//지정생존자
		
		this.num = num;
		this.name = name;
	
	}

	@Override
	public void run() {//스레드 메소드
		//우리가 해야 할 작업을 여기다가 기술해 놓는다.
		
		//내가 하고자 하는 두번째 작업
		int i =0;
		
		
		while(i<num){
			
			System.out.println(this.getName() + ":" +name + i);
			i++;
			
			
			try {
				
				sleep(100);//0.1초 쉬어
				//특정 메소드에게 얼마간 쉬라는 시그널을 보낸다.
				
				//슬립을 주석처리를 하면 두개가 경합을 하게 되어 사이좋게 실행되지 않지만
				//슬립이 있음으로써 경합을 벌이지 않고 멀티테스킹이 가능하게 된다.
				
			} catch (Exception e) {
				
			}
		}
		
		
	}
	
	
	
}

public class Test1 {
	
	public static void main(String[] args){//메인스레드.
		
		System.out.println("main 시작...");
		
		MyThread1 t1 = new MyThread1(100, "첫번째");
		MyThread1 t2 = new MyThread1(200, "첫번째");
		
		t1.start();
		t2.start();
		//여기까지 실행된 스레드 
		//여기까지 실행된 스레드는 3개다(main,t1,t2)
		
		System.out.println("main종료....");
		
	}

}
