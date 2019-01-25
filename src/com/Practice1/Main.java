package com.Practice1;

import java.util.Scanner;

public class Main {

	public static int print(int n) {

		if (n == 1) {

			return n;

		} else {
			System.out.println((n));
			return print(n - 1);

		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Main ob = new Main();

		System.out.println(print(sc.nextInt()));

	}

}
