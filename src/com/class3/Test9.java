package com.class3;

//���(�θ� �ڽ�)
//1.�θ�Բ��� ������(�ڽĲ��� ���ڴ�!!!!)
//2.private�� ������ ��. �θ� ����.
//3.protected�� �����Ѵ�. ����� ����.
//3-1(package ���� �ȿ��� ���� �� �� �� �ִ�. private���� �������� public ���� ���Ѱ��� protected��.)
//4.������ ������!(���� �θ� ���� ���� why? ����̱� ������.)
//5.���� ��ü�� ������ ������ ��������!!!!(override�϶� ���� ����Ѵ�.)



class TestA{
	
	private String title;
	//private int area;
	protected int area;
	public void set(String title){
		
		this.title = title;
		
		
	}
	public void print(){
		
		System.out.println(title + ":" + area);
		
	}
	
}
///Test �� RectA�� �ƹ� ���� ����.

class RectA extends TestA{//��Ӽ����� �� ��.
	
	private int w,h;
	
	//�����ε��� ������//�����ڷ� �ʱ�ȭ ��Ŵ
	public RectA(int w, int h){
		this.w = w;
		this.h = h;
	}
	public void rectArea(){
		
		//area a =w*h;//2.private�� ������ ��. �θ� ����.
		area= w*h;//3.protected�� �����Ѵ�. ����� ����.
		set("�簢��");//�ڽ��� �θ���� ������ �� �� �ִ�.//1.�θ�Բ��� ������(�ڽĲ��� ���ڴ�!!!!)
		

		
		
	}
}



public class Test9 {
	
	public static void main(String[] args) {
		
		RectA ob = new RectA(10,20);//��ü�� �����԰� ���ÿ� W�� H�� �ʱ�ȭ �Ǿ���
		
		ob.rectArea();
		
		ob.print();//1.�θ�Բ��� ������(�ڽĲ��� ���ڴ�!!!!)
		
		
		
		
	
		
		
	}

}
