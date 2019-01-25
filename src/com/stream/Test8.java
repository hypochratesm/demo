package com.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test8 {
	
	public boolean fileCopy(String str1,String str2){
		
		File f = new File(str1);
		
		if(!f.exists()){//코딩이 길기 때문에 느낌표를 주었다.//파일이 없다면...
			return false;//스탑!
			
		}
		
		try {
			
			FileInputStream fis = new FileInputStream(f);
			//f와 str1 을 써도 상관없다.
			FileOutputStream fos = new FileOutputStream(str2);
			
		
			int data;
			byte[] buffer = new byte[1024];//buffer에 담을 수 있는 데이터의 용량이 늘어난다.
			//한번에 1바이트씩 나르던 것을 1024씩 나른다.
			
			while((data = fis.read(buffer,0,1024))!=-1){
				//0번부터 마지막 자리까지 버퍼에서 꺼내서 data에 있는 양만큼 읽는다.
				fos.write(buffer,0,data);
				
			}
			
			fos.close();
			fis.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
		
		
		
		
		
	}

	
	public static void main(String[] args){
		
		Test8 ob = new Test8();
		
		if(ob.fileCopy("d:\\doc\\test.text","d:\\doc\\out3.txt")){
		System.out.println("파일복사 성공");
		
		}else{
			System.out.println("파일 복사 실패");
			
		}
	

			
		
		
		
		
	}
}
