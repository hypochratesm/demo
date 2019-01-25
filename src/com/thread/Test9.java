package com.thread;

class MyThread9 implements Runnable{

	private int bank = 10000;

	private int getBank(){

		return bank;
	}

	private int drawMoney(int m){

		if(getBank()>0){

			bank -= m;

			System.out.println(Thread.currentThread().getName() +
					"인출: " + m + ",잔액: " + bank);
		}else{
			m=0;
			System.out.println(Thread.currentThread().getName() +
					"," + "잔액부족!");
		}

		return m;
	}

	@Override
	public void run() {

		synchronized (this) {//동기화 블록에 메소드 두개가 삽입가능하다.

			//하나의 스레드가 사용중이면 
			//다른스레드는 들어올 수 없다
			//단, 접근가능하게 하려면 wait를 사용

			for(int i=1;i<=10;i++){

				if(getBank()<=0){
					this.notifyAll();//대기상태의 스레드를 깨움
					break;
				}

				drawMoney(1000);

				if(getBank()==2000||getBank()==4000||
						getBank()==6000||getBank()==8000){

					try {

						wait();//스레드 하나가 일시중지 된다.
						//번갈아 가면서 인출 작업이 진행된다.

					} catch (Exception e) {
						// TODO: handle exception
					}
				}else{
					notify();//깨우는것.
				}
			}
		}	
	}
}

public class Test9 {

	public static void main(String[] args) {
		
MyThread9 ob = new MyThread9();
		
		Thread t1 = new Thread(ob);
		Thread t2 = new Thread(ob);
		
		
		t1.start();
		t2.start();
		
	
	}
}

	
		