package com.day3;

class Test5 {


	public static void main(String[] args) {

		//다중for문
		//기술 면접에 많이 나옴

/*		int i,j; //???????????
		
		for(i=1;i<=5;i++){

			for(j=1; j<=5-i;j++){

				System.out.print(" ");//공백 한칸
			
		}

		    for(j=1;j<=i;j++){

				System.out.print("*");
			}

			System.out.println();
		}

*/

 /*       int i,j; //삼각형
		
		for(i=1;i<=5;i++){

			for(j=1; j<=5-i;j++){

				System.out.print(" ");//공백 한칸
			
		}

		    for(j=1;j<=i*2-1;j++){//i*2-1 홀수를 만드는 공식

				System.out.print("*");
			}

			System.out.println();
		}
*/
    /*     int i,j;//역삼각형
		
		for(i=5;i>=1;i--){//ㅑ=ㅑ-1

			for(j=1; j<=5-i;j++){

				System.out.print(" ");//공백 한칸
			
		}

		    for(j=1;j<=i*2-1;j++){//i*2-1 홀수를 만드는 공식

				System.out.print("*");
			}

			System.out.println();
		}
		*/
      int i,j;//모래시계

	  for(i=5;i>=1;i--){//i=i-1

			for(j=1; j<=5-i;j++){

				System.out.print(" ");//공백 한칸
			
		}

		    for(j=1;j<=i*2-1;j++){//i*2-1 홀수를 만드는 공식

				System.out.print("*");
			}

			System.out.println();
		}
		
		for(i=2;i<=5;i++){ //i=2를 대입시켜 맞물리는 점의 숫자를 1개로 바꿔준다.

			for(j=1; j<=5-i;j++){

				System.out.print(" ");//공백 한칸
			
		}

		    for(j=1;j<=i*2-1;j++){//i*2-1 홀수를 만드는 공식

				System.out.print("*");
			}

			System.out.println();
		}






	}
}
