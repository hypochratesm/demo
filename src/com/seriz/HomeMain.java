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
				System.out.println("1.�Է�\n2.���\n3.����\n4.�ε�\n5.����");
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
			    System.out.println("�����մϴ�...");
				System.exit(0);
	
			sc.close();
	
			}
		}

	}

}
