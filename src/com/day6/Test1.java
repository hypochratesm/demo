package com.day6;

public class Test1 {
	
	public static void main(String[] args) {
		
		
		/*//Bubble Sort(이웃하는 수하고 비교) 오른쪽부터 채워짐,5개의 칸에서 4번 3번 2번 1번 비교하는 것.큰 숫자가 오른쪽부터 정렬
		//Sellection sort(왼쪽부터 채워짐) - 기술면접에 많이 등장함. 작은 숫자가 왼쪽으로 정렬
		
		//-->
		
		int[] num = {36,30,26,10,4};
		int i,j,temp;
		
		System.out.print("Source data:");
		
		for(i=0;i<num.length;i++){//비교 할 수록 오른쪽에 제일 큰 숫자가 들어가게 된당.
			System.out.printf("%4d", num[i]);
			
		}//1end
    System.out.println();
    //bubble sort;
    for(i=0;i<num.length;i++);
    
     for(j=0;j<num.length-i;j++){//2
    	 if(num[j]>num[j+1]){//3
    		 temp = num[j];
    		 num[j]= num[j+1];
    		 num[j+1]=temp;
    	 }//2end
     }//3end

	

	System.out.print("Source data:");
	 
	  for(int su : num){//4
		  System.out.printf("%4d",su);
	  }//4end
		  
		  System.out.println();*/
		
		//bubble sort(이웃하는 수하고 비교) 오른쪽부터 채워짐, 5개의 칸에서 4번 3번 2번 1번 비교하는 것. 큰 숫자가 오른쪽부터 정렬
		//sellection sort(왼쪽부터 채워짐) - 기술면접에 많이 등장함. 작은 숫자가 왼쪽으로 정렬
        
		int[] num = {36,30,26,1,4};
		int i,j,temp;
		System.out.println("Source data:");
	  }
}
