package com.generic;

import java.util.Scanner;


//����ó�� - ���α׷��� ���鶧 �Ű��� ���� ����� �Ѵ�. ��� ó���� �ұ�?
//Exception

public class Test3 {

	public static void main(String[] args) {


		int num1,num2,result;
		String oper;

		Scanner sc = new Scanner(System.in);

		System.out.println("�ΰ��� ��?");

		num1= sc.nextInt();
		num2= sc.nextInt();

		//���⼭ ���� ������ �� Ȯ���� ����. try,catch��
		/*System.out.println("������?");
		oper =sc.next();

		result = 0;

		if(oper.equals("+"))
			result = num1+num2;

		else if(oper.equals("-"))
			result = num1-num2;

		else if(oper.equals("*"))
			result = num1+num2;

		else if(oper.equals("/"))
			result = num1+num2;

		System.out.printf("%d %s %d =%d\n",num1,oper, num2,result);*/


		try{//Ʈ���� Ĺġ ���� ������ ���� �ְ� ����� ���� ������ ����ó��(����ó��)�� �� ���־�� �Ѵ�.
			//������ ������ ���Ͱ����� Ʈ���� Ĺġ���� ���ְ� ���α׷��� ����� �ش�.
			//Ĺġ �� �ڿ� �ƹ��͵� ������ �ʾƵ� ������.

			System.out.println("������?");

			oper =sc.next();

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

		} catch (NumberFormatException e) {
			System.out.println("������ �Է��ض�");
			
		} catch (ArithmeticException e) {
			System.out.println("0���� ������ ����");
			
		} catch (Exception e){
		
			
			
			/*System.out.println(e);
			e.printStackTrace();*/
			System.out.println("�� �װ� ���ڷ� ���̳�");
		
		}finally{//�׻� ���� �ʾƵ� �ȴ�.
			
			System.out.println("�� �װ� ���ڷ� ���̳�?");
			
		}
	}
}
