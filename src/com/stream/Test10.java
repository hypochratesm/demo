package com.stream;

import java.io.FileOutputStream;
import java.io.PrintStream;


public class Test10 {

	public static void main(String[] args) {
		
		try {
			
			FileOutputStream fos;
			PrintStream ps;
			
			fos = new FileOutputStream("d:\\doc\\out5.txt");
			ps =  new PrintStream(fos);
			
			ps.println("�����");
			ps.println("������");
			ps.println("õ����");
			ps.println("Ƽ�Ĵ�");
			
			ps.close();
			fos.close();
			
			
			//true//append(�߰� ����)
			fos = new FileOutputStream("d:\\doc\\out5.txt",true);
			ps = new PrintStream(fos);
			//�������� PrintWriter�� ���� ��
			
			ps.println("�����");
			ps.println("������");
			ps.println("������");
			ps.println("���Ĵ�");
			
			ps.close();
			fos.close();
			
			
		} catch (Exception e) {
			
		}

	}

}
