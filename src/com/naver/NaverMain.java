package com.naver;

import java.util.Scanner;

public class NaverMain {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Naver ob = new NaverImpl();

		int ch;
		while (true) {

			do {

				System.out.println("1.ȸ������ 2.ȸ����ü��� 3.���̵�˻� 4.����");

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
				System.out.println("�����մϴ�..");
				System.exit(0);

			}

			System.out.println();

		}

	}

}
