package com.health;

import java.util.Scanner;



public class HealthMain {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		Health ob = new HealthImpl();

		int ch;
		while(true){

			do{
				System.out.println("1.�Է� 2.��� 3.���� 4.���� 5.ȸ����ȣ�˻� 6.ȸ��������ȸ7.ȸ���鳪�̼�8.����");
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
				System.out.println("�����մϴ�...");
				System.exit(0);


			}
		}

	}

}
