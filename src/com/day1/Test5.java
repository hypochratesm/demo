package com.day1;

import java.io.*;

class Test5 {



	public static void main(String[] args) throws Exception {

		// throws Exception br.readline�� ���� ���� �� ���־�� �Ѵ�.


		//�̸�,����,���������� ������� ������ ���

		//����


		String name; // ���ڸ� �Է��ϱ� ���� Ŭ����
		int kor,eng,tot; // ���ڸ� �Է��ϱ� ���� Ŭ����

		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

		//�Է�

		System.out.print("�̸�?");//suzi
		name = br.readLine();  // �̸��� �����̱� ������ ����ȯ�� ����.

		System.out.print("����?");//60
		kor = Integer.parseInt(br.readLine());

		System.out.print("����?");
		eng = Integer.parseInt(br.readLine());

		//����

		tot = kor + eng;

		//���

		System.out.printf("�̸�:%s ����: %d\n",name,tot);






		
	}
}
