package com.score4;//���

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		
		
		Scanner sc =new Scanner(System.in);
		Score ob = new ScoreImpl();
		
		int ch;
		while(true){
			
			do{
				System.out.println("1.�Է� 2.��� 3.���� 4.���� 5.�й��˻� 6.�̸��˻� 7.����");
				ch = sc.nextInt();
			}while(ch<1);
			
			switch(ch){
			
			case 1:
				ob.input();//��ȯ���� �ȹ޾Ƶ� �ȴ�//�ڹٰ� �����ϴ�.
				break;
				
			case 2://���
				ob.print();
				break;
				
			case 3://����
				ob.delete();
				break;
			
			case 4://���� - �̸��� �����̵Ǹ� �ȵǰ� ������ ������ ���־���Ѵ�.
				ob.update();
				break;//�й��˻�
				
			case 5://�̸��˻� - �����͸� ���Ѵ�.
				ob.findHak();
				break;
				
			case 6://����
				ob.findName();
				break;
				
			default:
			    System.out.println("�����մϴ�...");
				System.exit(0);
			
			}
			//yes no cancel..// �� �ƴϿ� ���  ( 0   1   2 )
		}
	
	}

}
