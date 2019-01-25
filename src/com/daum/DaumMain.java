package com.daum;

import java.util.Scanner;

public class DaumMain {

    public static void main(String[] args) {
		
    	Scanner sc = new Scanner(System.in);
    	Daum ob = new DaumImpl();
    	
    	int ch;
    	
    	while(true) {
    		
    		do {
    			System.out.println("1.회원가입   2.회원전체출력  3.아이디검색  4.비밀번호 찾기  5.종료");
    			
    			ch = sc.nextInt();
    			
			} while (ch<1);
    		
    		
    		switch (ch) {
    		
			case 1:
				try {
					ob.join();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					ob.print();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					ob.findId();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					ob.findPwd();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("종료합니다");
				System.exit(100);
				break;
			}
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    	}
    	
    	
    	
    	
	}
	
	
}
