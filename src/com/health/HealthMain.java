package com.health;

import java.util.Scanner;



public class HealthMain {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		Health ob = new HealthImpl();

		int ch;
		while(true){

			do{
				System.out.println("1.입력 2.출력 3.삭제 4.수정 5.회원번호검색 6.회원정보조회7.회원들나이순8.종료");
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
				ob.delete();
				break;

			case 4:
				ob.update();
				break;

			case 5:
				ob.findCod();
				break;

			case 6:
				ob.findAddr();
				break;
				
			case 7:
				ob.ascAge();

			default:
				System.out.println("종료합니다...");
				System.exit(0);


			}
		}

	}

}
