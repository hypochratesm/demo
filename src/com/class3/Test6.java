package com.class3;

import java.io.IOException;
import java.util.Scanner;

class Calc{//boolean�� ����غ���!
	
	private int num1,num2;
	private char oper;
	
	public boolean input() throws IOException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�μ�?");//10 20
		
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		System.out.println("������?");
		oper =(char)System.in.read();
		
		//������ Ȯ��
		
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
			����
			else
				������*/
		
		if(!ob.input()){//!�� false�� true ���ప�� exchange���ִ� ������ �Ѵ�. ���⸦ ����� ���������� ����ǰ� �Ѵ�. ª�� �ڵ���
			            //if���� ���ֳ��� �� �ڵ��� ������ ������ ���ش�.Ʈ�簡 ���� �޽��� �ٲٰ� �޽��� ���� Ʈ��� �ٲ��ش�.
			            //if���� �׻� true �ƴϸ� false�̱� ������ if���� ���ֳ��� ����ؾ߸� �ϴ� ���̴�.
			
			return;//(stop)
			
			
		}
		int r =ob.result();
		ob.print(r);
		
		
		
		
		
		
	}

}
