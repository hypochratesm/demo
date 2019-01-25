package com.day3;

import java.util.*;

public class Test7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n;
   
		
		System.out.println("1~3이내의 수");//1,2,3
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
        default : //Else와 같은쓰임
        	System.out.println("숫자입력 오류!");
        	break; //안써줄 수 있는건 과감하게 생략한다.
        	
        	
		}
		
		
		
		
		
		
	}
}
