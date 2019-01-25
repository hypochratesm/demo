package com.seriz;

import java.util.Scanner;

public class HomeMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		HomeImpl ob = new HomeImpl();
		
		int ch;
		
		ob.open();
		
		while(true){
			do{
				System.out.println("1.입력\n2.출력\n3.저장\n4.로딩\n5.종료");
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
				ob.save();
				break;
				
			case 4:
				ob.load();
				break;
			
			default:
			    System.out.println("종료합니다...");
				System.exit(0);
	
			sc.close();
	
			}
		}

	}

}
