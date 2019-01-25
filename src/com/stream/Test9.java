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
			
			//출력할때 사용함
			//ps로 fos를 감싸준다.
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String str;
			
			System.out.println("문자열을 입력하세요!");
			
			while((str = br.readLine())!=null){
				ps.println(str);
				// printStream에서 나온 메소드
				
				//ps로 출력하게 된다.
				
				
				
			}
			ps.close();
			fos.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
