package com.score2;

import java.util.Scanner;

public class ScoreImpl implements Score{

	 Scanner sc = new Scanner(System.in);
	
	private int inwon;
	private Record[] rec;
	
	
	@Override
	public void set() {
	    
	   
	    
	    do{
	    	System.out.println("인원수?");
	    	inwon = sc.nextInt();
	    }while(inwon<1||inwon>10);
	    
	    rec = new Record[inwon];
	    
	    
	} 
	
	@Override
	public void input() {//데이터를 넣어주는 역할
		
		for(int i =0; i<inwon;i++){
			
			rec[i] = new Record();
			
			System.out.println("학번?");	
			rec[i].hak = sc.next();
			
			System.out.println("이름?");	
			rec[i].name = sc.next();
			
			System.out.println("국어?");	
			rec[i].kor = sc.nextInt();
			
			System.out.println("영어?");	
			rec[i].eng = sc.nextInt();
			
			System.out.println("수학?");	
			rec[i].mat = sc.nextInt();
			
			rec[i].tot = rec[i].kor + rec[i].eng + rec[i].mat;
			rec[i].ave = rec[i].tot/3;
		}	
		
	}
       private String panjung(int score){
    	   
    	   String pan =null;
    	   
    	   
    	    
    	   switch (score/10){
    	   
    	   case 10:
    	   case 9:
    		   pan = "수"; break;
    	   case 8:
    		   pan = "우"; break;
    	   case 7:
    		   pan = "미"; break;
    	   case 6:
    		   pan = "양"; break;
    	   default: 
    		   pan = "가"; break;
    		   
    		   
       }
    	   
    	   return pan;
      }
       
       
	@Override
	public void print() {
		
		
	    
		
		
		for(int i=0; i<inwon;i++){
			System.out.printf("학번 : %2s",rec[i].hak);
			System.out.printf("이름 : %2s",rec[i].name);
			System.out.printf("국어 : %2d %s\n",rec[i].kor,panjung(rec[i].kor));
			System.out.printf("수학 : %2d %s\n",rec[i].mat,panjung(rec[i].mat));
			System.out.printf("영어 : %2d %s\n",rec[i].eng,panjung(rec[i].eng));
			System.out.printf("%4d" ,rec[i].tot);
			System.out.printf("%4d" ,rec[i].ave);
			
			//1111 홍길동 90(수) 80 70 210 70
			//            수     우 미 
		 
			/*for(int i=0; i<inwon;i++){//선생님이 해주신 것
				
				System.out.println("%s %s %d %d %d %d\n");
				   rec[i].hak,rec[i].name,rec[i].kor,
				   rec[i].eng,rec[i].mat,rec[i].tot,
				   rec[i].ave);
				   
				 System.out.printf("9s %s %s\n" ,panjung(rec[i].kor),  panjung(rec[i].eng),panjung(rec[i].mat));*/
				   
				   
				   
			}

		
		
			
			
			
			
		}			
			
			
			
			
			
					
		
		
		
		
		
		
		
		
		
		
	}


