package com.Practice1;

import java.util.Scanner;

public class Testcomp {//1

	
	
	public int r;
	float area,length;
	
	
	public void input(){//2
		Scanner sc = new Scanner(System.in);
		
		System.out.print("반지름?");
		r= sc.nextInt();
			
     }//2
		
		public float area(){//3
    		float result;
    		result = r*r*3.14f;
    		return result;
		}//3
		
    public double length(){//4
    	return r*2*3.14f;//위에 것을 압축해서 해놓은거.. 똑같은거
    	
    }//4
    		

	
	public void print(float a, float l){//5
	
		System.out.println("넓이:" +a);
		System.out.println("둘레:" +l);
	
}//5

}//1
