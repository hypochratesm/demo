package com.day1;

class Test2{ 

	public static void main(String[] args){

        //int : 정수형 자료형 소수점 불가
		int a=20;//대입연산자
		int b=5;
		int c,d;//쓰레기 값이 들어가 있다//여기서 위의 두 값을 더하여 초기화 한다.

		// int형의 데이터만 넣을 수 있다.
		// 한글은 넣을 수 없다

		System.out.println(a);//메모리에 있는 값을 찍는것
		System.out.println(b);
		//System.out.println(c);//쓰레기값은 볼 수 없다 변수가 초기화 되지 않았다
		
		c=a+b;//변수는 그 안에 들어잇는 값들이 더해진다 // 이퀄은 오른쪽에서 왼쪽으로 넣는 대입 연산자.
		System.out.println(c);//25

		d=a-b;
		System.out.println(d);//변수는 그 안에 들어있는 값들이 자동으로 차감된다//15

		b=10;//b에는 현재 10이 들어가 있게 된다.

		c=a+b;
		
		System.out.println(c);//30

		System.out.println(d);//15

		System.out.println(a+"+"+b+ "="+c);//앞의 더하기는 붙여쓰라는 뜻//자바는 문자를 인식할 수 없기 때문에 일일이 코딩주어야 한다.

		System.out.printf("%d+%d=%d\n" ,a,b,c);//%d 데시만 10진수 변수//%n은 띄어쓰기//\n은 다음줄로 내려쓰기//println에는 %를 사용할 수 없다. %d는 정수값을 출력해주는 시그널의 약자

		System.out.printf("%d-%d=%d\n" ,a,b,c);//f포맷은 출력이라는 뜻//%d는 변수값 abc가 각자의 자리로 들어간다//printf는 엔터가 없다

	}
}
