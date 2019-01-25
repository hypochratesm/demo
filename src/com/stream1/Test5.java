package com.stream1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//DataInputStream
//boolean,byte,char,int,long,float,double//자료형 그대로 저장을 한다.
//등과 같은 자료형을 직접 읽을 수 있게 해주고 플랫폼과
//무관하게 동작된다.

public class Test5 {

	public static void main(String[] args) {
		
		try {
			
			FileOutputStream fos = new FileOutputStream("d:\\doc\\data.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeUTF("대한민국");
			dos.writeByte(10);
			dos.writeChar('A');
			dos.writeInt(20);
			dos.writeUTF("서울");
			
			fos.close();
			
			FileInputStream fis = new FileInputStream("d:\\doc\\data.txt");
			DataInputStream dis = new DataInputStream(fis);
			
			System.out.println(dis.readUTF());//유니코드의 바이트 형태를 그대로 읽어온다.
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
			//그대로 저장하고 그대로 실행 하게 된다.
			fis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

	}

}
