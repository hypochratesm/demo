package com.win;

import java.util.Scanner;


public class WinImpl implements Win{

	 Scanner sc = new Scanner(System.in);
	
	public  int i;
	private int play;
	private Board[] bor;
	@Override
	public void set() {
		
		
		do{
			
		   System.out.println("���� ��?");
		   play = sc.nextInt();	   
		}while(play<1||play>10);
		
		
		
		bor = new Board[play];
		
		
	}
	@Override
	public void input() {//�����͸� �־��ִ� ����
		
		for(int i =0; i<play;i++){
			
			bor[i] = new Board();
			
			
			System.out.println("�̸�?");	
			bor[i].name = sc.next();
			
			
			
			System.out.println("1��?");	
			bor[i].ring = sc.nextInt();
			
			System.out.println("2��");	
			bor[i].bull= sc.nextInt();
			
			System.out.println("3��");	
			bor[i].eye = sc.nextInt();
			

			System.out.println("4��");	
			bor[i].tripe = sc.nextInt();
		
			
			
		
			bor[i].tot = (bor[i].ring*1)+(bor[i].bull*2)+(bor[i].eye*3)+(bor[i].tripe*4);
		
		}
		
	}
	     
	   
	     
	@Override
	public void print() {
		
		String pan;
    	  
    	  if(bor[i].tripe>5){
 			 pan = "Ư����";
 	     }else if(bor[i].tripe>4){
 			 pan = "1����";
 	     }else if(bor[i].tripe>3){
 			 pan = "2����";
 	     }else if(bor[i].tripe>2){
 			 pan = "�ϼ�";
 		 }else {
 			 pan = "���غ� ���";
 		 }
    	  
    	  
		
		for(int i=0; i<play;i++){
			
			System.out.printf("�̸� : %2s\n" ,bor[i].name);
			System.out.printf("1�� : %2s\n" , bor[i].ring);
			System.out.printf("2�� : %2s\n" , bor[i].bull);
			System.out.printf("3�� : %2s\n" , bor[i].eye);
			System.out.printf("4�� : %2s\n" , bor[i].tripe);
			System.out.printf("���� : %2s\n" , bor[i].tot);
			System.out.printf("���:  %5s\n" , pan);
			
			
			
	}
	
	
}
	
	
	
	

	}
