package com.thread;

//interrupt: �켱������ ���� ���α׷��� ���� ���� ��Ű�� �ٽ� ���ƿ�



class MyThread7 extends Thread{

	private Thread next;

	public void setNext(Thread next){
		this.next = next;
	}

	@Override
	public void run() {

		for(int i= 1; i<=20;i++){

			try {

				sleep(2000);


			} catch (Exception e) {

			}
			
			System.out.println(getName()+":" + i);
			
			if(next.isAlive())
				next.interrupt();//�����尡 ��� �ִٸ� �����带 ������Ű�� ���� �����带 ������Ѷ�.
		}
	}
}

public class Test7 {

	public static void main(String[] args){
		
		System.out.println("main����..");

		MyThread7 t1 = new MyThread7();
		MyThread7 t2 = new MyThread7();
		MyThread7 t3 = new MyThread7();
		
		t1.setNext(t2);
		t2.setNext(t3); //A->B->C->A
		t3.setNext(t1);
		//�����带 ��ȯ������ �����ϰԲ� ����� �޼ҵ尡 interrupt�̴�.
		t1.start();//���� ȣ��
	    t2.start();
	    t3.start();
	    
	    t1.interrupt();//������ɾ�� �Ȱ���.
	    
	    
	    
	    try {
	    	
	    	t1.join();
	    	t2.join();
	    	t3.join();
			
		} catch (Exception e) {
			
		}
	    
	    System.out.println("main����..");

	}

}
