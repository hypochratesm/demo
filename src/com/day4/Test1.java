package com.day4;

import java.io.IOException;
import java.util.Scanner;

public class Test1 {
	
	public static void main(String[] args) throws IOException{
	
		Scanner sc = new Scanner(System.in);
	
		int num1,num2;
		char oper;
	
		System.out.print("첫번째 수?");
		num1 = sc.nextInt();
		
		System.out.print("두번째 수?");
		num2 = sc.nextInt();
	
		System.out.print("연산자[+,-,*,/]?");//+
		oper = (char)System.in.read();
		
		int result=0;
		switch(oper){
		
		/*case '+':
			System.out.println(num1+num2);
			break;
		case '-':
			System.out.println(num1-num2);
			break;
		case '*':
			System.out.println(num1*num2);
			break;
		case '/':
			System.out.println(num1/num2);
			break;
		default:
			System.out.println("잘못된 연산자!");*/
		case '+':
			result = num1 + num2;
			//System.out.printf("%d+%d=%d\n",num1,num2,(num1+num2));
			break;
		case '-':
			result = num1 - num2;
			//System.out.printf("%d-%d=%d\n",num1,num2,(num1-num2));
			break;
		case '*':
			result = num1 * num2;
//			System.out.printf("%d*%d=%d\n",num1,num2,(num1*num2));
			break;
		case '/':
			result = num1 / num2;
//			System.out.printf("%d/%d=%d\n",num1,num2,(num1/num2));
			break;
		default:
			System.out.println("잘못된 연산자!");
		
		}
		
		System.out.printf("%d%c%d=%d\n",num1,oper,num2,result);
		
		
		

	}
}

/*

[자료형]
boolean : true/false

[정수]
byte -128~127
short : 32768~32767
int : 4byte
long : 8byte

10진수:10, 8진수:016, 16진수:0x17

[실수]
float : 4byte
double : 8byte
단정도실수(float):3.14f
배정도실수(double):3.14

[문자]
char : 2byte(UTF-16):'a'

[연산자]
+,-,*,/,%,++,--

[관계형연산자]
>,>=,<,<= : 결과: true,false

[등가연산자]
==,!=

[논리연산자]
&&(and), ||(or), !(not)

[비트단위]
&, |, ~, >>, <<, >>>

[삼항연산자]
조건?참일때값:거짓일때값

[대입연산자]
=,+=(숫자는 더해져 누적, 문자는 이어짐),-=,*=

---------------------------------------------------
int a=10;
float b;

b=a; 		//암시적형변환
b=(float)a; //명시적형변환

a=b;		X
a=(int)b;	O //명시적형변환

---------------------------------------------------
[제어문]

if(조건){
작업1;
}


if(조건){
작업1;
}else{
작업2;
}


if(조건1){
작업1;
}else if(조건2){
작업2;
}else{  //마지막 else 생략가능
작업3;
}


for(시작값;최대값;증가값)

while(조건){// =(equal)잘쓰지않음 보통 부등호로 표기
작업;
}


do{
작업;
}while(조건);


<무한루프>
while(true){
작업;
}

break;




*/		




















