package com.day1;

import java.io.*;

class Test6 {
	
	
	public static void main(String[] args) throws Exception  {

		//�غ�(w)�� ����(h)�� �Է¹޾� �ﰢ���� ����(a) ���ϱ�
		//�غ�? 10
		//����? 20
		//���� : xx
		//���� : �غ�*����/2

		int w,h,a;


		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));


		System.out.print("�غ�?");
		w = Integer.parseInt(br.readLine());

		System.out.print("����?");
		h = Integer.parseInt(br.readLine());

		a = w*h/2;//�ڹٴ� �Ҽ����� ������ ������ �Ǽ��� �ν��Ѵ�

		 // ������ ����ϸ� �Ǽ��� ����� �� �ִ�.
		 // (double)w*h/2.0���ε� ����� �� �ִ�. double�� w���� ����ȴ�.
		 //�ڿ� ������ ���� ����� �ٲ�ٰ� �����ص� �ȴ�.
		 //�� ���� ���¸� ��������ȯ�̶�� �Ѵ�.
		 //��ĳ��? (����������� ������ �ʴ´�.)

		System.out.println("����"+a);//+�� ���ڿ��� ������ �Է��ϱ� ���� ���ش�.




		
	}
}
