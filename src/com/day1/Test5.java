package com.day1;

import java.io.*;

class Test5 {



	public static void main(String[] args) throws Exception {

		// throws Exception br.readline을 쓰기 위해 꼭 써주어야 한다.


		//이름,국어,영어점수를 물어봐서 총점을 계산

		//선언


		String name; // 문자를 입력하기 위한 클래스
		int kor,eng,tot; // 숫자를 입력하기 위한 클래스

		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

		//입력

		System.out.print("이름?");//suzi
		name = br.readLine();  // 이름은 문자이기 때문에 형변환이 없다.

		System.out.print("국어?");//60
		kor = Integer.parseInt(br.readLine());

		System.out.print("영어?");
		eng = Integer.parseInt(br.readLine());

		//연산

		tot = kor + eng;

		//출력

		System.out.printf("이름:%s 총점: %d\n",name,tot);






		
	}
}
