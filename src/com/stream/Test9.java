package com.stream;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Test9 {

	public static void main(String[] args) {
		
		
		try {
			
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out4.txt");
			
			PrintStream ps = new PrintStream(fos);
			
			//����Ҷ� �����
			//ps�� fos�� �����ش�.
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String str;
			
			System.out.println("���ڿ��� �Է��ϼ���!");
			
			while((str = br.readLine())!=null){
				ps.println(str);
				// printStream���� ���� �޼ҵ�
				
				//ps�� ����ϰ� �ȴ�.
				
				
				
			}
			ps.close();
			fos.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
