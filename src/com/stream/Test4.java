package com.stream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

//OutputStreamReader

public class Test4 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.println("���ڿ� �Է�:");
		Reader rd = new InputStreamReader(System.in);
		
		Writer wr = new OutputStreamWriter(System.out);//��±⸦ �ϳ� �����.
		
		
		while((data=rd.read())!=-1){//rd.read
			//wr.write
			
			wr.write(data);
		    wr.flush();//ȭ��ǿ� ���⹰�� ������ٴ� ��
		    //writer�� �ݵ�� flush�� ���־�� ������.

		}
		
		

	}

}
