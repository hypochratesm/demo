package com.day2;

import java. util.*;

class Test7 {


	public static void main(String[] args) 	{

       //������ ���� �Է¹޾� ���������� ū������ ���
	   //������ ��? 15 3 7
	   //��� : 3 5 7
	   //������ ������ �ʿ���
	   //�ڸ��ٲ�
	   //num�� �̿�

    Scanner sc = new Scanner(System.in);

	String name;

	int num1,num2,num3,temp;

    System.out.print("������ ��?");

	
     num1 = sc.nextInt();
	 num2 = sc.nextInt();
     num3 = sc.nextInt();




	
	 if(num1>num2){
		 temp=num1;
		 num1=num2;
		 num2=temp;
	 }
	 if(num1>num3){
		 temp=num1;
		 num1=num3;
		 num3=temp;
	 }
	 if(num2>num3){
		temp=num2;
		num2=num3;
	    num3=temp;
	 }

	 //�� �ڵ��� �ܿ���
 

	 System.out.printf("%d %d %d\n", num1,num2,num3);
	 System.out.println(num1+""+num2+""+num3);


	}
}
