package com.stream;
//반드시 기억하자
import java.io.FileInputStream;

//파일내용 입출력
//FileInputStream
//FileOutputStream
//파일의 내용을 읽어오는 방법이다.

public class Test5 {

	public static void main(String[] args) {
		
		
		try {
			
			FileInputStream fis = new FileInputStream("d:\\doc\\test2.txt");//객체생성이 될때 파일을 읽어와야만 한다.
			
			//파일에 있는 내용을 가지고 와서 출력을 한다.
			
			//ms나 한글은 읽어올 수 없다. 이들은 그들의 고유한 방식으로 데이터를 저장 하기 떄문에 호환 되지 않는다.
			
			int data;
		
			while((data=fis.read())!=-1){
				
				
				
				//System.out.print((char)data);
				
				System.out.write(data);
				
				
				//마지막 패킷은 전송 되지 않는다.
				
			    System.out.flush();
			    //마지막 패킷을 파일로 읽어온다.
				
				
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			
		}
		
		
		
		
		

	}

}
