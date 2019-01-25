package com.day6;

public class Test3 {
	
	public static void main(String[] args){
		
		//배열의 배열
		//배열은 초기화 하지 않아도 인트 배열은 초기화 된다.
		
		int[][] arr = new int[6][6];
		
		int i,j;
		int n=0;
		
		for(i=0;i<5;i++){//1
			
			
		
			if(i%2!=0){//2
				for(j=4;j>=0;j--){//3
				n++;
				arr[i][j] = n;				
				arr[i][5] += n;
				arr[5][j] += n;
				arr[5][5] += n;
				}				
		 }else{//4
				for(j=0;j<5;j++){

					n++;
					arr[i][j] = n;				
					arr[i][5] += n;
					arr[5][j] += n;
					arr[5][5] += n;
		      }
			}
		}
		
		for(i=0;i<arr.length;i++){//5
			for(j=0;j<arr.length;j++){//6
				
				
			
				System.out.printf("%4d",arr[i][j]);
				
			}
		System.out.println();
	    
     }
	
		
	}
}

		
		
		