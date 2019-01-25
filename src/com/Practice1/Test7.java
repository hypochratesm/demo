package com.Practice1;

//되부름 함수
//장점은 소스가 간단해짐
//단점은 처리 속도가 느리다.(stack 영역에 데이터를 저장햇다가 출력하기 때문에,,,,,)




public class Test7 {
	
	public void print(int n){
		
		if(n!=1){//자기 안에서 자기 자신을 호출하게 된다.
			print(n-1);//되부름 함수
		}
		
		System.out.printf("%2d",n);//1번 출력
	}

	
	public int sum(int n){
		
		 return n>1?n+sum(n-1):n;
		 
		 //10+sum(9)
		 //  9+sum(8)
		 //      8+sum(7)
	}
	
	public int pow(int a, int b){//지수를 만드는 것에 자기 자신을 계속해서 곱해 나간다.
		 
		 return b>=1?a*pow(a,b-1):1;//pow(숫자 제곱 메서드)	
	}
	public static void main(String[] args){
		
		Test7 ob =new Test7();
		ob.print(5);
		
		System.out.println();
		
		int s = ob.sum(10);//(10+9+8+7+6+5+4+3+2+1)
		
		System.out.println(s);
		
		System.out.println();
		System.out.println("pow(2,10):" + ob.pow(2, 10));
		
	}
}