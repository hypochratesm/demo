package com.thread;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

//정해진 시간에 특정 작업을 하려고 할때 사용
//TimeTask


public class Test10 extends Thread{

	     private int num =0;
	
	public Test10(){

		TimerTask task = new TimerTask() {//내가 정해놓은 작업 NUM을 0으로 초기화하라.

			@Override
			public void run() {

				//반복실행할 작업을 실행한다.

				num = 0;

			}
		};

		Timer t= new Timer();
		Calendar d = Calendar.getInstance();


		/*
		 내일 0시 0분 0초qnxj 하루에 한번씩 반복
		 d.add(Calendar.DATE,1);
		 d.set(Calendar.HOUR,0);//오후 1시:13
		 d.set(Calendar.MINUTE,0);
		 d.set(Calendar.SECOND,0);
		 d.set(Calendar. MILLISECOND,0);
		 t.schedule(task,d.getTime(),1000*60*60*24);
		 //1000은 시간을 밀리세컨으로 변경(초,분,시)

		 */

		t.schedule(task, d.getTime(),5000);//5초마다 실행하라





	}



	@Override
	public void run() {

		while(true){
			System.out.println(num++);

			try {
				sleep(1000);
			} catch (Exception e) {



			}


		}


	}



	public static void main(String[] args) {

		//Test10 ob = new Test10();
		//ob.start();

		new Test10().start();

	}

}
