package com.prj;


import java.util.Scanner;

public class RentMain {

	public static void main(String[] args) {

		RentImpl rent = new RentImpl();
		
		Scanner sc = new Scanner(System.in);
		int ch;

		rent.carPic();


		while(true){
			try {
				do{

					System.out.println("===============================================================================================================================");
					System.out.println("                   1.�����ϱ�     |    2.������ȸ    |    3.���� �˻�    |    4.�����ڸ��    |     5.����                     ");
					System.out.println("===============================================================================================================================");
					System.out.print("�� ");
					ch = sc.nextInt();


					switch(ch){
					case 1:
						rent.input();
						break;

					case 2:
						rent.searchRes();
						break;

					case 3:
						rent.carSearch();
						break;

					case 4:
						rent.admin();
						break;
							
					case 5:
						System.out.println("                                                �� ���α׷��� �����մϴ� ��                                                 ");

						System.exit(0);	
					}

				}while(ch<1 || ch>4);

			} catch (Exception e) {
				System.out.println();
				e.printStackTrace();
				sc.next();
				System.out.println();

			}
		}
	}


}
