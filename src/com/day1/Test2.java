package com.day1;

class Test2{ 

	public static void main(String[] args){

        //int : ������ �ڷ��� �Ҽ��� �Ұ�
		int a=20;//���Կ�����
		int b=5;
		int c,d;//������ ���� �� �ִ�//���⼭ ���� �� ���� ���Ͽ� �ʱ�ȭ �Ѵ�.

		// int���� �����͸� ���� �� �ִ�.
		// �ѱ��� ���� �� ����

		System.out.println(a);//�޸𸮿� �ִ� ���� ��°�
		System.out.println(b);
		//System.out.println(c);//�����Ⱚ�� �� �� ���� ������ �ʱ�ȭ ���� �ʾҴ�
		
		c=a+b;//������ �� �ȿ� ����մ� ������ �������� // ������ �����ʿ��� �������� �ִ� ���� ������.
		System.out.println(c);//25

		d=a-b;
		System.out.println(d);//������ �� �ȿ� ����ִ� ������ �ڵ����� �����ȴ�//15

		b=10;//b���� ���� 10�� �� �ְ� �ȴ�.

		c=a+b;
		
		System.out.println(c);//30

		System.out.println(d);//15

		System.out.println(a+"+"+b+ "="+c);//���� ���ϱ�� �ٿ������ ��//�ڹٴ� ���ڸ� �ν��� �� ���� ������ ������ �ڵ��־�� �Ѵ�.

		System.out.printf("%d+%d=%d\n" ,a,b,c);//%d ���ø� 10���� ����//%n�� ����//\n�� �����ٷ� ��������//println���� %�� ����� �� ����. %d�� �������� ������ִ� �ñ׳��� ����

		System.out.printf("%d-%d=%d\n" ,a,b,c);//f������ ����̶�� ��//%d�� ������ abc�� ������ �ڸ��� ����//printf�� ���Ͱ� ����

	}
}
