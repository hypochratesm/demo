package com.highschool;

import java.util.Scanner;

public class Grade {

	Scanner sc = new Scanner(System.in);
	
    
	int inwon;
	int i;
	int j;
	Activity[] act;
	
	public void set(){
		
		do{
			System.out.print("�ο���?:");
			inwon = sc.nextInt();	
		}while(inwon<1||inwon>10);
		
		
		
		act = new Activity[inwon];//�迭�� ��ü�� ������ ��.
	}
	 
	public void input(){
		
		String[] title = {"����?","����?","����?"};
		for(int i=0;i<inwon;i++){
			
			act[i] =  new Activity();//�迭�� ��ü�� ����
			
			System.out.print((i+1)+"��° �̸�?");
			act[i].name = sc.next();
			
			for(int j=0;j<3;j++){
				
				System.out.print(title[j]);
				act[i].score[j] = sc.nextInt();
				
				
				if(act[i].score[j]>=90){
			     }else if(act[i].score[j]>=80){
			     }else if(act[i].score[j]>=70){
			     }else if(act[i].score[j]>=60){
				 }else {
				 }
				
				act[i].tot+=act[i].score[j];
			}   
	

			act[i].ave = act[i].tot/3;//���
			
		}
	}
	
	


	
	
	 public void print(){
		 
		 
		 for(int i =0; i<inwon;i++){
			 System.out.printf("%6s",act[i].name);
			 
			 for(int j=0;j<3;j++){
				System.out.printf("%4d" +"("+"pan" +")",act[i].score[j]);
			 }
			    System.out.printf("%4d",act[i].tot);
				System.out.printf("%4f",act[i].ave);
				System.out.printf("%4d\n",act[i]);

			 
		 }
	 }
		
		
		
	
	
	
	
}
