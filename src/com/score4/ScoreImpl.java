package com.score4;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;





public class ScoreImpl implements Score {

	//먼저 맵부터 만든다
	/*	private Map<String, ScoreVO> hMap = new HashMap<String, ScoreVO>();*/

	private Map<String, ScoreVO> hMap = new TreeMap<String, ScoreVO>();//오름차순 정렬

	Scanner sc = new Scanner(System.in);
	String hak;//인스턴스 변수기 때문에 초기화를 하지 않는다.

	Hashtable<String, String> h = //MAP에 데이터를 넣는다
			new Hashtable<String, String>();



	@Override
	public void input() {

		System.out.println("학번?");
		hak =sc.next();

		//기존에 들어가 있는 데이터와 비교를 해야한다.
		if(searchHak(hak)){
			System.out.println("학번이 존재합니다!!");
			return;//stop
		}


		ScoreVO vo = new ScoreVO();

		System.out.println("이름?");//학번이 존재하지 않았을때 
		vo.setName(sc.next());

		System.out.println("국어?");
		vo.setKor(sc.nextInt());

		System.out.println("영어?");
		vo.setEng(sc.nextInt());

		System.out.println("수학?");
		vo.setMat(sc.nextInt());
		//결과적으로 vo에는 네개의 데이터가 들어가게 된다.

		hMap.put(hak, vo);

		System.out.println("추가성공!!");

	}




	@Override
	public boolean searchHak(String hak) {

		if(hMap.containsKey(hak)){//있다 없다;
			return true;//있다.
		}
		return false;//없다.

		/*return hMap.containsKey(hak);*/
	}

	@Override
	public void print() {

		Iterator<String> it = hMap.keySet().iterator();

		while(it.hasNext()){

			String key = it.next();//key는 학번 
			ScoreVO vo =hMap.get(key);

			System.out.println(key + " " + vo.toString());
		}



	}

	@Override
	public void delete() {

		System.out.println("학번을 입력하세요" );
		hak =sc.next();
		h.remove(hak);
		if(hMap.containsKey(hak)){//있다 없다;
			h.remove(hak);
			System.out.println("삭제성공");
		}else{
			System.out.println("삭제실패");





		}
	}



	@Override
	public void update() {

		System.out.println("수정할 학번?");
		hak =sc.next();

		if(searchHak(hak)){
			System.out.println("수정실패!");
			return;
		}

		ScoreVO preVO =hMap.get(hak);
		String preName = preVO.getName();


		ScoreVO vo = new ScoreVO();

		vo.setName(preName);

		System.out.println("국어?");
		vo.setKor(sc.nextInt());

		System.out.println("수학?");
		vo.setMat(sc.nextInt());

		System.out.println("영어?");
		vo.setEng(sc.nextInt());
		//결과적으로 vo에는 네개의 데이터가 들어가게 된다.

		hMap.put(hak, vo);



	}






	@Override
	public void findHak() {

		System.out.println("찾는 학번?");
		hak = sc.next();

		/*	Iterator<String> it = hMap.keySet().iterator();

		while(it.hasNext()){

			String key= it.next();

			if(hak.equals(key));

			System.out.println(key.toString());
			break;


		}*/

		if(!searchHak(hak)){//찾는 코딩이 길기 때문에 false로 만들어서 검색하게 한다
			//
			System.out.println("학번이 없습니다!");
			return;
		}
		ScoreVO vo = hMap.get(hak);

		System.out.println(hak + " "+ vo.toString());
	}




	@Override
	public void findName() {

		System.out.println("찾는 이름?");
		String name = sc.next();


		Iterator<String>it = hMap.keySet().iterator();

		boolean flag = false;

		while(it.hasNext()){

			String hak = it.next();
			ScoreVO vo =hMap.get(hak);
			/*if(vo.getName().equals(name));*/
			if(vo.getName().equals(name)){

				/*	System.out.println(vo.toString());*/
				System.out.println(hak + " "+vo.toString());
				flag = true;

			}
		}
		if(!flag)
			System.out.println("이름이 없습니다!");

	}
}





