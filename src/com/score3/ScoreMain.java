package com.score3;//���

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		
		
		Scanner sc =new Scanner(System.in);
		Score ob = new ScoreImpl();
		
		int ch;
		while(true){
			
			do{
				System.out.println("1.�Է�\n2.���\n3.�й��˻�\n4.�̸��˻�\n5.������������\n6.�й���������\n7.����\n");
				ch = sc.nextInt();
			}while(ch<1);
			
			switch(ch){
			
			case 1:
				ob.input();//��ȯ���� �ȹ޾Ƶ� �ȴ�//�ڹٰ� �����ϴ�.
				break;
				
			case 2:
				ob.print();
				break;
				
			case 3:
				ob.searchHak();
				break;
			
			case 4:
				ob.searchName();
				break;
				
			case 5:
				ob.descSortTot();
				break;
				
			case 6:
				ob.ascSorthak();
				break;
				
			default:
			    System.out.println("�����մϴ�...");
				System.exit(0);
			
			}
			//yes no cancel..// �� �ƴϿ� ���  ( 0   1   2 )
		}
	
	}

}
