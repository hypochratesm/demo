package com.day2;

import java.io.*;

class Test2 {





	public static void main(String[] args)  throws IOException{


		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));


			int num1,num2;

			System.out.print("첫번째 수?");
			num1 = Integer.parseInt(br.readLine());

			System.out.print("두번째 수?");
			num2 = Integer.parseInt(br.readLine());

				//항상 들여쓰기 내어쓰기를 맞춰 주어야 한다.

		    
	System.out.printf("%d + %d = %d\t", num1, num2,(num1+num2));
	System.out.printf("%d - %d = %d\n", num1, num2,(num1-num2));
	System.out.printf("%d * %d = %d\n", num1, num2,(num1*num2));
	System.out.printf("%d / %d = %d\t", num1, num2,(num1/num2));
	System.out.printf("%d %% %d = %d\n", num1, num2,(num1%num2));
	//몫을 구하기 때문에 나머지가 없다.
	//나머지를 구하는 것은 %이다.
	//나머지 값을 계산하기 위해서는 %%의 기호를 사용한다. 한번 쓰면 혼란이 생길 수도 있기때문에
	// %% 두 개를 써야만 %d가 생성될수 있다.
	

    //숫자를 등호나 부등호로 비교하면 true나 false가 생성된다.
	//실제로 true나 false라는 문자가 생성되는 것이다.
	System.out.println("num1>num2 : "+(num1>num2));
	System.out.println("num1<num2 : "+(num1<num2));
	//true, false가 나온다.

	//String str = "가나다";
	//str 문자를 저장 할 수 있는 공간, 안에는 쓰레기 값이 들어가 있다.
	
	String str;

	//삼항연산자

	str = num1%2==0?"짝수" : "홀수";  // 조건 등호를 두번쓰면 조건을 나타낸다.//==은 같다 라는뜻

	// 조건을 만족한다 : 숫자를 등호나 부등호로 비교한다. -> true이면 짝수 false이면 홀수 라는 조건을 만들어 출력한다.

	str = num1>0?"양수":(num1<0?"음수":"영");

	str = num1%4==0 && num1%100!=0 || num1%400==0? "윤년":"평년";

	//a &&(and) b a와 b가 만족해야 전체조건이 true가 된다. 전체 조건이 true가 되지 않는다면 false가 된다. and는 두개가 무조건 true여야 한다.
	//a||(or) b 둘중에 하나가 true여도 된다. 일반적으로 or가 데이터가 더 많이 나온다.
    

	//윤년은 4년마다 한번씩 오고 100으로 나웠을때 떨어져선 안된다.

	System.out.println(str);




		
	}
}
