package com.daum;

import java.util.Scanner;

public class DaumMain {

    public static void main(String[] args) {
		
    	Scanner sc = new Scanner(System.in);
    	Daum ob = new DaumImpl();
    	
    	int ch;
    	
    	while(true) {
    		
    		do {
    			System.out.println("1.ȸ������   2.ȸ����ü���  3.���̵�˻�  4.��й�ȣ ã��  5.����");
    			
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
				System.out.println("�����մϴ�");
				System.exit(100);
				break;
			}
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    	}
    	
    	
    	
    	
	}
	
	
}
