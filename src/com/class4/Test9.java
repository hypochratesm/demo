package com.class4;




import java.util.Scanner;

class TestA{
	
	public void print(){//1s
		
		String s;
		
		System.out.println();
	}//1e
	
class Calc extends TestA{//2s
	
	int num1,num2;
	String num;
	char op;
	
	public void input(){
		
		Scanner sc = new Scanner(System.in);//��ĳ�ʴ� �⺻ �����ڰ� ����.
		
		System.out.println("�μ�?[5,2]");
		num = sc.next();
		
		String ss[] = num.split(",");
		num1=Integer.parseInt(ss[0]);
		num2=Integer.parseInt(ss[1]);
		
		System.out.println("������?");
		
        int result = 0;
		
		switch(op){
		
		case'+':
			result = num1+num2;
			break;
		case'-':
			result = num1-num2;
			break;
		case'*':
			result = num1*num2;
			break;
		case'/':
			result = num1/num2;
			break;
		}
		/*return System.out.printf("%d %c %d = %d",num1,op,num2,result);*/
	     String s = String.format("%d %c %d = %d",num1,op,num2,result);
						System.out.println(s);//return s
				
		
						return ;
	
		
	}
	
	public Calc() {
		
	}

	public void print() {
	}
	
	
}//2d
	
	


public static class Test9 {
	
	public static void main(String[] args){
		
		TestA ob = new TestA();
				
		ob.input();
		
		String s ;
		ob.print();
		
	}
		
		
    }




public void input() {
}
}
