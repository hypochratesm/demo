package com.stream1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//DataInputStream
//boolean,byte,char,int,long,float,double//�ڷ��� �״�� ������ �Ѵ�.
//��� ���� �ڷ����� ���� ���� �� �ְ� ���ְ� �÷�����
//�����ϰ� ���۵ȴ�.

public class Test5 {

	public static void main(String[] args) {
		
		try {
			
			FileOutputStream fos = new FileOutputStream("d:\\doc\\data.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeUTF("���ѹα�");
			dos.writeByte(10);
			dos.writeChar('A');
			dos.writeInt(20);
			dos.writeUTF("����");
			
			fos.close();
			
			FileInputStream fis = new FileInputStream("d:\\doc\\data.txt");
			DataInputStream dis = new DataInputStream(fis);
			
			System.out.println(dis.readUTF());//�����ڵ��� ����Ʈ ���¸� �״�� �о�´�.
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
			//�״�� �����ϰ� �״�� ���� �ϰ� �ȴ�.
			fis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

	}

}
