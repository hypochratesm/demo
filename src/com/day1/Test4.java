package com.day1;

import java. io.*;

class Test4 {
	
	public static void main(String[] args) throws IOException {

        //java.io -> package
		//System.in : Ű���带 ���� 1byte(1byte�� 1bit 1024���� ��ģ �� = ����, Ư������ ���ĺ� a�� ���� �� �� �ִ� ���� ���ĺ��� ������� �ʴ� ������ ������ 2 byte)�� ���ڸ� �Է¹���
		//InputStreamReader : System.in ���� �Է¹��� 1byte ���ڸ� �츮�� ������ �� �ִ� 2����Ʈ�� ���ڷ� �������ش�.
		//BufferedReader : ����(�޸�)�� ������ �����ش�.







	
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)); // �̹� � ������ �� �� �ִ� Ŭ������. 

		 //br�� ���� ���ڴ� ���ڷ� �ν��Ѵ�. readline�� ���� �ν��ϰ� �ȴ�.

			int r;
			double a,l;
			
			System.out.print("������?");



				r = Integer.parseInt(br.readLine());

				a = r*r*3.14;
			    
                l = r*2*3.14;
					

				System.out.println("������" + r);
				System.out.println("����" + a);
			    System.out.println("�ѷ�"+ l);





	}
}
