package com.class3;

//���(�θ� �ڽĿ���)
//1.�θ�Բ��� ��(�ڽ�)����
//2.private�� �����Ѱ��� �θ𲨴�
//3.protected�� �����Ѱ��� ����� ����(���� package ���� class ���� ����)
//4.������ ������(�θ�� ����X)
//5.���� ��ü�� ������������ ������ ����(����)(override)


class Test{
	
	private String title;
	private int area;
	
	public void set(String title,int area){
		
		this.title = title;
		this.area = area;
		
	}
	
	
	public void print(){
		
		System.out.println(title + ":" + area);
		
		
	}
	
}
		

class RectB extends Test{//��Ӽ���//�ڹٿ����� ���� ����� �Ұ��� �ϴ�.
	
	private int w,h;
	
	//�����ε��� ������
	public RectB(int w, int h){
		this.w = w;
		this.h = h;
		
	}
	
	
	public void rectArea(){
		
		int a = w*h;
		set("�簢��", a);//�θ�Բ��� ����
	}
	
	
}



public class Test8 {

	public static void main(String[] args) {
		
		RectB ob = new RectB(10, 20);
		
		ob.rectArea();
		ob.print();
		
		
		
		
		

	}

}
