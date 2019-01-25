package com.day2;

class Test1{



	public static void main(String[] args) {

		//float,double비교


		float f = 0;
		double d = 0;

		for(int i=1;i<=10;i++){//i=i+1


		f=f+100000;//f+=100000;
		d=d+100000;//d+=100000;
		//f:10000000000정도로 큰값이 들어가 있게 된다.
		//복잡하게 많은 수를 계산하게 되면 double을 사용해야만 한다.
		}

		System.out.println("float:"  +(f/100000));
		System.out.println("double:" +(d/100000));


			
			//System.out.println("수지 이뻐!");
		





		
		
	}
}
