package com.day5;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		//10명 이내의 이름과 점수를 입력받아
		//점수가 높은사람에서 낮은사람으로 출력(내림차순)
		
		
		//선언
		Scanner sc = new Scanner(System.in);
		
		String[] name;//수를 지정받지 않았으므로 선언만 한다
		int[] score;
		
		int i,j,inwon,temp1;
		String temp2;
		
		 do{
			System.out.print("인원수[1-10]?");
			inwon = sc.nextInt();
			
		 }while(inwon<1||inwon>10);
		
		
		//배열의 메모리 할당(객체생성)
		name = new String[inwon];
		score = new int[inwon];
		
		
		//입력
		//인원수만큼 이름과 점수를 입력
		 for(i=0;i<inwon;i++){
			System.out.print((i+1) + "번째 이름?");
			name[i] = sc.next();
			
			System.out.print("점수?");
			score[i] = sc.nextInt();	
			
		}
		
		
		//연산(정렬)
		  for(i=0;i<inwon-1;i++){
			
			for(j=i+1;j<inwon;j++){
				
				if(score[i]<score[j]){
					
					temp1 = score[j];
					score[j]=score[i];
					score[i]=temp1;
					
					temp2 = name[i];
					name[i] = name [j];
					name[j] = temp2;
				}
			}
		}
		
		//출력
		  for(i=0;i<inwon;i++){
			System.out.printf("%10s %4d\n",name[i],score[i]);
		}
		
	
	}

}
