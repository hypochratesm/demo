package com.stream1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

//FileReader
//파일에서 바이트를 읽어들여 문자,바이트 스트림으로 변환
//자신이 바로 2바이트로 바꾸기 때문에 인풋스트림리더가 필요없다.

public class Test4 {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileReader fr = new FileReader("d:\\doc\\test.txt");
		BufferedReader br = new BufferedReader(fr);
		
		try {
			
			String str;
			
			while((str=br.readLine())!=null){
				
				System.out.println(str);
			}
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
