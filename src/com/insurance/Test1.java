package com.insurance;

import java.util.Random;
import java.util.Scanner;

//����ڰ� �Է��� ���ǿ� �´� ���� ��ǰ �˻�
public class Test1 {

	public void calulator() {
		// �Ⱓ - fixed
		// �ݾ�(�� ���Ա�) - �ݾ��� ����
		// ����� ����� �󸶾� �ִ���
		// �� ���Աݿ� ���� ���ڸ� ����ؼ� �� �ݾ� ���ϱ�
		// �ٽ� ������������ �Ѵ޿� �󸶳� �������� �˾ƾ���
		Scanner sc = new Scanner(System.in);

		double totprice;

		StringBuffer sb = new StringBuffer();

		System.out.println("���̸� �Է����ּ���");
		sb.append(sc.next());

		long age = 0;

		if (sb.length() < 3) {
			age = Long.parseLong(sb.substring(0, 2));
			System.out.println(age);

		} else {
			age = Long.parseLong(sb.substring(0, 3));
			System.out.println(age);
		}
		System.out.println();
		System.out.println();

		Scanner coin = new Scanner(System.in);

		System.out.println("���� �ϽǼ� �ִ� ����Ḧ �Է����ּ���(�� ����)");
		sb.append(coin.nextLong());

		long price = 0;

		if (sb.length() < 3) {
			price = Long.parseLong(sb.substring(2));
			System.out.println(price);

		} else {
			price = Long.parseLong(sb.substring(3));
			System.out.println(price);
		}
		System.out.println("�� ���Է��" + price + "�� �Դϴ�.");
		System.out.println();
		System.out.println();
		System.out.println("�����Ͻð� ������ �Ⱓ�� �Է����ּ���(���)");

		int year = sc.nextInt();

		int month = year * 12;

		totprice = (long) (price + price * 0.02) * month;

		if (totprice <= 0) {
			return;
		} else if (totprice > 1000000 && totprice < 2000000) {
			System.out.println("����� ����� �ٷΰǰ�����");
			System.out.println("������" + totprice + "�Դϴ�");
		} else if (totprice > 2000000 && totprice < 3000000) {
			System.out.println("��ݸ��� ���� 1��");
			System.out.println("������" + totprice + "�Դϴ�");
		} else if (totprice > 3000000 && totprice < 4000000) {
			System.out.println("��ݸ��� ���� 2��");
			System.out.println("������" + totprice + "�Դϴ�");
		} else if (totprice > 4000000) {
			System.out.println("Ư�ຸ�谡���� �����մϴ�.");
			System.out.println("������" + totprice + "�Դϴ�");
			System.out.println("��ǰ��õ�� �����մϴ�.");
			
			
			Test1 ts = new Test1();
			ts.goods();
		}

	}

	public void goods() {

		System.out.println("�������� �ſ� �ڵ����� ��ǰ��õ�� �����մϴ�.");

		
		int rd = new Random().nextInt(1000000);

		System.out.println("��ǰ��ȣ��" + rd + "�Դϴ�");
		
		

	}

	public static void main(String[] args) {

		Test1 ts = new Test1();

		ts.calulator();
	}
}
