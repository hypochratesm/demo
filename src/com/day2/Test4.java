package com.day2;

import java.io.*;

class Test4 {



	public static void main(String[] args) throws IOException {

         //���
		 //if,for,while,do~while,switch
		 //�ݺ��� : for,while,do~while
		 //for���� ������ ������ ������
		 //while���� ����� ������ ���� �𸦶� ����ϴ°�
		 //do~while���� �ϴ� ������ ����.

		 BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

		 int num = 0;
		 String str =null;//""=""�� �ƹ��͵� ���� ��� ��

		 System.out.print("���Է�?");
		 num= Integer.parseInt(br.readLine());


         //���� if��


/*
		 if(num%2==0){
			 str="¦��";
		 }
		 //���๮�� �����϶��� �߰�ȣ�� ���� �����ϴ�.
		

		 if(num%2!=0)
			 str="Ȧ��";
*/

         if(num%2==0){
		  str="¦��";
	     }else{
		str="Ȧ��";
	}

		 
		 System.out.println(str);

		
	}
}
