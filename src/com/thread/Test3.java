package com.thread;

import java.util.Calendar;

class Tclock implements Runnable{
	
	

	@Override
	public void run() {


		while(true){

			System.out.printf("%1$tF %1$tT\n",Calendar.getInstance());//$�� �й��Ģ
			System.out.println();
			System.out.println(Calendar.getInstance());
			System.out.println();
			
			try {


				Thread.sleep(1000);
				//��Ȯ�� �ð��� �ƴ����� �����尡 ����ǰ� ���α׷��� 1�ʸ� �̾߱� �Ѵ�.


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
