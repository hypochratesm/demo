package com.win1;

import java.util.Scanner;

public class WinMain {
	
	public static void main(String[] args) {
		
	 Scanner sc = new Scanner(System.in);
	 Win1 ob = new WinImpl();
	 
	 
	 int ch;
	 while(true){
		 
		 do{
			 System.out.println("1.입력\n2.출력\n3.이름검색\n4.총점내림정렬\n5.등급올림정렬\n6.종료\n");
			 ch = sc.nextInt();
			 
		 }while(ch<1);
		 
		 switch(ch){
		 
		 case 1:
			 ob.input();
		     break;
		     
		 case 2:
			 ob.print();
			 break;
			 
		 case 3:
			 ob.searchName();
			 break;
		
		 case 4: 
			 ob.descSortTot();
		     break;
		     
		 case 5:
			 ob.ascSortank();
			 break;
		 
		 default : 
			 System.out.println("종료합니다....");
			 System.exit(0);
			 
		 }
	   }
	}
}
