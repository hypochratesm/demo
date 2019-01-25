package com.class3;

//되부름 함수
//장점은 소스가 간단해짐
//단점은 처리속도가 느림(stack 영역에 데이터를 저장했다가 출력하기 때문에)

/*public void print(int n) {
if(n>1)
 print(n-1); // 되부름
System.out.print(n+"  ");
*/

public class Test4 {
	
	public void print(int n){
		
		
		if(n!=1){//자기 안에서 자기 자신을 호출하게 된다.
			print(n-1);//되부름 함수
		}
		
		System.out.printf("%5d",n);
	}
	
	public int sum(int n){
		
		return n>1?n+sum(n-1):n;
		
		//10+sum(9)
		//  9+sum(8)
		//       8+sum(7)
	}
	
	public int pow(int a,int b){//지수를 만드는 것에 자기자신을 부른당.
		
		return b>=1?a*pow(a, b-1):1;//pow(숫자 제곱 메서드)
	}
	
	public static void main(String[] args) {
		
		Test4 ob =new Test4();
		ob.print(5);
		
		System.out.println();
		
		int s = ob.sum(10);
		
		System.out.println(s);
         
		System.out.println();
		System.out.println("pow(2,10):" + ob.pow(2,10));//자바에서 제곱수를 구하느
		
		
	}

}
