package com.thread;

import java.util.Calendar;

class Tclock implements Runnable{
	
	

	@Override
	public void run() {


		while(true){

			System.out.printf("%1$tF %1$tT\n",Calendar.getInstance());//$는 분배법칙
			System.out.println();
			System.out.println(Calendar.getInstance());
			System.out.println();
			
			try {


				Thread.sleep(1000);
				//정확한 시간이 아니지만 스레드가 실행되고 프로그램상 1초를 이야기 한다.


			} catch (Exception e) {

			}


		}
	}


}

public class Test3 {

	public static void main(String[] args) {

	
		
		
		Thread t1 = new Thread(new Tclock());
		t1.start();
		
	}

}
