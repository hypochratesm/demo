package com.day5;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HW {

	public static void main(String[] args) throws IOException {
		
		
/*		//문제1 5개의 정수를 입력받아 입력받은 수를 출력하고 입력받은 수중 가장 큰수와 적은수를 출력
		
		Scanner sc = new Scanner(System.in);
		
		int i,j,temp;
		int[] num = new int[5];
		
		System.out.print("다섯개의 숫자?");
		for(i=0;i<5;i++){
			num[i] = sc.nextInt();
		}
		
		System.out.print("숫자 :");
		for(int n : num){	
			System.out.printf("%4d",n);
		}System.out.println();
		
		j=0;
		for(i=0;i<5;i++){
			for(j=i+1;j<5-i;j++)
				if(num[i]<num[j]){
					
					temp=num[j];
					num[j]=num[i];
					num[i]=temp;
				}
		}

		System.out.printf("가장 큰수: %d 가장 작은수: %d\n",num[0],num[4]);*/
		
		
		//문제2 1~10사이의 난수를 발생시켜 발생시킨 난수를 3번안에 알아 맞추는 게임
		//(3번안에 알아맞추지 못하면 발생된 난수를 출력)
		
/*		Random rd = new Random();
		
		int[] num = new int [10];
		int n=0;
		int i,j,su;
		Character a;
		
	
			Scanner sc = new Scanner(System.in);
			
			while(true){
				num[n] = rd.nextInt(10)+1;
			
				
		
				for(i=0;i<3;i++){
				
					System.out.printf("정수입력? [%d번째 기회]",i+1);
					su = sc.nextInt();
				
					if(su!=num[n]){
						System.out.println("틀렸어요!!");
					}else if(su==num[n]){
						System.out.println("맞았어요!!");
						break;
					}
				}
				
				System.out.println("정답은 " + num[n]+"입니다");
				
				System.out.print("계속할래? [Y/N]");
				a = (char)System.in.read();

				if (a!='Y'&& a!='y'){
					System.out.println("종료합니다..");
					break;
				}
				
			}*/
				
			
			//문제3 1~3사이의 난수를 발생시켜 가위,바위,보 게임 프로그램 작성
	
			
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
