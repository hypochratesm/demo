package com.day3;

import java.util.*;

class Test2 {



	public static void main(String[] args) {


		//10���� ū �� �� �Է¹޾� 1���� �հ� ���ϱ�


	   Scanner sc = new Scanner(System.in);

	   int su,sum=0;//sum���� ������ ���� ���� �ִµ� �̸� �ʱ�ȭ ��Ű�� ������ ������ �Ұ���
	    //�ʱ�ȭ�� sum=0���� �����ִ� ��.

	   do{

	      System.out.print("�� �Է�");//100
	      su = sc.nextInt();

	   }while(su<10);//�ȵſ�

	   //�����۾�
/*
	   for(int i=1; i<=su;i++){

		   sum=sum+i;
	   }


	   System.out.println("���"+ sum);
	   */


        int i=0;
		while(i<su){

			i++;
			sum+=i;//����
		}


	    System.out.println("���"+ sum);

	
	}
}
