package com.day5;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		//�迭�ȿ� �ִ� ���ڸ� ����
		
		int[] num = new int[5];// = {28,65,7,4,10};
		int i,j,temp;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�ټ����� ����?");
		
		for(i=0;i<num.length;i++){
			num[i] = sc.nextInt();
		}
		
		System.out.print("Source Data: ");
		
		for(i=0;i<num.length;i++){//�迭�� �ݵ�� for������ ��� ���ϴ�.
		
			System.out.printf("%4d",num[i]);
		}
		
		
		System.out.println();
		
		
		//����
		//Selection Sort
		for(i=0;i<num.length-1;i++){//�ܿ��
			
			for(j=i+1;j<num.length;j++)//�ܿ��
				
				
				//System.out.println(i + ":" + j);
			
			if(num[i]>num[j]){
				temp=num[i];
				num[i]=num[j];
				num[j]=temp;
			}
			
		}
		
		
		//���
		System.out.print("Sorted Data: ");
		
		for(int n : num){//Ȯ��for��//c#���� ī�� �ؿ°�
			
			System.out.printf("%4d",n);
			
		}
		
		
		

	}

}
