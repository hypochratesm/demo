package com.insurance;

import java.util.Scanner;

public class Test2 {

	public void lotto() {

		Scanner sc = new Scanner(System.in);
		int[] lotto = new int[6];
		int k = 0;

		boolean endgame = false;

		System.out.println("���Ӽ��� �������ּ���");
		int game = sc.nextInt();
		int m=0;
		// ��ȣ����
		while (!endgame) {
			m++;
			k=0;
			for (int i = 0; i < lotto.length; i++) {
				k++;
				lotto[i] = (int)(Math.random()*45 + 1);
				if (k==6) {
					break;
				}
				//�ߺ�����
				for (int j = 0; j < i; j++) {
					if (lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}
			}
				System.out.println(m+"��° ����");	
		// ����
			int num = 0;
			for (int i = 0; i < lotto.length; i++) {
				for (int j = 0; j < i; j++) {
					if (lotto[i] < lotto[j]) {
						num = lotto[j];
						lotto[j] = lotto[i];
						lotto[i] = num;
					}
				}
			}
			for (int i = 0; i < lotto.length; i++) {
				System.out.print("["+lotto[i] + "]");
			}
			System.out.println();
			if (m==game) {
				System.out.println();
				System.out.println("������ �����Ǿ����ϴ�");
				break;
			}
		}
	}

	public static void main(String[] args) {

		Test2 ts2 = new Test2();
		ts2.lotto();
	}
}
