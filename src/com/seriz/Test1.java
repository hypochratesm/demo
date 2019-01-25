package com.seriz;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

//객체의 직렬화
//메모리에 생성된 클래스객체의 멤버변수의 현재 상태를 
//그대로 보존해서 파일에 저장하거나 네트워크를 통해 전달 할 수 있는 기능
//오로지 바이트 단위로만 데이터를 송수신 할 수 있다.

//장점은 객체자체의 내용을 입출력 형식에 구애받지 않고
//객체를 파일에 저장 함으로써 영속성을 제공 할 수 있고
//객체 자체를 네트워크를 통해 손쉽게 교환 할 수 있다.

//implements Serializable로 구현한다(단, 메소드는 없다.)

public class Test1 {

	public static void main(String[] args) throws IOException {
		
		Hashtable<String, String> hMap = new Hashtable<String, String>();
		//HashTable은 이미 구현되어 있기 때문에 내가 자료를 입력하면 직렬화가 바로 진행된다.
		
		hMap.put("1", "이효리");
		hMap.put("2", "전지현");
		hMap.put("3", "한효주");
		//직렬화
		
		FileOutputStream fos = new FileOutputStream("d:\\doc\\a1.txt");
        //단순한 파일저장
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);//upcast
		//직렬화 작업 - > hMap안에는 위의 3개의 값이 들어가 있다. 
		//그 데이터를 가지고 와서 바깥으로 내보내는 작업 
		//오브젝트아웃풋 , 직렬하된 데이터를 내보내는것.
		
		oos.writeObject(hMap);
		oos.close();
		fos.close();
		
		System.out.println("파일 내보내기 성공");
		
		
		
		
		
	}

}
