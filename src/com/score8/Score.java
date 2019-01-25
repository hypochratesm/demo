package com.score8;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class Score {

	Scanner sc = new Scanner(System.in);
	ScoreDAO1 dao = new ScoreDAO1();


	//1.추가

	public void insert(){//이 녀석은 메인에서 호출해야 한다.


		ScoreDTO dto = new ScoreDTO();
		//이 녀석이 insert메소드 밖으로 나간다면 1번만 입력이 되는것이기 떄문에 반복문에서 문제가 발생할 수도 있다.

		System.out.println("학번?");
		dto.setHak(sc.next());

		System.out.println("이름?");
		dto.setName(sc.next());

		System.out.println("국어?");
		dto.setKor(sc.nextInt());

		System.out.println("영어?");
		dto.setEng(sc.nextInt());

		System.out.println("수학?");
		dto.setMat(sc.nextInt());

		int result = dao.insertData(dto); //반환값을 받지 않아도 된다.

		if(result!=0){
			System.out.println("추가성공");
		}else{
			System.out.println("추가실패");
		}

	}

	public void update(){

		ScoreDTO dto = new ScoreDTO();


		System.out.println("수정할 학번?");
		dto.setHak(sc.next());

		System.out.println("국어?");
		dto.setKor(sc.nextInt());

		System.out.println("영어?");
		dto.setEng(sc.nextInt());

		System.out.println("수학?");
		dto.setMat(sc.nextInt());

		int result = dao.updateData(dto);

		if(result!=0)
			System.out.println("수정 성공!!");
		else
			System.out.println("수정 실패!!");


	}
	public void delete(){

		System.out.println("삭제할 학번?");
		String searchHak = sc.next();

		int result = dao.deleteData(searchHak);

		if(result!=0){
			System.out.println("삭제성공");
		}else{
			System.out.println("삭제실패");
		}


	}
	public void selectAll(){
		
		List<ScoreDTO> lists = dao.getLists();
		
		Iterator<ScoreDTO> it = lists.iterator();
		
		System.out.println();
		
		while(it.hasNext()){
			
			ScoreDTO dto = it.next();
			System.out.println(dto.toString());
			
		}
		
		System.out.println();
		
		
	}
	public void searchHak(){
		
		
		System.out.println("학번");
		String searchHak = sc.next();
		
		ScoreDTO dto = dao.getList(searchHak);
		
		if(dto!=null){
			System.out.println(dto.toString());
		}else{
			System.out.println("찾는학번이 없습니다.");
			
		}
		
		
		
	}
	
	
	
}
