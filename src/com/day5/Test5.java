package com.day5;

import java.util.Scanner;

        public class Test5 {
	
	
	

	public static void main(String[] args) {
		

		

		Scanner sc = new Scanner(System.in);

	
		int months[] = {31,28,31,30,31,30,31,31,30,31,30,31};

		int y,m,nalsu,i = 0,week;

		do{
			System.out.print("�⵵?");
			y= sc.nextInt();
		}while(y<1);

		do{
			System.out.print("��?");
			m = sc.nextInt();
		}while(m<1||m>12);
		
		
		do{
			System.out.print("��?");
			y= sc.nextInt();
		}while((i<1||i>30));

		
		if(y%4==0&&y%100!=0||y%400==0){
			months[1] = 29;
		}

		
		nalsu = (y-1)*365 + (y-1)/4-(y-1)/100+(y-1)/400;

		/*int yy=(y-1)/4-(y-1)/100+(y-1)/400;
		System.out.println(yy);
		System.out.println(nalsu);*/

		//����(m-1)������ ����
		for(i=0;i<m-1;i++){

			nalsu += months[i];
		}

		//y�� m��1�ϱ����� ����
		nalsu = nalsu + 1;

		//���Ǽ� ���
		week = nalsu%7;//0~6
		
        String[] yoil = {"��","��","ȭ","��","��","��","��","��"};
		
		System.out.printf("%��","%��","%��","%s����",
		             y,m,i,yoil[week]);

		
		

		if(week%7!=0){
			System.out.println();
		System.out.println("------------------------------");
		}
		}

}
