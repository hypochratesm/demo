package com.day3;

class Test4 {


	public static void main(String[] args) {

		//다중 for문

		int i,j;

		for(i=2;i<=9;i++){

			System.out.println(i+ "단");

			for(j=1; j<=9; j++){

				//System.out.println(i + ":" + j);
				System.out.printf("%d+%d=%d\n", i,j,(i*j));


				System.out.println();


				// for문 안에 for문이 있다
			}
		}








	}
}
