package com.generic;

import java.util.Scanner;

import com.exec.MyException;

//5~10�� �̳��� ���ڿ��� �Է¹޾� ���
//���ڿ�?abcde
//abcde

//����

//5~10�� �̳��� ���ڿ��� ����� ����

//1. 5~10������ Ȯ��//ù��° �˻�
//2.�ݵ�� ������(��ҹ��� ���о���)�� �Է�
//exception���� ó�����ش�. -> ����ڰ� �Է��� ���� 

public class Test5 {
	
	
	public void inputForm(String str) throws Exception{
		//���� 1.2
		//���ø����ε� �غ���!
		//�ſ� �߿���
		
		
		

		if(str.length()<5|| str.length()>10){
			
			throw new MyException("���ڿ��� ���̴� 5~10�� �Դϴ�." + str);//�޼ҵ� ����
			
		}
	    for(int i=0;i<str.length();i++){
	    	
	    	char ch = str.charAt(i);
	    	
	    	if((ch<65||ch>90)&&ch<97||ch>122){
	    		
	    		throw new Exception("�����ڸ� �����մϴ�!");
	    		
	    	}
	    }
	}

	
	public static void main(String[] args){
		
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		
		Test5 ob = new Test5();
		
		try {
			
			System.out.println("���ڿ�?");
			str = sc.next();
			
			ob.inputForm(str);
			
			System.out.println(str);
			
			
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			
			
		}
		
		
		
		
	}

}
