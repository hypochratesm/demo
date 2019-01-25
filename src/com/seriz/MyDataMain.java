package com.seriz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyDataMain {

	public static void main(String[] args) {
	
	
	   try {
		   
		 //직렬화
			FileOutputStream fos =new FileOutputStream("d:\\doc\\a2.txt");
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(new MyData("홍길동", 90));
			oos.writeObject(new MyData("이길동", 10));
			oos.writeObject(new MyData("최길동", 60));
			oos.writeObject(new MyData("김길동", 70));
			oos.writeObject(new MyData("박길동", 80));
			
			oos.close();
			fos.close();
			
			System.out.println("저장성공!!");
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		
		
		
		
		try {
			
			//역직렬화(역으로 직렬화된 파일을 꺼내오는 작업)
			
			FileInputStream fis = new FileInputStream("d:\\doc\\a2.txt");
			
			ObjectInputStream ois = new ObjectInputStream(fis);
		
			MyData ob = null;//클래스를 초기화 시킬때에는 무조건 null로 시킨다.
			
			while(true){
				
				ob=(MyData)ois.readObject();
				
				if(ob==null)
					break;
				
				System.out.println(ob.toString());
				
			}
			
			
			
			ois.close();
			fis.close();
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		

	}

}
