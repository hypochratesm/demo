package com.thread;

//����ȭ��

class MyThread8 implements Runnable{

	private int bank = 10000;//�ܰ�

	public int getBank() {//���ο����� ������ �� �ִ�.
		return bank;
	}

	private int drawMoney(int m){
		bank-=m;//����

		return m;//������ �ܾ�


	}

	@Override
	public void run() {

		int money_need = 6000;//������ �ݾ�

		int money;

		String str ="";

		try {
			synchronized (this) {//�ϳ��� �����尡 �� �ȿ� ���� �ٸ� �����尡 ���� ��� �� �� ����.


				if(getBank()>=money_need){

					//Thread.yield();//�ٸ������忡�� �纸
					money = drawMoney(money_need);
					str="���⼺��";

				}else{


					money=0;
					str = "�������!";

				}

				System.out.println(Thread.currentThread().getName()+ str+"����ݾ�" + money + "�ܰ�"+getBank());    
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
