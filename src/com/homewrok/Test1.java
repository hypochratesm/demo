package com.homewrok;

import java.util.Random;
import java.util.Scanner;

class MyThread1 extends Thread {

	private int num; // ���� �ο���

	 Random rd =new Random();

	String[] name = { "�忹��", "��ȫ��", "�ֿ���", "����", "������", "������", "�强��", "�ѽ´�",
			"������", "������", "�贩��", "������", "��뱤", "������", "������", "�̾��", "�����",
			"������", "���Ѱ�", "������", "�Ӵܺ�", "���س�", "������", "������", "�ڿ���", "��ο�",
			"������", "�ڸ�", "�㵵��", "�Ż�" };

	public MyThread1(int inwon) {
		this.num = inwon;
	}

	@Override
	public void run() {
		int i = 0;
		int[] arr = new int[num];
		
		
		//������
		System.out.print("�����.");
		while (i < 10) {

			System.out.print(".");
			try {
				sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}
		System.out.println();
		//������ ����
		
		

		for (int j = 0; j < num; j++) {
			
			int n = rd.nextInt(30);
			
			arr[j] = n;
		
			for (int k = 0  ; k < j ; k++) {
				if (arr[k] == n) {
					j--;
					break;
				}
			}
		}
		
		for(int k = 0 ; k < num ; k++){
			System.out.println((k+1) + "�� ��ǥ�� " + name[arr[k]]);
		}

	}
}

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��ǥ�� �ο��� ? ");
		int inwon = sc.nextInt();

		MyThread1 ob1 = new MyThread1(inwon);
		ob1.start();

	}

}

