package com.class4;

//Wrapper클래스
//기본 데이터(자료형)를 객체로 사용할 수 있게 해줌
//자료형 데이터: boolean,byte,char,short,int,long,float,double(stack에 저장)
//레퍼런스(class)데이터:Boolean,Byte,Character,Short,Integer,Long,double(heap에 저장)//첫글자를 대문자로 써준다.

//Auto-boxing(stack->heap)
//Auto-UnBoxing(heap->stack)


public class Test8 {
	
	public static void main(String[] args){
		
		int n1 = 10;
		int n2;
		Integer num1;
		Integer num2 = new Integer(20);
		
		num1 = n1;//Auto-Boxing(stack -> heap)
		n2 = num2;//Auto-UnBoxing(heap-> stack)
		
		System.out.println(n1 + ":" + num1);//10:10
		System.out.println(n2 + ":" + num2);//20:20
		
		
		
	}

}
