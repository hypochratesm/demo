package com.stream;


import java.io.FileOutputStream;

//파일내용 출력
////FileOutputStream

public class Test6 {

	public static void main(String[] args) {
		
		try {
			
			
			
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out.txt");
			
			//사용자가 입력한것을 파일로 내보낸다.
			
			int data;
			
			
			System.out.println("문자열 입력");
			
		    while((data=System.in.read())!=-1){
		    	
		    	
		    	fos.write(data);
		    	fos.flush();
		    }
		    
		    fos.close();//사용한 것은 항상 닫아줘야 다음번에 에러가 발생하지 않는다.
			
			
		} catch (Exception e) {
			
		}

	}

}
