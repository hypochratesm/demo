package com.naver;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NaverImpl implements Naver {

	private List<NaverVO> lists = new ArrayList<NaverVO>();

	Scanner sc = new Scanner(System.in);

	@Override
	public void input() throws Exception {

		NaverVO vo = new NaverVO();
		Iterator<NaverVO> it = lists.iterator();

		System.out.println("아이디:");
		vo.setId(sc.next());

		while (it.hasNext()) {

			NaverVO vo1 = it.next();

			while (vo.getId().equals(vo1.getId())) {
				System.out.println("해당하는 아이디가 있습니다!");
				System.out.println("아이디를 다시 입력하시오!");
				vo.setId(sc.next());
			}
		}

		if (!(vo.getId().length() >= 8 && vo.getId().length() <= 15)) {
			throw new Exception("8~15자리 입력하시오!");
		}

		boolean alpabet = false;
		boolean number = false;

		for (int i = 0; i < vo.getId().length(); i++) {

			if ((vo.getId().charAt(i) >= 'a' && vo.getId().charAt(i) <= 'z')
					|| (vo.getId().charAt(i) >= 'A' && vo.getId().charAt(i) <= 'Z')) {

				alpabet = true;

			} else if (vo.getId().charAt(i) >= '0'
					&& vo.getId().charAt(i) <= '9') {

				number = true;

			} else {

				throw new Exception("영문자 또는 숫자를 입력하시오!");

			}

		}

		if (!(alpabet && number)) {

			throw new Exception("영문자와 숫자를 혼용하여 입력하시오!");
		}

		System.out.println("비밀번호:");
		vo.setPw1(sc.next());

		System.out.println("비밀번호 확인:");
		vo.setPw2(sc.next());

		while (!(vo.getPw1().equals(vo.getPw2()))) {
			System.out.println("비밀번호가 일치하지 않습니다! 재입력:");
			vo.setPw2(sc.next());
		}

		System.out.println("이름?");
		vo.setName(sc.next());

		System.out.println("성별?");
		vo.setGender(sc.next());

		System.out.println("생년월일:");
		vo.setBirth(sc.next());

		System.out.println("이메일:");
		vo.setEmail(sc.next());

		System.out.println("전화번호:");
		vo.setTel(sc.next());

		lists.add(vo);

	}

	@Override
	public void print() {

		Iterator<NaverVO> it = lists.iterator();

		System.out.printf("%6s %7s %7s %2s %2s %2s %3s %3s", "아이디", "비밀번호",
				"비밀번호확인", "이름", "성별", "생년월일", "이메일", "전화번호\n");
		System.out
				.println("-----------------------------------------------------------------");

		while (it.hasNext()) {

			NaverVO vo = it.next();

			System.out.println(vo.toString());

		}

	}

	@Override
	public void findId() {

		System.out.print("검색할 아이디:");
		String findid = sc.next();

		Iterator<NaverVO> it = lists.iterator();

		while (it.hasNext()) {

			NaverVO vo = it.next();

			if (findid.equals(vo.getId())) {

				System.out.println(findid + " " + vo.toString());
				break;
			}
		}
	}
}
