package com.class5;

//final�� ����ϴ� 3���� ���
//1.��������� final�� ���̸� �� �� ���� �ʱ�ȭ�� ����
//2.�޼ҵ忡 final�� ���̸� Override�� �Ұ�
//3.Ŭ������ final�� ���̸� ����� �Ұ�.

//final class Test//3�� Ŭ������ final�� ���̸� ��� �Ұ�.
  class TestA{
	
	public static final double PI;//STATIC�� ������� �ʰ� �ʱ�ȭ �ص� �ȴ�.//�� �ѹ� �� �ʱ�ȭ�� ����.
	
	static{//�ʱ�ȭ�� ��ų �ڵ��� �����ش�.
		PI = 3.14;
	}
	
	public double area; // instance����//public ��ſ� protected�� �൵ �������.
	
	
	//2.override�� �Ұ�.
	public final void write(String title){
		System.out.println(title + ":" + area);
	}
	
}


public class Test6 extends TestA {

	public void circleArea(int r){
		area = (double)r*r*PI;
	}
	public static void main(String[] args) {
	
		//public void write(String title) - �Ұ���
		
		
	   Test6 ob =new Test6();
	   
	   ob.circleArea(10);
	   ob.write("��");
			
		

	}

}
