package com.class2;

import java.util.Scanner;

class Rect{//�簢���� ������ ���ϴ� �޼ҵ�
	
	private int w,h;//������ �׻� private�� �������ش�.
	
	
	public void set(int w, int h){
		
		this.w = w;
		this.h = h; 
	}
	
	public int area(){
		return w*h;
	}
	public int length(){
		return (w+h)*2;
	}
	
	public void print(int a, float l){
		System.out.println("����:" + w);
		System.out.println("����:" + h);
		System.out.println("����:" + a);
		System.out.println("�ѷ�:" + l);
	}
	
	
	//�޼ҵ� overloading(�ߺ�����)
	//�޼ҵ��� �̸��� ���������� �Ű������� ������ �ٸ��ų�
	//������ Ÿ���� �ٸ��� �ٸ� �޼ҵ�� �ν��Ѵ�.
	//�ڷ����� Ʋ���� �ٸ� �޼ҵ�� �ν��ϰ� �ȴ�.
	//�ϳ��� Ŭ���� �ȿ��� �����۾��� �ϴ� �޼ҵ��� �̸��� ���� ��Ű�� ���ؼ� oveloading(�ߺ�����)�� �Ѵ�.
	public void print(){
		System.out.println("����:" + w);
		System.out.println("����:" + h);
	}
	
	public void print(int a){
		System.out.println("����:" + w);
		System.out.println("����:" + h);
		System.out.println("����:" + a);
	}
	public void  print(float l){
		System.out.println("����:" + w);
		System.out.println("����:" + h);
		System.out.println("�ѷ�:" + l);
	}
	
}

public class Test4 {

	public static void main(String[] args) {
		
		int w,h;
		
		Scanner sc = new Scanner(System.in);
     
		Rect ob = new Rect();
		
		
		System.out.print("����");
		w = sc.nextInt();
		
		System.out.print("����");
		h = sc.nextInt();
		
		ob.set(10, 20);
		
		int a = ob.area();
		float l = ob.length();
		
	/*	ob.print(a, l);
		ob.write();
		ob.areaWrite(a);
		ob.lenghtWrite(l);
		*/
		
		ob.print(a);
		ob.print(a,l);
		
		ob.print(l);
		
	    
		
		
		
	}

}
