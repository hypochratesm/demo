package com.class3;

/*import java.util.Scanner;*/

//������
//�޸� �Ҵ��� ������ ����Ѵ�.
//���� �ʱ�ȭ�Ҷ� ���
//�����ε��� �����ڸ� ���� ������ �ڵ��� ���� ���� �� �ֱ� �����̴�.
//class�� �̸��� ����
//���ϰ��� ���� ������ property�� ����.//void
//�ߺ�����(overloading)�� ����
//���� ���ο��� �ѹ��� ȣ�� ����
//new bufferedReader���� new ������ �ִ� ��.
//property�� �޼ҵ常 ������ �ִ�.

//�⺻ �����ڴ� ���� �����Ǿ� �ִ�.//�ᵵ �ǰ� �Ƚᵵ �ȴ�.


public class Test1 {
	
	
	private int x; 
	
	/*public Test1(){}//�⺻������.�����ε��� �����ڸ� ������� ������ �⺻�����ڸ� ����ؾ߸� �Ѵ�.
*/	
	public Test1(){//���� �����ڰ� ���� ������ property�� ����� �ʿ䰡 ����.
		
		//�⺻ ������
		
		this(20);//������ ���ο� �ѹ��� �� �� �ִ�.
		
		System.out.println("�μ��� ���� ������..");
		x = 10;
		System.out.println("x:" + x);
	}
	
	
/*	public void setData(int x){
		this.x = x;
		System.out.println("x:" + x);
	}
	*/
	public Test1(int x){//int x�� �־� �Ű������� ������ Ʋ���� �ؼ� �浹�� ����.
		
		//�����ε��� ������
		
		System.out.println("�μ��� �ִ� ������..");
	
		 this.x = x;
		 System.out.println("x:" + x);
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		

		Test1 ob = new Test1();
		Test1 ob1 = new Test1(100);//�̷� ������ �����ϴ�.�ε��� �Ǵ� ���ÿ� Test1���� ��ü�� �����ȴ�.//���ο� ������ �ִ� �����͸� �ʱ�ȭ �۾��� �����Ѵ�.
	/*	ob.setData(10);*/
		
		//Test1�� �����ڷ� �θ���.
		
		
		/*
		Test1 ob1 = new Test1();
		Test1 ob2 = new Test1(100);*/
		
		/*Scanner sc = new Scanner(System.in);*/ // �⺻�����ڷδ� ��ü�� ������ �� ����.
	}

}
