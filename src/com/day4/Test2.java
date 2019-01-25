package com.day4;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		//배열
		//int num[] = new int[5];
		int[] num = new int[5];

		Scanner sc = new Scanner(System.in);

		System.out.print(num.length + "개의 정수?");//5 6 7 9 3

		for(int i=0;i<num.length;i++){
			num[i] = sc.nextInt();
		}

		for(int i=0;i<num.length;i++){

			System.out.println("num["+ i +"]: " + num[i]);
		/*	System.out.println("num[1]: " + num[1]);
			System.out.println("num[2]: " + num[2]);
			System.out.println("num[3]: " + num[3]);
			System.out.println("num[4]: " + num[4]);*/

		}

		/*num[3] = 400;
		System.out.println("num[3]: " + num[3]);

		int a = num[0];
		System.out.println(a);
		System.out.println(num.length);//배열 length에는 괄호가 없음 쓰면 에러 length() X
		 */		

	}

}
