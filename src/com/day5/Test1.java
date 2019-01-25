package com.day5;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		//배열안에 있는 숫자를 정렬
		
		int[] num = new int[5];// = {28,65,7,4,10};
		int i,j,temp;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("다섯개의 숫자?");
		
		for(i=0;i<num.length;i++){
			num[i] = sc.nextInt();
		}
		
		System.out.print("Source Data: ");
		
		for(i=0;i<num.length;i++){//배열은 반드시 for문으로 써야 편하다.
		
			System.out.printf("%4d",num[i]);
		}
		
		
		System.out.println();
		
		
		//연산
		//Selection Sort
		for(i=0;i<num.length-1;i++){//외우기
			
			for(j=i+1;j<num.length;j++)//외우기
				
				
				//System.out.println(i + ":" + j);
			
			if(num[i]>num[j]){
				temp=num[i];
				num[i]=num[j];
				num[j]=temp;
			}
			
		}
		
		
		//출력
		System.out.print("Sorted Data: ");
		
		for(int n : num){//확장for문//c#에서 카피 해온것
			
			System.out.printf("%4d",n);
			
		}
		
		
		

	}

}
