package com.thread;

class MyThread1 extends Thread{//��Ƽ �׽�ŷ�� �����ϱ� ���� �����...
	
	private int num;
	private String name;
	
	public MyThread1(int num, String name){
		//����������
		
		this.num = num;
		this.name = name;
	
	}

	@Override
	public void run() {//������ �޼ҵ�
		//�츮�� �ؾ� �� �۾��� ����ٰ� ����� ���´�.
		
		//���� �ϰ��� �ϴ� �ι�° �۾�
		int i =0;
		
		
		while(i<num){
			
			System.out.println(this.getName() + ":" +name + i);
			i++;
			
			
			try {
				
				sleep(100);//0.1�� ����
				//Ư�� �޼ҵ忡�� �󸶰� ����� �ñ׳��� ������.
				
				//������ �ּ�ó���� �ϸ� �ΰ��� ������ �ϰ� �Ǿ� �������� ������� ������
				//������ �������ν� ������ ������ �ʰ� ��Ƽ�׽�ŷ�� �����ϰ� �ȴ�.
				
			} catch (Exception e) {
				
			}
		}
		
		
	}
	
	
	
}

public class Test1 {
	
	public static void main(String[] args){//���ν�����.
		
		System.out.println("main ����...");
		
		MyThread1 t1 = new MyThread1(100, "ù��°");
		MyThread1 t2 = new MyThread1(200, "ù��°");
		
		t1.start();
		t2.start();
		//������� ����� ������ 
		//������� ����� ������� 3����(main,t1,t2)
		
		System.out.println("main����....");
		
	}

}
