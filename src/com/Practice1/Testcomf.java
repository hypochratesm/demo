package com.Practice1;

import java.util.Scanner;



public class Testcomf {
	
	public int n,l;
	
    public void input(){
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("πÿ∫Ø?");
    	n = sc.nextInt();
    	System.out.print("≥Ù¿Ã?");
    	l = sc.nextInt();
    }
    
    public int area(){
    	return n*l/2;
    	
    }
    
    public void print(int a, int l){
       
    System.out.println("≥–¿Ã:" +a);
    
    }

}
