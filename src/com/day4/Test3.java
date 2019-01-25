package com.day4;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {

		//만년달력

		Scanner sc = new Scanner(System.in);

		//월별 날짜수를 배열에 저장
		int months[] = {31,28,31,30,31,30,31,31,30,31,30,31};

		int y,m,nalsu,i,week;

		do{
			System.out.print("년도?");//2000
			y= sc.nextInt();
		}while(y<1);

		do{
			System.out.print("월?");
			m = sc.nextInt();
		}while(m<1||m>12);

		//윤년에 따른 2월의 날수 계산
		if(y%4==0&&y%100!=0||y%400==0){
			months[1] = 29;
		}

		//1년1월1일부터 전년도(y-1)12월31일까지의 날수
		nalsu = (y-1)*365 + (y-1)/4-(y-1)/100+(y-1)/400;

		/*int yy=(y-1)/4-(y-1)/100+(y-1)/400;
		System.out.println(yy);
		System.out.println(nalsu);*/

		//전월(m-1)까지의 날수
		for(i=0;i<m-1;i++){

			nalsu += months[i];
		}

		//y년 m월1일까지의 날수
		nalsu = nalsu + 1;

		//주의수 계산
		week = nalsu%7;//0~6

		//System.out.println(week);

		System.out.println("\n  일  월  화  수  목  금  토");
		System.out.println("------------------------------");

		//특정 요일부터 시작하도록 공백지정
		for(i=0;i<week;i++)
			System.out.print("    ");//공백4칸

		//해당 월의 날짜를 출력
		for(i=1;i<=months[m-1];i++){

			System.out.printf("%4d",i);

			//한주의 날짜가 출력되면 줄바꿈
			week++;

			if(week%7==0)
				System.out.println();

		}

		if(week%7!=0)
			System.out.println();
		System.out.println("------------------------------");

	}

}
