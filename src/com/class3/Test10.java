package com.class3;

class SuperClass{//�θ�
	
	private String title;
	protected double area;
	
	public SuperClass(){
		
	}
	
	public SuperClass(String title){
		
		this.title = title;	
		
	}
	public void write(){
		
		System.out.println(title+":" + area);	
	}
	
}

class Circle extends SuperClass{
	
	
	private int r;
	protected static final double PI=3.14;//�� �ʱⰪ�� �ٲ��� �ʴ´�.
	
	public Circle(int r){
		super("��");//�⺻�����ڸ� ȣ��.//�θ�������߿� overloading�� �����ڸ� ȣ���ϰ� �ȴ�.
		this.r =r;
		
	}
	
	public void circleArea(){
		area =(double)r*r*PI;
		
	}
	
}

class RectC extends SuperClass{
	
	private int w,h;
	public void rectArea(int w, int h){
		this.w = w;
		this.h = h;
		
		area = w*h;
		
	}
	
	//�޼ҵ�Override(�������̵�)
	@Override//������̼�//�θ��� ���� ����Ҷ� �״�� �� ���ڸ� ������ �����ϴ� ����.
	public void write() {
		
		System.out.println("����: " + w);
		System.out.println("����: " + h);
		System.out.println("����: " + area);
	}
	
	//�޼ҵ��� override
	//���� ��� �����ִ� ���������� �θ� ������ �ִ� �� ���Ⱑ �� �ָ���.//�θ� ������
		               //�ִ� �޼ҵ��� �̸��� ������ �� �� �ִ�. �μ��� ������ �μ��� �ڷ����� Ʋ���� ���ִ°�?
		               //�θ��̸��� Ŭ������ �� �̸��� ������ �ִ� Ŭ������ �ٸ���.
		               //�̸� �޼ҵ� �������̵��� �Ѵ�.
	
	
	//�������̵�� �θ�� �ڽİ��迡�� ���� ������ �ϴ� �޼ҵ��� �̸��� ����ϳ� Ʋ���� �ʰ� ������ִ� ��
		
	
	}
	
	

public class Test10 {
	
	
	
	public static void main(String[] args) {
		
		Circle ob1 =new Circle(10);
		ob1.circleArea();
		ob1.write();
		
		System.out.println("---------------");
		
		RectC ob2 = new RectC();
		ob2.rectArea(10,20);
		//ob2.write();�θ� ��.
		ob2.write();//�ڽ� ��.
		//ob2.print();
		
		//���� ������ �ϴ� �޼ҵ��� �̸��� ���� �����־���.
		
		
		
		
		
	
		
		
}

}
