package com.Practice1;

import java.util.Scanner;

public class Testcomp {//1

	
	
	public int r;
	float area,length;
	
	
	public void input(){//2
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������?");
		r= sc.nextInt();
			
     }//2
		
		public float area(){//3
    		float result;
    		result = r*r*3.14f;
    		return result;
		}//3
		
    public double length(){//4
    	return r*2*3.14f;//���� ���� �����ؼ� �س�����.. �Ȱ�����
    	
    }//4
    		

	
	public void print(float a, float l){//5
	
		System.out.println("����:" +a);
		System.out.println("�ѷ�:" +l);
	
}//5

}//1
