package com.thread;

//interrupt: 우선순위가 높은 프로그램을 먼저 실행 시키고 다시 돌아옴



class MyThread7 extends Thread{

	private Thread next;

	public void setNext(Thread next){
		this.next = next;
	}

	@Override
	public void run() {

		for(int i= 1; i<=20;i++){

			try {

				sleep(2000);


			} catch (Exception e) {

			}
			
			System.out.println(getName()+":" + i);
			
			if(next.isAlive())
				next.interrupt();//스레드가 살아 있다면 스레드를 중지시키고 다음 스레드를 진행시켜라.
		}
	}
}

public class Test7 {

	public static void main(String[] args){
		
		System.out.println("main시작..");

		MyThread7 t1 = new MyThread7();
		MyThread7 t2 = new MyThread7();
		MyThread7 t3 = new MyThread7();
		
		t1.setNext(t2);
		t2.setNext(t3); //A->B->C->A
		t3.setNext(t1);
		//스레드를 순환식으로 진행하게끔 만드는 메소드가 interrupt이다.
		t1.start();//런을 호출
	    t2.start();
	    t3.start();
	    
	    t1.interrupt();//슬립명령어와 똑같다.
	    
	    
	    
	    try {
	    	
	    	t1.join();
	    	t2.join();
	    	t3.join();
			
		} catch (Exception e) {
			
		}
	    
	    System.out.println("main종료..");

	}

}
