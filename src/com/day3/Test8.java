package com.day3;


import java. io.*;

class Test8 {





 public static void main(String[] args) throws IOException{


    BufferedReader br = new BufferedReader(
       new InputStreamReader(System.in));
    
    
	int su, sum;
	char ch;

	while(true){//무한루프

	
	

	   do{

	         System.out.print("수입력?");//100e
			 su= Integer.parseInt(br.readLine());

	   } while(su<1||su>5000);

	   sum=0;
	   for(int i=1;i<=su;i++){

		    sum+=i;

	   }
	   
	   
	   System.out.println("1~"+ su+ "까지의 합"+ sum);

	   System.out.print("계속진행?[Y/N]");//Ye(10,13).y.N.n
	   ch=(char)System.in.read();

	   if(ch!='Y' && ch!='y') {//양쪽의 공식이 부정이면 앤드를 써준다.
		   
		   System.out.println("종료합니다..");
	     break;//브레이크를 주면 무한루프를 깰 수 있다.//while, do~while,for,switch

	   }


         System.in.skip(2);//->아스키 값 두개를 지워라//e(10,13)를 삭제
     }//end.while
		
	}//end..main
 }
