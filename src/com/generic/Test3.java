package com.generic;

import java.util.Scanner;


//예외처리 - 프로그램을 만들때 신경을 많이 써줘야 한다. 어떻게 처리를 할까?
//Exception

public class Test3 {

	public static void main(String[] args) {


		int num1,num2,result;
		String oper;

		Scanner sc = new Scanner(System.in);

		System.out.println("두개의 수?");

		num1= sc.nextInt();
		num2= sc.nextInt();

		//여기서 부터 에러가 날 확률이 높다. try,catch문
		/*System.out.println("연산자?");
		oper =sc.next();

		result = 0;

		if(oper.equals("+"))
			result = num1+num2;

		else if(oper.equals("-"))
			result = num1-num2;

		else if(oper.equals("*"))
			result = num1+num2;

		else if(oper.equals("/"))
			result = num1+num2;

		System.out.printf("%d %s %d =%d\n",num1,oper, num2,result);*/


		try{//트라이 캣치 문은 여러개 쓸수 있고 경우의 수를 나눠서 에러처리(예외처리)를 다 해주어야 한다.
			//웹에서 에러가 날것같으면 트라이 캣치문을 써주고 프로그램을 만들어 준다.
			//캣치 문 뒤에 아무것도 써주지 않아도 괜찮다.

			System.out.println("연산자?");

			oper =sc.next();

			result = 0;

			if(oper.equals("+"))
				result = num1+num2;

			else if(oper.equals("-"))
				result = num1-num2;

			else if(oper.equals("*"))
				result = num1+num2;

			else if(oper.equals("/"))
				result = num1+num2;

			System.out.printf("%d %s %d =%d\n",num1,oper, num2,result);

		} catch (NumberFormatException e) {
			System.out.println("정수를 입력해라");
			
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌수 없다");
			
		} catch (Exception e){
		
			
			
			/*System.out.println(e);
			e.printStackTrace();*/
			System.out.println("넌 그게 숫자로 보이냐");
		
		}finally{//항상 쓰지 않아도 된다.
			
			System.out.println("넌 그게 숫자로 보이냐?");
			
		}
	}
}
