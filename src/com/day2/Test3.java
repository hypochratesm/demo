package com.day2;

import java.io.*;

class Test3 {

	public static void main(String[] args) throws IOException{

       //char ch ='a'; �ʱ�ȭ�� �̷��� ��Ų��//�ݵ�� ���� ����ǥ�� �ۼ�
	   //char�� ��ȣ�� ��� �׸�, ASCII(�� ���� ���󺰷� �ٸ�),UNICODE�� �����Ѵ�.
	   //"a"�� �츮�� �˰� �ִ� a
	   //'aa'�� �Է��� �Ұ��� �ϴ�. ������ �� ���ڸ� ���� �� �� �ִ�.

	   char ch,result;

	   System.out.print("�ѹ���?");//a(97)

	   ch = (char)System.in.read();//��ȯ���� int
	   
	   //�ڵ����� 97�̶�� ������ ����ȭ�� �ϰ� ch�� �־������. int�� char�� �������� �ϴ� ���� �ʴ´�.

	   result = ch>=65 && ch<=92?(char)(ch+32):
		   (ch>='a'&& ch<='z'?(char)(ch-32):ch);

		

	
	   System.out.println(ch+":"+result);
	
	   System.out.println(ch);
	   System.out.println(Integer.toString(ch)); //97�̶�� ���ڰ� ����ȭ �Ǽ� �������°�.
	   
	   //65= A , 92= Z

	   //result�� ��ȣ�� �����Ѵ�.

  
        

       
		
	}
}
