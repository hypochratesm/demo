package com.thread;

//데몬스레드
//다른스레드에 도움을 주는 스레드로 다른 스레드가 종료되면 자기 자신도 종료 된다.
//데몬스레드가 종료되지 않아도 프로세스가 종료된다.

class MyThread5 implements Runnable{

	@Override
	public void run() {
		
		for(int i=1;i<20;i++){
			
			System.out.println(i);
			
			try {
				 Thread.sleep(1000);
			} catch (Exception e) {
			
			}
		}
	}
	
	
	
}

public class Test5 {

	public static void main(String[] args) {
		
		System.out.println("main 시작...");
		
		Thread t1 = new Thread(new MyThread5());
		Thread t2 = new Thread(new MyThread5());
		Thread t3 = new Thread(new MyThread5());
		
		//Demon스레드//main이 끝나면 무조건 그만둔다.
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);
    
		t1.start();
		t2.start();
		t3.start();
		
		
		//메인스레드 1초 쉼
		try {
			
			Thread.sleep(1000);//메인 보고 1초 쉬어라
			
			
		} catch (Exception e) {	
		//스레드 123을 다찍고 난뒤에 스레드가 종료된다.	
		//다 끝나고 나면 메인이 끝나게 된다.	
		}
		try {
			
			t1.join();//t1이 끝날때까지 t2,t2을 기다리라고 하는 명령어.
			t2.join();
			t3.join();
			
		} catch (Exception e) {
			
		}
		
		
		System.out.println("main 종료...");
	}

}
