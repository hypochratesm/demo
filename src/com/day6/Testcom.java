package com.day6;

import java.util.Scanner;

    public class Testcom {
	
	/*//�簢���� ������ ���������� ���ϴ� ȸ��
	
	int w,h;//��������,instance����
	
	public void input(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����?");
		
	    w=sc.nextInt();
	    
	    System.out.print("����?");
	    
	    h= sc.nextInt();
	    
	    //return : void�� ������ �����ȴ�.
	   	
		
	}
	
	public int area(){
		
		int result;//��������
		
		result = w*h;//�����ȿ� �ִ� �����͸� �༭ ������ ���̴�.
		
		return result;//��ȯ��
		
		
	}
	
	public int length(){
		
		return(w+h)*2;//���⿡ ���� ���� ���̰� ��� �ȉ�
	}
	
	
	public void print(int a,int l){//������ �°� ��⸸ �ϸ� �ȴ�.
		
		System.out.println("����: " + w);
		System.out.println("����: " + h);
		System.out.println("����: " + a);
		System.out.println("�ѷ�: " + l);*/
    	
    	public int w,h;//��������,instance����(java���� ���),�������(������ ���� ���)
    	public void input(){
    		Scanner sc = new Scanner(System.in);
    		
    		System.out.print("����?");
    		w= sc.nextInt();
    		System.out.println("����?");
    		h= sc.nextInt();
    		//return : void�� ������ �����ȴ�.
    	}
    	
    	public int area(){
    		int result;//��������
    		
    		result = w*h;//�����ȿ� �ִ� �����͸� �༭ ������ ���̴�.
    		return result;//��ȯ��
    		
    	}
    	
    	public int length(){
    		
    		return(w+h)*2;//���⿡ ���� ���� ���̰� ��� �ȴ�
    		
    	}
    	
    	public void print(int a, int l){//������ �°� ��⸸ �ϸ� �ȴ�.//�Ű�����//������ �޼ҵ峢�� �о�ȭ�� ���״�
    		System.out.println("����:" +w);
    		System.out.println("����:" +h);
    		System.out.println("����:" +a);
    		System.out.println("�ѷ�"  +l);
    	
	}
}
