package com.score3;

import java.util.ArrayList; //연산
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class ScoreImpl implements Score {
	
	private ArrayList<ScoreVO> lists = new ArrayList<ScoreVO>();//ScoreVO 형태만 들어갈 수 있다. 한번 정해진 자료형은 변하지 않는다.
	
	//자식의 개체를 생성해서 부모화 시킨다.
	//ArrayList는 배열의 길이 제한이 없다.
	//ScoreVO의 객체를 new를 통해 생성
	//private List<ScoreVO> lists = new ArrayList<ScoreVO>();
	//list는 생성만 되어있지 내용이 없는 상태....
	//List 부모와 자식 관계인데 자식을 통해 객체를 생성했다.
	
	
	Scanner sc = new Scanner(System.in);
	@Override
	public int input() {//클래스에는 데이터를 1명분만 저장 할 수 잇기 때문에 10명의 데이터를 저장하려면 10개의 클래스가 필요하다.
		
		//int로 정수형의 정보를 입력해 주었기 때문에 초기화가 필요하다.
		int result = 0;
		
		
		ScoreVO vo = new ScoreVO();//1명의 데이터를 저장한다.사람의 인원이 늘수록 입력해야하는 VO가 늘어간다.
		
		
		
		System.out.println("학번?");
		vo.setHak(sc.next());  
		
		System.out.println("이름?");
		vo.setName(sc.next());
		
		System.out.println("국어?");
		vo.setKor(sc.nextInt());
		
		System.out.println("영어?");
		vo.setEng(sc.nextInt());
		
		System.out.println("수학?");
		vo.setMat(sc.nextInt());
		
		
		lists.add(vo);
		
		
		return 0;//의미는 없지만 DB에서 사용한다.
	}

	public void print() {
		
	Iterator<ScoreVO> it = lists.iterator();
	
	System.out.printf("%2s %6s %s %s %s %s %s\n" , "학번","이름","국어","영어","수학","총점","평균");
	System.out.println("---------------------------------------");
	
	while(it.hasNext()){
	
	   ScoreVO vo = it.next();
       System.out.println(vo.toString());
       
	}

	}

	@Override
	public void searchHak() {//검색할 학번이 무엇인지 물어봐야한다.
		
		System.out.println("찾는 학번?");//111
		String hak = sc.next();
		
		Iterator<ScoreVO> it = lists.iterator();//1
		
		while(it.hasNext()){//2
			
			   ScoreVO vo = it.next();
			   
			   if(hak.equals(vo.getHak())){//3
			   
		           System.out.println(vo.toString());//4
		           break;
		       
	          }
			
		   }

		
		}
		
		
	

	@Override
	public void searchName() {
		

		System.out.println("검색할 이름?");//111
		String name = sc.next();
		
		Iterator<ScoreVO> it = lists.iterator();
		
		while(it.hasNext()){
			
			   ScoreVO vo = it.next();
			   
			   if(vo.getName().equals(name)){
			   
		           System.out.println(vo.toString());
		           //끝까지 돌아야 한다. 이름이 겹칠수도 있기 때문에
	          }
			
		   }
	}

	@Override
	public void descSortTot() {//내림차순 정렬
		
		//정렬을 할때는? comparator - 자바 유틸에 있다. - > 무조건 오버라이드 해야한다.
		//무명의 클래스
		
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				return vo1.getTot()<vo2.getTot()?1:-1;
			}//<내림차순     >오름차순  ->숫자이기 때문에 부등호로 비교한다.
			
		};
		
		Collections.sort(lists, comp);
		
		print();//그대로 호출해준다.
		
	}

	@Override
	public void ascSorthak() {//오름차순 정렬
		
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				return vo1.getHak().compareTo(vo2.getHak());
			}//<내림차순     >오름차순  ->숫자이기 때문에 부등호로 변환한다.
			//compareTo
			
		};
			Collections.sort(lists, comp);
			
	
}
	
	

}
