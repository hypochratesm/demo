package com.generic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test4 {
	
	public static String getOper() throws  Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String oper = null;
		
		try {
			
			
			System.out.println("������");	
			oper = br.readLine();//catch���� ������ ����ش�.
			
			if(!oper.equals("+")&&!oper.equals("-")&&
			!oper.equals("*")&&!oper.equals("/")){
				
				//throw�� ���ܸ� �ǵ������� �߻���Ų��.
				//throw�� ����Ϸ��� ���� throws Exception�� ����ؾ��Ѵ�.
				//����ؾ���
				//throw�� �ݵ�� try���� ���ԵǾ�� �Ѵ�.
				
				throw new Exception("������ �Է¿���");//����� ���� ����
				
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println("�Է¿���");
		}
		
		 return oper;
		
	}


	public static void main(String[] args) throws Exception {
		

		int num1,num2,result;
		String oper;

		Scanner sc = new Scanner(System.in);

		System.out.println("�ΰ��� ��?");

		num1= sc.nextInt();
		num2= sc.nextInt();
		oper = Test4.getOper();
		
		result = 0;
		
		try {
		
			result = 0;

			if(oper.equals("+"))
				result = num1+num2;

			else if(oper.equals("-"))
				result = num1-num2;

			else if(oper.equals("*"))
				result = num1+num2;

			else if(oper.equals("/"))
				result = num1+num2;

			System.out.printf("%d %s %d =%d\n",num1,oper, num2,result);
			
		} catch (Exception e) {
			
		}

	}

}
