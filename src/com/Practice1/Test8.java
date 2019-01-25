package com.Practice1;


//비정형 인수(가변인자) -인수의 개수가 정해져 있지 않을때 사용한다.

public class Test8 {
	
	int sum(int...args){//인수의 개수가 정해지지 않은것.//값을 꺼내와서 누적시키는 형태.
		               
	


		
		int s= 0;
		for(int i=0;i<args.length; i++){
			s+=args[i];
			
		}
		 return s;
		 
		 
	}
	
	public static void main(String[] args){
		
		Test8 ob =new Test8();
		
		int result;
		
		result = ob.sum(2,4,6,8,10);
		
		System.out.println(result);
		
		result = ob.sum(1,3,5,7,9,11,13,15,17,19);
		System.out.println(result);
		
		
	}

}
