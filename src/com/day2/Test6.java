package com.day2;

import java.util.*;

class Test6 {

	public static void main(String[] args) {


  Scanner sc = new Scanner(System.in);//Scanner�� �⺻������ ������ �������� ������ �Ѵ�.
		
  String name;
  int kor,eng, mat;

  //System.out.print("�̸� ���� ���� ����?");//suzi 50 60 70// ���۵帮���� ������ �ѹ��� �� ������ ��ĳ�ʴ� ������ ������ �д°��� �����.


  System.out.print("�̸� ���� ���� ����?");//suzi 50 60 70
  sc = new Scanner (sc.next()). useDelimiter("\\s*,\\s*");  //Scanner s = new Scanner(input). useDelimiter("\\s*fish\\s*");
   
   name = sc.next();
   kor = sc.nextInt();
   eng = sc.nextInt();
   mat = sc.nextInt();

	System.out.println(name+":"+(kor+eng+mat)+ "��");
	//System.out.println(name+":"+(kor+eng+mat)+ "��");//suzi 50,60,70




	}
}
