package com.day3;

import java. util.*;
import java. io.*;

class Test3 {





 public static void main(String[] args) throws IOException{


    Scanner sc = new Scanner(System.in);

	int su, sum;
	char ch;

	while(true){//���ѷ���

	
	

	   do{

	         System.out.print("���Է�?");
			 su= sc.nextInt();

	   } while(su<1||su>5000);

	   sum=0;
	   for(int i=1;i<=su;i++){

		    sum+=i;

	   }
	   
	   
	   System.out.println("1~"+ su+ "������ ��"+ sum);

	   System.out.print("�������?[Y/N]");//Ye(10,13).y.N.n
	   ch=(char)System.in.read();

	   if(ch!='Y' && ch!='y') {//������ ������ �����̸� �ص带 ���ش�.
		   
		   System.out.println("�����մϴ�..");
	     break;//�극��ũ�� �ָ� ���ѷ����� �� �� �ִ�.//while, do~while,for,switch

	   }




     }//end.while
		
	}//end..main
 }
