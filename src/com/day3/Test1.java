package com.day3;

import java.util.*;

class Test1  {
	
	
	
	
	public static void main(String[] args)  {

		//반목문(for, while,do while)

		  Scanner sc = new Scanner(System.in);

		  int dan;


		  System.out.print("원하는 단?");//
		  
		  dan= sc.nextInt();

		  //for(초기값;최대값;증가값;)

		  for(int i=1; i<=9;i++){//i=i+1//true가 나오면 실행//시작과 끝을 명확하게 알고 있을때
		  
		    //System.out.println(dan +"*"+i+ "="+(dan*i));
			System.out.printf("%d*%d=%d\n",dan,i,(dan*i));



		  
		  }
		
            System.out.println("--------------");

			//while(최대값)

			int j = 0;
			
			
			//1로 초기화 시킨것//일반적으론 0을 사용//컴퓨터 인덱스의 시작부분은 0으로 시작하는 경우가 많기 때문에
			//일반적으로 초기값은 0이고 while문에서 일반적으로 =을 쓰지 않는다.
			//초기값에 따라 프로그램이 달라질 수 있기때문에 초기값 설정이 굉장히 중요하다.
			//몇번 돌려야 할지 모를떄 사용한다

			while(j<9){//j<=0 이퀄이 빠지게 된다

				j++;

				System.out.printf("%d*%d=%d\n",dan,j,(dan*j));//무한루프 

				//do~while(증가값이 들어가 있다.);(반드시 뒤에 세미 콜롱을 찍어 줘야 한다.)
				//무조건 저질러 놓고 본다.
				//사용자가 나에게 무언가를 주거나 어떤 값을 생성하고 비교해서 실행시킬건지 아닐건지를 판단할때 do while문을 생성한다.

				int k = 0;
				do{
					k++;//이렇게 해야 여기서 초기값이 증가하게 된다.//한번 실행하고 비교작업을 한다
					
					System.out.printf("%d*%d=%d\n",dan,k,(dan*k));


				}while(k<9);

				


			
			
			
			}
			



	}
}
