package com.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class OperatorMain {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		double num1, num2, result;
		
		OperationAuthen auth = new OperationAuthen();
		
		try {
			
			
			System.out.println("두수[a,b]?");
			
			str = br.readLine();
			
			auth.inputForm(str);
			
			String[] temp = str.split(",");
			
			auth.number(temp[0]);
			num1 = Double.parseDouble(temp[0]);//실수정보처리 오류
			
			auth.number(temp[1]);
			num2 = Double.parseDouble(temp[1]);
			
			System.out.println("연산자?");
			str = br.readLine();
			
			auth.operator(str);
			result = 0;

			if(str.equals("+"))
				result = num1+num2;

			else if(str.equals("-"))
				result = num1-num2;

			else if(str.equals("*"))
				result = num1*num2;

			else if(str.equals("/"))
				result = num1/num2;

			System.out.printf("%g %s %g =%g\n",num1,str, num2,result);
			
		} catch (IOException e) {
			
		} catch (MyException e) {
			
			System.out.println(e.toString());
			
			
		}//실제 회사에서 예외를 처리 하는 방법. 우리가 사용할때에는 TRY CATCH로 만들어야 한다.
	}

}
