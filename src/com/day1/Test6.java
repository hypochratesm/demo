package com.day1;

import java.io.*;

class Test6 {
	
	
	public static void main(String[] args) throws Exception  {

		//밑변(w)과 높이(h)를 입력받아 삼각형의 넓이(a) 구하기
		//밑변? 10
		//높이? 20
		//넓이 : xx
		//넓이 : 밑변*높이/2

		int w,h,a;


		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));


		System.out.print("밑변?");
		w = Integer.parseInt(br.readLine());

		System.out.print("높이?");
		h = Integer.parseInt(br.readLine());

		a = w*h/2;//자바는 소수점을 만나면 무조건 실수로 인식한다

		 // 더블을 사용하면 실수를 출력할 수 있다.
		 // (double)w*h/2.0으로도 출력할 수 있다. double은 w에만 적용된다.
		 //뒤에 연산한 것이 더블로 바뀐다고 생각해도 된다.
		 //이 같은 형태를 강제형변환이라고 한다.
		 //스캐너? (기술면접에는 나오지 않는다.)

		System.out.println("넓이"+a);//+는 문자열에 변수를 입력하기 위해 써준다.




		
	}
}
