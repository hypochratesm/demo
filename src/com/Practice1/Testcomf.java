package com.Practice1;

import java.util.Scanner;



public class Testcomf {
	
	public int n,l;
	
    public void input(){
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("�غ�?");
    	n = sc.nextInt();
    	System.out.print("����?");
    	l = sc.nextInt();
    }
    
    public int area(){
    	return n*l/2;
    	
    }
    
    public void print(int a, int l){
       
    System.out.println("����:" +a);
    
    }

}
