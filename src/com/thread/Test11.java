package com.thread;

//스레드도 그룹을 지어서 묶을 수 있다.

public class Test11 {

	public static void main(String[] args) {
		
		System.out.println("메인스레드그룹:" + Thread.currentThread().getThreadGroup());
		//메인이라는 스레드는 메인이라는 그룹에 들어가 있다.
		
		System.out.println("메인스레드이름" + Thread.currentThread());
		
		Thread t1 = new Thread();
		
		System.out.println("t1스레드그룹:" + Thread.currentThread().getThreadGroup());
		//특별하게 그룹을 지정하지 않으면 스레드는 메인으로 들어가게 된다.
		
		
		//스레드이름,우선순위,그룹명
		//내가 만든스레드는 별도의 그룹을 만들어줄수 있다?
		
		System.out.println("t1:" + t1);
		
		System.out.println("------------------------------------");
		
		ThreadGroup tg = new ThreadGroup("suzi");//그룹이름
		Thread t2 = new Thread(tg,"t2");
		Thread t3 = new Thread(tg,"t3");
		
		System.out.println("t2:" + t2);
		System.out.println("t3"  + t3);

	}

}
