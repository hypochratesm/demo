package com.day3;

import java.util.*;

public class Test7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n;
   
		
		System.out.println("1~3�̳��� ��");//1,2,3
		n = sc.nextInt();
		
		switch(n){
		
		case 3:
			System.out.println("*");
			break;
		case 2:
			System.out.println("**");
			break;
		case 1:
			System.out.println("***");
			break;
        default : //Else�� ��������
        	System.out.println("�����Է� ����!");
        	break; //�Ƚ��� �� �ִ°� �����ϰ� �����Ѵ�.
        	
        	
		}
		
		
		
		
		
		
	}
}
