package com.day1;

import java. io.*;

class Test4 {
	
	public static void main(String[] args) throws IOException {

        //java.io -> package
		//System.in : 키보드를 통해 1byte(1byte는 1bit 1024개를 합친 것 = 숫자, 특수문자 알파벳 a를 저장 할 수 있는 공간 알파벳을 사용하지 않는 나라의 언어들은 2 byte)의 문자를 입력받음
		//InputStreamReader : System.in 으로 입력받은 1byte 문자를 우리가 이해할 수 있는 2바이트의 문자로 변경해준다.
		//BufferedReader : 버퍼(메모리)에 저장을 시켜준다.







	
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)); // 이미 어떤 역할을 할 수 있는 클래스들. 

		 //br에 넣은 숫자는 문자로 인식한다. readline을 통해 인식하게 된다.

			int r;
			double a,l;
			
			System.out.print("반지름?");



				r = Integer.parseInt(br.readLine());

				a = r*r*3.14;
			    
                l = r*2*3.14;
					

				System.out.println("반지름" + r);
				System.out.println("넓이" + a);
			    System.out.println("둘레"+ l);





	}
}
