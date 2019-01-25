package com.day1;

class Test3{


	public static void main(String[] args) {

		int r=10;//반지름은 10이다
		float area,length;//플롯은 실수를 저장 할 수 있다.(소수점)

		area = r*r*3.14f;//면적 // 자바는 소수점을 만나면 무조건 더블로 인식한다
		length = r*2*3.14f;//둘레//f를 붙여주지 않으면 자바가 더블로 인식해서 화면상에 프린팅은 힘들다.

		System.out.printf("반지름: %d, 넓이 : %f\n",r,area);
		System.out.printf("반지름: %d, 넓이 : %.2f\n",r,area);//.2는 소수점 2자리까지 표시하라는 명령어//\n은 내려쓰기//float은 소수점 아래 6자리까지 표시 가능

		//플롯은 %f 더블은 %g %d는 정수 %s는 스트링

		System.out.println("둘레: "+ length);
		System.out.println();//한칸 띄기
		//System.out.print();// 반드시 매개변수()안에 무언가 있어야 한다.

		//println()은 아무것도 쓰지 않으면 띄어쓰기가 된다.
		
		
		








	}
}
