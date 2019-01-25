package com.score4;//출력

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		
		
		Scanner sc =new Scanner(System.in);
		Score ob = new ScoreImpl();
		
		int ch;
		while(true){
			
			do{
				System.out.println("1.입력 2.출력 3.삭제 4.수정 5.학번검색 6.이름검색 7.종료");
				ch = sc.nextInt();
			}while(ch<1);
			
			switch(ch){
			
			case 1:
				ob.input();//반환값을 안받아도 된다//자바가 유일하다.
				break;
				
			case 2://출력
				ob.print();
				break;
				
			case 3://삭제
				ob.delete();
				break;
			
			case 4://수정 - 이름이 수정이되면 안되고 점수만 수정을 해주어야한다.
				ob.update();
				break;//학번검색
				
			case 5://이름검색 - 데이터를 비교한다.
				ob.findHak();
				break;
				
			case 6://종료
				ob.findName();
				break;
				
			default:
			    System.out.println("종료합니다...");
				System.exit(0);
			
			}
			//yes no cancel..// 예 아니오 취소  ( 0   1   2 )
		}
	
	}

}
