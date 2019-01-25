package com.health;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;



public class HealthImpl implements Health {

	private Map<String, HealthVO> hMap = new HashMap<String, HealthVO>();
	Scanner sc = new Scanner(System.in);
	String cod;
	Hashtable<String, String> h = new Hashtable<String, String>();



	@Override
	public void input() {

		System.out.println("회원코드?");
		cod = sc.next();

		if(searchCod(cod)){
			System.out.println("회원이 존재합니다.");
			return;
		}

		HealthVO vo = new HealthVO();

		System.out.println("이름?");
		vo.setName(sc.next());

		System.out.println("나이");
		vo.setAge(sc.next());

		System.out.println("성별");
		vo.setGender(sc.next());

		System.out.println("주소");
		vo.setAddr(sc.next());

		System.out.println("우편번호");
		vo.setZip(sc.next());

		System.out.println("몸무게");
		vo.setWeight(sc.nextFloat());

		System.out.println("키");
		vo.setHeight(sc.nextFloat());


		hMap.put(cod, vo);

		System.out.println("추가완료");







	}

	@Override
	public boolean searchCod(String cod) {

		if(hMap.containsKey(cod)){
			return true;
		}
		return false;
	}

	@Override
	public void print() {

		Iterator<String> it = hMap.keySet().iterator();
		while(it.hasNext()){

			String key = it.next();
			HealthVO vo = hMap.get(key);//KEY는 회원 번호

			System.out.println(key + " " + vo.toString());

		}
	}

	@Override
	public void delete() {

		System.out.println("회원번호를 입력하세요");
		cod =sc.next();

		if(hMap.containsKey(cod)){
			h.remove(cod);

			System.out.println("삭제완료");
		}else{
			System.out.println("입력된 데이터를 찾을 수 없습니다");

		}
	}

	@Override
	public void update() {

		System.out.println("수정할 회원 번호?");
		cod = sc.next();

		if(searchCod(cod)){
			System.out.println("수정실패");
			return;
		}

		HealthVO preVO = hMap.get(cod);
		String preName = preVO.getName();

		HealthVO vo = new HealthVO();


		System.out.println("나이");
		vo.setAge(sc.next());

		System.out.println("성별");
		vo.setGender(sc.next());

		System.out.println("주소");
		vo.setAddr(sc.next());

		System.out.println("우편번호");
		vo.setZip(sc.next());

		System.out.println("몸무게");
		vo.setWeight(sc.nextFloat());

		System.out.println("키");
		vo.setHeight(sc.nextFloat());


		hMap.put(cod, vo);


	}

	@Override
	public void findCod() {
		Iterator<String> it = hMap.keySet().iterator();

		while(it.hasNext()){

			String key= it.next();

			if(cod.equals(key));

			System.out.println(key.toString());
			break;
		}
	}


	@Override
	public void findAddr(){
		
		System.out.println("찾는 주소?");
		String addr =sc.next();
		
		Iterator<String>it = hMap.keySet().iterator();
		boolean flag =false;
		
		while(it.hasNext()){
			
			String cod =it.next();
			HealthVO vo = hMap.get(cod);
			
			if(vo.getAddr().equals(addr)){
				
				System.out.println(cod + " " + vo.toString());
				flag = true;
			}
			
			
			
			
		}
		
		
		
	}

	@Override
	public void ascAge() {//스트링 비교는 어떻게 만들까?
		
		
		Comparator<HealthVO> comp =new Comparator<HealthVO>() {
			
			@Override
			public int compare(HealthVO o1, HealthVO o2) {
				return o1.getAge().compareTo(o2.getAge());
			}
			
			
		};
		
		
		
		
	}

	



}
