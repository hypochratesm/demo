package com.Practice1;

class Rect{//�簢���� ������ ���ϴ� Ŭ����
	
	private int w,h;
	
	public Rect(){//�⺻������
		
	}
	public Rect(int w, int h){//�����ε�(��������)�� ������,�������̵�(ġȯ = ������)
	   this.w =w;
	   this.h =h;
	}
	public void set(int w, int h){
		this.w = w;
		this.h=h;
	}
	public int area(){
		return w*h;
	}
	public int length(){
		return(w+h)*2;
	}
	public void pront(int a){
		System.out.println("����:" +w);
		System.out.println("����:" +h);
		System.out.println("����:" +a);
	}
	
	public void print(int a, int l){
		
		System.out.println("����:" + w);
		System.out.println("����:" + h);
		System.out.println("����:" + a);
		System.out.println("�ѷ�:" + l);
	}
}

public class Test4 {
	
	public static void main(String[] args ){
		
		Rect ob1 = new Rect();
		ob1.set(10,20);
		
		int a =ob1.area();
		int l =ob1.length();
		ob1.pront(a);
		ob1.print(a, l);
		
		Rect ob2 = new Rect(100, 200);
		a = ob2.area();
		l = ob2.length();
		ob2.pront(a);//pront ���� ��Ȯ��, �ż���.
		ob2.print(a, l);
		
		ob2.set(11,22);
		
		
		
		
		
	}

}
