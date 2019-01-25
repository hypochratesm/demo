package com.thread;

//���󽺷���
//�ٸ������忡 ������ �ִ� ������� �ٸ� �����尡 ����Ǹ� �ڱ� �ڽŵ� ���� �ȴ�.
//���󽺷��尡 ������� �ʾƵ� ���μ����� ����ȴ�.

class MyThread5 implements Runnable{

	@Override
	public void run() {
		
		for(int i=1;i<20;i++){
			
			System.out.println(i);
			
			try {
				 Thread.sleep(1000);
			} catch (Exception e) {
			
			}
		}
	}
	
	
	
}

public class Test5 {

	public static void main(String[] args) {
		
		System.out.println("main ����...");
		
		Thread t1 = new Thread(new MyThread5());
		Thread t2 = new Thread(new MyThread5());
		Thread t3 = new Thread(new MyThread5());
		
		//Demon������//main�� ������ ������ �׸��д�.
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);
    
		t1.start();
		t2.start();
		t3.start();
		
		
		//���ν����� 1�� ��
		try {
			
			Thread.sleep(1000);//���� ���� 1�� �����
			
			
		} catch (Exception e) {	
		//������ 123�� ����� ���ڿ� �����尡 ����ȴ�.	
		//�� ������ ���� ������ ������ �ȴ�.	
		}
		try {
			
			t1.join();//t1�� ���������� t2,t2�� ��ٸ���� �ϴ� ��ɾ�.
			t2.join();
			t3.join();
			
		} catch (Exception e) {
			
		}
		
		
		System.out.println("main ����...");
	}

}
