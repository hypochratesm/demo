package com.stream1;
//기억하자

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test2 {
	
	
	public final static int BUFFER_SIZE = 512;//final로 만들었기 때문에 대문자로 쓴다.

	public static void main(String[] args) {
		
		
		byte[] buffer = new byte[BUFFER_SIZE];
		
		try {
			
			FileInputStream fis = new FileInputStream("d:\\doc\\test.txt");
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out6.txt");
			
			//************Buffer로 한번 더 감싸준다.//파일의 크기가ㅣ 너무 크기때문에 fis에 모든 데이터를 담기가 부담스럽다********.//중요
		    BufferedInputStream bis = 
		    		new BufferedInputStream(fis);
		    BufferedOutputStream bos = 
		    		new BufferedOutputStream(fos,BUFFER_SIZE);
		    //buffer size는 생략이 가능하다 // 이 사이즈로 내보낼 것이다
		    
		    int n,len = 0;
		    while((n = bis.read(buffer))!=-1){
		    	
		    	System.out.println("읽은 문자 길이:" + n );
		    	len+=n;
		    	
		    	bos.write(buffer,0,n);
		    	bos.flush();
		    	
		    }
		    
		    System.out.println("읽어들인 전체 길이:" + len);
		    
		    fis.close();
		    fos.close();
		    bis.close();
		    bos.close();
		    
		   
		} catch (Exception e) {
			
		}
		

	}

}
