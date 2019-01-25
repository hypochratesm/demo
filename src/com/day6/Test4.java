package com.day6;

public class Test4 {

	public static void main(String[] args) {

		int[][] a = { { 5, 4, 3, }, 
					{ 6, 7, 3 }, 
					{ 7, 4, 2 } };
		
		int[][] b = { { 7, 8, 5, }, 
					{ 7, 3, 4 }, 
					{ 2, 4, 9 } };
		int[][] sum = new int[3][3];
		int i, j;

		for (i = 0; i < a.length; i++) {
			for (j = 0; j < b.length; j++) {

				sum[i][j] = a[i][j] + b[i][j];

				System.out.printf("%4d", sum[i][j]);// %4d 공백 포함해서 네칸(4byte를
													// 쓰겠다......)

			}
			System.out.println();
		}

	}

}
// 배열은 여기까지