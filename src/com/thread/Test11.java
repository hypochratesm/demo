package com.thread;

//�����嵵 �׷��� ��� ���� �� �ִ�.

public class Test11 {

	public static void main(String[] args) {
		
		System.out.println("���ν�����׷�:" + Thread.currentThread().getThreadGroup());
		//�����̶�� ������� �����̶�� �׷쿡 �� �ִ�.
		
		System.out.println("���ν������̸�" + Thread.currentThread());
		
		Thread t1 = new Thread();
		
		System.out.println("t1������׷�:" + Thread.currentThread().getThreadGroup());
		//Ư���ϰ� �׷��� �������� ������ ������� �������� ���� �ȴ�.
		
		
		//�������̸�,�켱����,�׷��
		//���� ���罺����� ������ �׷��� ������ټ� �ִ�?
		
		System.out.println("t1:" + t1);
		
		System.out.println("------------------------------------");
		
		ThreadGroup tg = new ThreadGroup("suzi");//�׷��̸�
		Thread t2 = new Thread(tg,"t2");
		Thread t3 = new Thread(tg,"t3");
		
		System.out.println("t2:" + t2);
		System.out.println("t3"  + t3);

	}

}
