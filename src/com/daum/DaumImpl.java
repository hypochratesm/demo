package com.daum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DaumImpl implements Daum{

	private List<DaumVO> list = new ArrayList<DaumVO>();
	
	Scanner sc = new Scanner(System.in);
	//String id,pw1,pw2,name,gender,birth,email,tel;
	
	@Override
	public void join() throws Exception {
		
		boolean corre;
		DaumVO vo = new DaumVO();
		Iterator<DaumVO> it = list.iterator();
		
		System.out.println("아이디를 입력해주세요");
		vo.setId(sc.next());
		
		
		
		while (it.hasNext()) {
			DaumVO daumVO = it.next();
			if (vo.equals(daumVO)) {
				System.out.println("이미 가입된 아이디 입니다.");
				System.out.println("아이디를 다시 입력해주세요");
				vo.setId(sc.next());
			}
		}
		
	
		
		Iterator<DaumVO> it2 = list.iterator();
		

		if (vo.getId().length()<8) {
			System.out.println("아이디는 8글자 이상으로 만들어주세요");
			vo.setId(sc.next());
		}else if (vo.getId().length()>15) {
			System.out.println("아이디는 15글자 이하로 만들어 주세요");
			vo.setId(sc.next());
			}else {
			corre = false;
			}
	
		
		System.out.println("비밀번호를 입력해주세요.");
		vo.setPw1(sc.next());
		System.out.println("비밀번호를 다시 입력해주세요");
		vo.setPw2(sc.next());
		if (!(vo.getPw1().equals(vo.getPw2()))) {
			System.out.println("비밀번호가 일치하지 않습니다");
			System.out.println("다시 입력해주세요");
			vo.setPw2(sc.next());
		}
		System.out.println("이름을 입력해주세요");
		vo.setName(sc.next());
		System.out.println("성별을 입력하세요");
		vo.setGender(sc.next());
		System.out.println("생일을 입력하세요");
		vo.setBirth(sc.next());
		System.out.println("이메일을 입력하세요");
		vo.setEmail(sc.next());
		System.out.println("전화번호를 입력하세요");
		vo.setTel(sc.next());
		
		
		list.add(vo);
		
		
		
	}

	@Override
	public void print() {
		Iterator<DaumVO> it = list.iterator();
		
		System.out.printf("%6s %10s %10s %7s %3s %5s %10s %8s", "아이디", "비밀번호",
				"비밀번호확인", "이름", "성별", "생년월일", "이메일", "전화번호\n");
		System.out.println("-----------------------------------------------------------------");
		
		//str = String.format("%6s %10s %10s %7s %3s %5s %10s %8s", id, pw1, pw2,
		//name, gender, birth, email, tel);
		
		while (it.hasNext()) {
			DaumVO vo =  it.next();
			System.out.println(vo.toString());
		}
		
		
	}

	@Override
	public void findId() {
		System.out.println("검색할 아이디를 입력하세요");
		String findId= sc.next();
		
		Iterator<DaumVO> it = list.iterator();
		
		while (it.hasNext()) {
			DaumVO daumVO = it.next();
			if (daumVO.getId().equals(findId)) {
				System.out.println("아이디가 존재합니다");
				System.out.println();
				System.out.println(daumVO.toString());
				break;
			}else{
				System.out.println("아이디가 존재하지 않습니다");
				break;
			}
		}
		
	}

	@Override
	public void findPwd() {
		
		System.out.println("가지고 계신계정의 아이디를 입력하세요");
		String findId = sc.next();
		/*System.out.println("가지고 계신계정의 전화번호를 입력하세요");
		String findTel = sc.next();*/
		
		Iterator<DaumVO> it = list.iterator();
		
		while (it.hasNext()) {
			DaumVO daumVO = it.next();
			if (daumVO.getId().equals(findId)) {
				System.out.println("아이디가 존재합니다");
				System.out.println();
				System.out.println(daumVO.toString());
				break;
			}else{
				System.out.println("아이디가 존재하지 않습니다");
				break;
			}
		}
		
		while (it.hasNext()) {
			DaumVO daumVO = it.next();
			if (daumVO.getId().equals(findId)) {
				System.out.println("아이디가 존재합니다");
				System.out.println();
				System.out.println(daumVO.toString());
				break;
			}else{
				System.out.println("아이디가 존재하지 않습니다");
				break;
			}
		}
		
		
	}

	
	
	
}
