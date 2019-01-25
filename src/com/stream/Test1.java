package com.stream;
//기억하자
import java.io.IOException;

//입출력 스트림
//데이터 입출력시 모든 데이터를 형태와 상관없이
//일련된 흐름으로 전송하는 것.

//1.바이트 스트림. - 1BYTE단위로 정보를 읽어낸다.
//System.in



public class Test1 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.print("문자열 입력:");//abcd
		while((data = System.in.read())!=-1){//입력한 문자열을 1바이트씩 읽어온다.꺼내는 순간 정수값으로 바뀐다.
			//유니코드로 입력되고 아스키값으로 읽어진다
			
			// 여기서 -1은 return하고 끝내기로 한 약속이다.
			
			char ch = (char)data;
			System.out.println(ch);
			
	//1바이트씩 읽어서 그 데이터를 캐릭터로 바꿔서 출력한다 x5(1개씩 읽어내기 때문에.)		
		}

	}

}
