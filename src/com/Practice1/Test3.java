package com.Practice1;

/*import java.util.Scanner;*/


//������
// �޸� �Ҵ��� ������ ����Ѵ�.
//���� �ʱ�ȭ�� ���
//�����ε��� �����ڸ� ���� ������ �ڵ��� ���� ���� �� �ֱ� �����̴�.
//class�� �̸��� �����ϴ�.
//���ϰ��� ���� ������ property�� ����.//void
//�ߺ�����(overloading)�� ����
//���� ���ο��� �ѹ��� ȣ���� ����
//property�� �޼ҵ常 ������ �մ�/
//�⺻ �����ڴ� ���� �����Ǿ� �ִ�.//�ᵵ �ǰ� �Ƚᵵ �ȴ�.

public class Test3 {
	
	private int y;
	//�⺻�����ڴ� �����ε��� �����ڸ� ������� ������ �⺻�����ڸ� ����ؾ߸� �Ѵ�.
	
	public Test3(){//���� �����ڰ� ���� ������ property�� ����� �ʿ䰡 ����.
		
	//�⺻ ������.
		
		this(20);//������ ���ο� �� ���� �� �� �ִ�.
		System.out.println("�μ��� ���� ������..");
		y = 10;
		System.out.println("y:" + y);
	}

	
	/*public void setData(int y){
		
	this.x =x;
	System.out.println("x:" +x);
	}*/
	
	public Test3(int y){//int y�� �־� �Ű������� ������ �ٸ��� �Ͽ� �浹�� ���ϰ� ��
		  
	System.out.println("�μ��� �ִ� ������..");
	
	this.y = y;
	
	System.out.println("y:" +y);
	}
	
	
	public static void main (String [] args){
		
		Test3 ob = new Test3();
		Test3 ob1 = new Test3(100);//�̷� ������ �����ϴ�. �ε��� �Ǵ� ���ÿ� Test3���� ��ü�� �����ȴ�.
		
		//ob.setData(10)
		
		//Test3�� �����ڷ� �θ���.
		
		//Test3 ob1 = new Test3();
		//Test3 ob2 = new Test3(100);
		
		/*Scanner sc = new Scanner(System.in);*/
		
	}
}
