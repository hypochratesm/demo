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
			
		   System.out.println("시행 수?");
		   play = sc.nextInt();	   
		}while(play<1||play>10);
		
		
		
		bor = new Board[play];
		
		
	}
	@Override
	public void input() {//데이터를 넣어주는 역할
		
		for(int i =0; i<play;i++){
			
			bor[i] = new Board();
			
			
			System.out.println("이름?");	
			bor[i].name = sc.next();
			
			
			
			System.out.println("1점?");	
			bor[i].ring = sc.nextInt();
			
			System.out.println("2점");	
			bor[i].bull= sc.nextInt();
			
			System.out.println("3점");	
			bor[i].eye = sc.nextInt();
			

			System.out.println("4점");	
			bor[i].tripe = sc.nextInt();
		
			
			
		
			bor[i].tot = (bor[i].ring*1)+(bor[i].bull*2)+(bor[i].eye*3)+(bor[i].tripe*4);
		
		}
		
	}
	     
	   
	     
	@Override
	public void print() {
		
		String pan;
    	  
    	  if(bor[i].tripe>5){
 			 pan = "특등사수";
 	     }else if(bor[i].tripe>4){
 			 pan = "1등사수";
 	     }else if(bor[i].tripe>3){
 			 pan = "2등사수";
 	     }else if(bor[i].tripe>2){
 			 pan = "하수";
 		 }else {
 			 pan = "안해본 사람";
 		 }
    	  
    	  
		
		for(int i=0; i<play;i++){
			
			System.out.printf("이름 : %2s\n" ,bor[i].name);
			System.out.printf("1점 : %2s\n" , bor[i].ring);
			System.out.printf("2점 : %2s\n" , bor[i].bull);
			System.out.printf("3점 : %2s\n" , bor[i].eye);
			System.out.printf("4점 : %2s\n" , bor[i].tripe);
			System.out.printf("총점 : %2s\n" , bor[i].tot);
			System.out.printf("등급:  %5s\n" , pan);
			
			
			
	}
	
	
}
	
	
	
	

	}
