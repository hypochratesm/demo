package com.day5;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		//10�� �̳��� �̸��� ������ �Է¹޾�
		//������ ����������� ����������� ���(��������)
		
		
		//����
		Scanner sc = new Scanner(System.in);
		
		String[] name;//���� �������� �ʾ����Ƿ� ���� �Ѵ�
		int[] score;
		
		int i,j,inwon,temp1;
		String temp2;
		
		 do{
			System.out.print("�ο���[1-10]?");
			inwon = sc.nextInt();
			
		 }while(inwon<1||inwon>10);
		
		
		//�迭�� �޸� �Ҵ�(��ü����)
		name = new String[inwon];
		score = new int[inwon];
		
		
		//�Է�
		//�ο�����ŭ �̸��� ������ �Է�
		 for(i=0;i<inwon;i++){
			System.out.print((i+1) + "��° �̸�?");
			name[i] = sc.next();
			
			System.out.print("����?");
			score[i] = sc.nextInt();	
			
		}
		
		
		//����(����)
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
		
		//���
		  for(i=0;i<inwon;i++){
			System.out.printf("%10s %4d\n",name[i],score[i]);
		}
		
	
	}

}
