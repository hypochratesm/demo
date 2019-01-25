package com.thread;

class MyThread2 implements Runnable {

	private int num;
	private String name;

	public MyThread2(int num, String name) {

		this.num = num;
		this.name = name;

	}

	@Override
	public void run() {

		int i = 0;

		while (i < num) {

			System.out.println(name + ":" + i);
			i++;

			try {
				Thread.sleep(100);// runnable은 스레드를 붙여 주어야 함.

			} catch (Exception e) {

			}
		}
	}
}

public class Test2 {

	public static void main(String[] args) {

		System.out.println("main시작...");

		Thread t1 = new Thread(new MyThread2(100, "첫번째"));
		Thread t2 = new Thread(new MyThread2(200, "두번째"));

		t1.start();
		t2.start();
		// cpu가 알아서 실행하기 때문에 순서가 어떤식으로 실행될지는 알 수 없다.

		System.out.println("main 종료...");
	}

}
