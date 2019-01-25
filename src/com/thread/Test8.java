package com.thread;

//동기화블럭

class MyThread8 implements Runnable{

	private int bank = 10000;//잔고

	public int getBank() {//내부에서만 접근할 수 있다.
		return bank;
	}

	private int drawMoney(int m){
		bank-=m;//인출

		return m;//인출후 잔액


	}

	@Override
	public void run() {

		int money_need = 6000;//인출할 금액

		int money;

		String str ="";

		try {
			synchronized (this) {//하나의 스레드가 그 안에 들어가면 다른 스레드가 절대 들어 갈 수 없다.


				if(getBank()>=money_need){

					//Thread.yield();//다른스레드에게 양보
					money = drawMoney(money_need);
					str="인출성공";

				}else{


					money=0;
					str = "인출실패!";

				}

				System.out.println(Thread.currentThread().getName()+ str+"인출금액" + money + "잔고"+getBank());    
			}
		} catch (Exception e) {

		}
	}

}

public class Test8 {

	public static void main(String[] args) {


		MyThread8 ob = new MyThread8();


		//Thread t1 = new Thread(new MyThread8());



		Thread t1 = new Thread(ob);
		Thread t2 = new Thread(ob);

		t1.start();
		t2.start();





	}

}
