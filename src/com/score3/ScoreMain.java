package com.score3;//출력

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		
		
		Scanner sc =new Scanner(System.in);
		Score ob = new ScoreImpl();
		
		int ch;
		while(true){
			
			do{
				System.out.println("1.입력\n2.출력\n3.학번검색\n4.이름검색\n5.총점내림정렬\n6.학번오름정렬\n7.종료\n");
				ch = sc.nextInt();
			}while(ch<1);
			
			switch(ch){
			
			case 1:
				ob.input();//반환값을 안받아도 된다//자바가 유일하다.
				break;
				
			case 2:
				ob.print();
				break;
				
			case 3:
				ob.searchHak();
				break;
			
			case 4:
				ob.searchName();
				break;
				
			case 5:
				ob.descSortTot();
				break;
				
			case 6:
				ob.ascSorthak();
				break;
				
			default:
			    System.out.println("종료합니다...");
				System.exit(0);
			
			}
			//yes no cancel..// 예 아니오 취소  ( 0   1   2 )
		}
	
	}

}
