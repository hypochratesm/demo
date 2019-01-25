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
					"����: " + m + ",�ܾ�: " + bank);
		}else{
			m=0;
			System.out.println(Thread.currentThread().getName() +
					"," + "�ܾ׺���!");
		}

		return m;
	}

	@Override
	public void run() {

		synchronized (this) {//����ȭ ���Ͽ� �޼ҵ� �ΰ��� ���԰����ϴ�.

			//�ϳ��� �����尡 ������̸� 
			//�ٸ�������� ���� �� ����
			//��, ���ٰ����ϰ� �Ϸ��� wait�� ���

			for(int i=1;i<=10;i++){

				if(getBank()<=0){
					this.notifyAll();//�������� �����带 ����
					break;
				}

				drawMoney(1000);

				if(getBank()==2000||getBank()==4000||
						getBank()==6000||getBank()==8000){

					try {

						wait();//������ �ϳ��� �Ͻ����� �ȴ�.
						//������ ���鼭 ���� �۾��� ����ȴ�.

					} catch (Exception e) {
						// TODO: handle exception
					}
				}else{
					notify();//����°�.
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

	
		