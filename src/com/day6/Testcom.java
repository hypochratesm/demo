package com.day6;

import java.util.Scanner;

    public class Testcom {
	
	/*//사각형의 면적을 전문적으로 구하는 회사
	
	int w,h;//전역변수,instance변수
	
	public void input(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로?");
		
	    w=sc.nextInt();
	    
	    System.out.print("세로?");
	    
	    h= sc.nextInt();
	    
	    //return : void의 리턴은 생략된다.
	   	
		
	}
	
	public int area(){
		
		int result;//지역변수
		
		result = w*h;//변수안에 있는 데이터만 줘서 나가는 것이다.
		
		return result;//반환값
		
		
	}
	
	public int length(){
		
		return(w+h)*2;//여기에 쓰는 식의 길이가 길면 안됌
	}
	
	
	public void print(int a,int l){//가지고 온걸 찍기만 하면 된다.
		
		System.out.println("가로: " + w);
		System.out.println("세로: " + h);
		System.out.println("넓이: " + a);
		System.out.println("둘레: " + l);*/
    	
    	public int w,h;//전역변수,instance변수(java에서 사용),멤버변수(웹에서 쓰는 용어)
    	public void input(){
    		Scanner sc = new Scanner(System.in);
    		
    		System.out.print("가로?");
    		w= sc.nextInt();
    		System.out.println("세로?");
    		h= sc.nextInt();
    		//return : void의 리턴은 생략된다.
    	}
    	
    	public int area(){
    		int result;//지역변수
    		
    		result = w*h;//변수안에 있는 데이터만 줘서 나가는 것이다.
    		return result;//반환값
    		
    	}
    	
    	public int length(){
    		
    		return(w+h)*2;//여기에 쓰는 식의 길이가 길면 안댐
    		
    	}
    	
    	public void print(int a, int l){//가지고 온걸 찍기만 하면 된다.//매개변수//각각의 메소드끼리 분업화를 시켰당
    		System.out.println("가로:" +w);
    		System.out.println("세로:" +h);
    		System.out.println("넓이:" +a);
    		System.out.println("둘레"  +l);
    	
	}
}
