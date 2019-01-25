package com.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		
		//원본파일? d:\\doc\\test.txt
		//대상파일? d:\\doc\\out2.txt
		//복사완료!!
		Scanner sc = new Scanner(System.in);
		String str1,str2;
		int data;
		
		
		try {
			
			
			System.out.print("원본파일?");
			str1 = sc.next();
			
			System.out.print("대상파일?");
			str2 =sc.next();
			
			
			FileInputStream fis = new FileInputStream(str1);
			FileOutputStream fos = new FileOutputStream(str2);
			
			//str1 -> fis ->입력하는 파일의 정보->fos->str2
			
			
			
			while((data = fis.read())!=-1){
				//읽어주고 쓰는것이 핵심!
				fos.write(data);
				fos.flush();
			}
			
			fis.close();
			fos.close();
			
			System.out.println("복사완료!!");
			
			
			
		} catch (Exception e) {
			
		}
		
		
	}
	

}
