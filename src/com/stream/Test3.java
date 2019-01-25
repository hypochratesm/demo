package com.stream;
//기억하자
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

//InputStramReader//꼭 짝이 있다.//독자적으로 쓰일수 없다.
//1byte의 Stream을 2byte Stream으로 변환해주는 Stream
//브릿지 스트림 //누군가가 꺼내온것을 변환해서 넘겨주는 역할을 하기 때문에.
public class Test3 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.println("문자열 입력:");
		
	    Reader rd = new InputStreamReader(System.in);//읽어온 데이터를 우리가 이해하는 문자로 바꿔서 rd에 넣어준다.
	    //읽어낸 데이터를 담는 변수,무조건 담는 형태
	    //READER는 읽은 내용을 저장하는 범용적인 공간.
	    
	    
	    while((data = rd.read())!=-1){
	    	
	    	char ch = (char)data;
	    	System.out.print(ch);
	    	
	    	//실행하고 나서 계속 실행되어 있다.
	    	
	    	
	    }

	}

}
