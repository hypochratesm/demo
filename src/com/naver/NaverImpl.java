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

		System.out.println("���̵�:");
		vo.setId(sc.next());

		while (it.hasNext()) {

			NaverVO vo1 = it.next();

			while (vo.getId().equals(vo1.getId())) {
				System.out.println("�ش��ϴ� ���̵� �ֽ��ϴ�!");
				System.out.println("���̵� �ٽ� �Է��Ͻÿ�!");
				vo.setId(sc.next());
			}
		}

		if (!(vo.getId().length() >= 8 && vo.getId().length() <= 15)) {
			throw new Exception("8~15�ڸ� �Է��Ͻÿ�!");
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

				throw new Exception("������ �Ǵ� ���ڸ� �Է��Ͻÿ�!");

			}

		}

		if (!(alpabet && number)) {

			throw new Exception("�����ڿ� ���ڸ� ȥ���Ͽ� �Է��Ͻÿ�!");
		}

		System.out.println("��й�ȣ:");
		vo.setPw1(sc.next());

		System.out.println("��й�ȣ Ȯ��:");
		vo.setPw2(sc.next());

		while (!(vo.getPw1().equals(vo.getPw2()))) {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�! ���Է�:");
			vo.setPw2(sc.next());
		}

		System.out.println("�̸�?");
		vo.setName(sc.next());

		System.out.println("����?");
		vo.setGender(sc.next());

		System.out.println("�������:");
		vo.setBirth(sc.next());

		System.out.println("�̸���:");
		vo.setEmail(sc.next());

		System.out.println("��ȭ��ȣ:");
		vo.setTel(sc.next());

		lists.add(vo);

	}

	@Override
	public void print() {

		Iterator<NaverVO> it = lists.iterator();

		System.out.printf("%6s %7s %7s %2s %2s %2s %3s %3s", "���̵�", "��й�ȣ",
				"��й�ȣȮ��", "�̸�", "����", "�������", "�̸���", "��ȭ��ȣ\n");
		System.out
				.println("-----------------------------------------------------------------");

		while (it.hasNext()) {

			NaverVO vo = it.next();

			System.out.println(vo.toString());

		}

	}

	@Override
	public void findId() {

		System.out.print("�˻��� ���̵�:");
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
