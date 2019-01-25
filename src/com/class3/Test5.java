package com.class3;

//비정형 인수

public class Test5 {
	
	int sum(int...args){//인수의 개수가 정해지지 않는것.//값을 꺼내와서 누적시키는 형태.
		                //public int sum(int ...args)  //...args 가변인자
		int s=0;
		
		for(int i=0;i<args.length;i++){
			s += args[i];
		}
		
		return s;
		
		
		
	}

	public static void main(String[] args) {
		
		Test5 ob = new Test5();
		
		int result;
		
		result = ob.sum(2,4,6,8,10);
		
		System.out.println(result);
		
		result = ob.sum(1,3,5,7,9,11,13,15,17,19);
		System.out.println(result);
		
		
		
		

	}

}
