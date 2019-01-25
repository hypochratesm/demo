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
			
			
			System.out.println("�μ�[a,b]?");
			
			str = br.readLine();
			
			auth.inputForm(str);
			
			String[] temp = str.split(",");
			
			auth.number(temp[0]);
			num1 = Double.parseDouble(temp[0]);//�Ǽ�����ó�� ����
			
			auth.number(temp[1]);
			num2 = Double.parseDouble(temp[1]);
			
			System.out.println("������?");
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
			
			
		}//���� ȸ�翡�� ���ܸ� ó�� �ϴ� ���. �츮�� ����Ҷ����� TRY CATCH�� ������ �Ѵ�.
	}

}
