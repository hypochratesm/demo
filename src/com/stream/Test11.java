package com.stream;

import java.io.File;
import java.io.IOException;
import java.util.Date;

//File 클래스 
//파일의 입출력은 불가능.- 파일의 입출력은 파일아웃풋스트림 인풋트스트림밖에 없다

//파일 및 폴더를 관리 할 수 있도록 기능을 제공해주는 클래스
//파일의 복사 또는 이름변경 등의 조작을 할 경우에 사용될 뿐 
//파일의 내용을 입출력 하기 위한 메소드는 제공하지 않는다.


//웹의 주소가 uri(https://www.naver.com)
public class Test11 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("d:\\doc\\test.txt");
		
		System.out.println("파일 정보........");
		System.out.println("파일명:" + f.getName());
		System.out.println("파일길이:" + f.length());
		System.out.println("파일경로:" + f.getAbsolutePath());
		System.out.println("표준경로:" + f.getCanonicalPath());
		System.out.println("만든 날 " + new Date(f.lastModified()));//date는 calendar보다 훨씬 작아 오늘 날짜만 보여준다.
		System.out.println("파일상위폴더경로:" + f.getParent());
		System.out.println("읽기 속성:" + f.canRead());
		System.out.println("쓰기속성:" + f.canWrite());
		
		
		
		//현재 경로//기억하자//내가 원하는 특정폴더를 사용한다면 쓰지 않아도 된다.
		String path = System.getProperty("user.dir");
		System.out.println("현재경로:" + path);
		

	}

}
