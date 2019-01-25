package com.class3;

import java.io.IOException;
import java.util.Scanner;

class Calc{//boolean을 사용해보자!
	
	private int num1,num2;
	private char oper;
	
	public boolean input() throws IOException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("두수?");//10 20
		
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		System.out.println("연산자?");
		oper =(char)System.in.read();
		
		//연산자 확인
		
		if(oper!='+'&&oper!='-'&&oper!='*'&&oper!='/'){
			return false;
		}
		return true;
	}
	
	public int result(){
		
		int r=0;
		switch(oper){
		
		case '+':
		    r=num1+num2;
		    break;
		case '-':
			r=num1-num2;
			break;	
		case '*':
			r=num1*num2;
			break;	
		case '/':
			r=num1/num2;
			break;
		
		}
		
		return r;
	}
	
	public void print(int r){
		System.out.printf("%d %c %d = %d\n" , num1,oper,num2,r);
	}
	
}


public class Test6 {
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		Calc ob =new Calc();
		
		/*boolean b = ob.input();
		
		if(b==true)
			정상
			else
				비정상*/
		
		if(!ob.input()){//!는 false와 true 실행값을 exchange해주는 역할을 한다. 여기를 벗어나서 정상적으로 실행되게 한다. 짧은 코딩을
			            //if문에 가둬놓고 긴 코딩을 밖으로 빼놓게 해준다.트루가 오면 펄스로 바꾸고 펄스가 오면 트루로 바꿔준다.
			            //if문은 항상 true 아니면 false이기 때문에 if문에 가둬놓고 사용해야만 하는 것이다.
			
			return;//(stop)
			
			
		}
		int r =ob.result();
		ob.print(r);
		
		
		
		
		
		
	}

}
