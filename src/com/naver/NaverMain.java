package com.naver;

import java.util.Scanner;

public class NaverMain {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Naver ob = new NaverImpl();

		int ch;
		while (true) {

			do {

				System.out.println("1.회원가입 2.회원전체출력 3.아이디검색 4.종료");

				ch = sc.nextInt();

			} while (ch < 1);

			switch (ch) {

			case 1:
				try {
					ob.input();	
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				try {
					ob.print();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				ob.findId();
				break;
			default:
				System.out.println("종료합니다..");
				System.exit(0);

			}

			System.out.println();

		}

	}

}
