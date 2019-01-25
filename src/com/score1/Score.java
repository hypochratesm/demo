package com.score1;

import java.util.Scanner;

public class Score {

	Scanner sc = new Scanner(System.in);

	int inwon;//초기값은 STRING은 null이 들어간다.//자료형이 int 정수값 하나를 담을 수 있다.//배열
	Record[] rec;//class의 초기값은 무조건 0이 들어간다.
	/*Record rec;//자료형이 record, 총 7개의 데이터를 담을 수 있다.//record[] 똑같이 배열 3개가 생성된다. record값이 들어가게 된다.(마찬가지로
	//7개의 데이터를 담을 수 있다.)
	//배열안에 클래스를 집어넣으면 같은 공간에 보다 많은 정보를 저장시킬 수 있다.
	 */	

	public void set(){

		
		do{
			System.out.print("인원수?:");
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		


		rec = new Record[inwon];//배열의 객체를 생성
	}

	public void  input(){

		String[] title = {"국어?","영어?","수학?"};

		for(int i=0;i<inwon;i++){

			rec[i] = new Record();////배열의 객체를 생성//for문의 안에서 써주어야 함.

			System.out.print((i+1)+ "번째 이름?");
			rec[i].name = sc.next();

			for(int j=0;j<3;j++){
				System.out.print(title[j]);
				rec[i].score[j] = sc.nextInt();//국영수

				rec[i].tot += rec[i].score[j];//for문이 3번 돌고 나면 tot에 총점이 들어가 있을 것이다.

			} 

			rec[i].ave = rec[i].tot/3;//평균

		}	
	}

	private void ranking(){//직원전용//메소드에서 메소드를 호출할 수 있다.

		int i,j;
		for(i=0;i<inwon;i++){
			rec[i].rank = 1;
		}
		
		for(i=0;i<inwon-1;i++){
			for(j=i+1;j<inwon;j++){

				if(rec[i].tot > rec[j].tot ){
					rec[j].rank++;
					
				}else if(rec[i].tot<rec[j].tot){
					rec[i].rank++;
				}
			}
		}




	}
	public void print(){
		
		ranking();

		for(int i=0; i<inwon;i++){
			System.out.printf("%6s",rec[i].name);

			for(int j=0;j<3;j++){
				System.out.printf("%4d",rec[i].score[j]);	
			}

			System.out.printf("%4d",rec[i].tot);
			System.out.printf("%4d",rec[i].ave);
			System.out.printf("%4d\n",rec[i].rank);

		}
	}









}	

