package com.day5;

import java.util.Random;

public class Test3 {

	public static void main(String[] args) {
		
		//1~45������ ������ �߻����� 6���� ���� ũ������� ����
		
		
		Random rd = new Random();
		
		int[] num = new int[6];//�Ϲݺ���> �����Ⱚ / �迭 ���� int> 0 str>null double>0.0 �⺻��(�ڵ����� �ʱ�ȭ)
		
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
		
		//����
		for(i=0;i<6;i++){
			
			for(j=i+1;j<6;j++){
				
				if(num[i]>num[j]){
					
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
				
		}
		
		//���
		for(int su:num)
			System.out.printf("%4d",su);
		
		System.out.println();
		
		
	
	
	}

}
