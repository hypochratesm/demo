package com.day5;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {

		//10명이내의 이름과 정수를 입력받아
		//석차 구하기

		//선언

		Scanner sc = new Scanner(System.in);
		String name[];

		int score[];
		int rank[];

		int i,j,temp1,inwon,temp3;
		String temp2;

		do{
			System.out.print("인원수[1-10]?");
			inwon = sc.nextInt();

		}while(inwon<1||inwon>10);

		//배열의 메모리 할당(객체생성)
		name = new String[inwon];
		score = new int[inwon];
		rank = new int[inwon];

		//입력
		for(i=0;i<inwon;i++){
			System.out.print((i+1) + "번째 이름?");
			name[i] = sc.next();

			System.out.print("점수?");
			score[i] = sc.nextInt();
			//rank[i] = 1;

		}

		//rank초기화
		for(i=0;i<inwon;i++){
			rank[i] = 1;
		}
		
		
		//연산
		for(i=0;i<inwon-1;i++){
			
			for(j=i+1;j<inwon;j++){
				
				if(score[i]<score[j]){
					rank[j]++;
					
				}else if(score[j]<score[i]){
					rank[i]++;
					
				}
			}
		}

		
		//출력
		for(i=0;i<inwon;i++){
			System.out.printf("%10s %4d %4d\n",name[i],score[i],rank[i]);
		}
		


	}

}
