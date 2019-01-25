package com.day5;

import java.util.Random;

public class Test3 {

	public static void main(String[] args) {
		
		//1~45까지의 난수를 발생시켜 6개의 수를 크기순으로 정렬
		
		
		Random rd = new Random();
		
		int[] num = new int[6];//일반변수> 쓰레기값 / 배열 변수 int> 0 str>null double>0.0 기본값(자동으로 초기화)
		
		int i,j,n,temp;
		
		n=0;
		while(n<6){ 
			
			num[n] = rd.nextInt(45);
			
			for(i=0;i<n;i++){
				
				if(num[i]==num[n]){
					n--;
					break;
				}
			}
			
			n++;
			
		}
		
		//정렬
		for(i=0;i<6;i++){
			
			for(j=i+1;j<6;j++){
				
				if(num[i]>num[j]){
					
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
				
		}
		
		//출력
		for(int su:num)
			System.out.printf("%4d",su);
		
		System.out.println();
		
		
	
	
	}

}
