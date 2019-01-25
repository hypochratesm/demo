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
		
		System.out.println("���̵� �Է����ּ���");
		vo.setId(sc.next());
		
		
		
		while (it.hasNext()) {
			DaumVO daumVO = it.next();
			if (vo.equals(daumVO)) {
				System.out.println("�̹� ���Ե� ���̵� �Դϴ�.");
				System.out.println("���̵� �ٽ� �Է����ּ���");
				vo.setId(sc.next());
			}
		}
		
	
		
		Iterator<DaumVO> it2 = list.iterator();
		

		if (vo.getId().length()<8) {
			System.out.println("���̵�� 8���� �̻����� ������ּ���");
			vo.setId(sc.next());
		}else if (vo.getId().length()>15) {
			System.out.println("���̵�� 15���� ���Ϸ� ����� �ּ���");
			vo.setId(sc.next());
			}else {
			corre = false;
			}
	
		
		System.out.println("��й�ȣ�� �Է����ּ���.");
		vo.setPw1(sc.next());
		System.out.println("��й�ȣ�� �ٽ� �Է����ּ���");
		vo.setPw2(sc.next());
		if (!(vo.getPw1().equals(vo.getPw2()))) {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
			System.out.println("�ٽ� �Է����ּ���");
			vo.setPw2(sc.next());
		}
		System.out.println("�̸��� �Է����ּ���");
		vo.setName(sc.next());
		System.out.println("������ �Է��ϼ���");
		vo.setGender(sc.next());
		System.out.println("������ �Է��ϼ���");
		vo.setBirth(sc.next());
		System.out.println("�̸����� �Է��ϼ���");
		vo.setEmail(sc.next());
		System.out.println("��ȭ��ȣ�� �Է��ϼ���");
		vo.setTel(sc.next());
		
		
		list.add(vo);
		
		
		
	}

	@Override
	public void print() {
		Iterator<DaumVO> it = list.iterator();
		
		System.out.printf("%6s %10s %10s %7s %3s %5s %10s %8s", "���̵�", "��й�ȣ",
				"��й�ȣȮ��", "�̸�", "����", "�������", "�̸���", "��ȭ��ȣ\n");
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
		System.out.println("�˻��� ���̵� �Է��ϼ���");
		String findId= sc.next();
		
		Iterator<DaumVO> it = list.iterator();
		
		while (it.hasNext()) {
			DaumVO daumVO = it.next();
			if (daumVO.getId().equals(findId)) {
				System.out.println("���̵� �����մϴ�");
				System.out.println();
				System.out.println(daumVO.toString());
				break;
			}else{
				System.out.println("���̵� �������� �ʽ��ϴ�");
				break;
			}
		}
		
	}

	@Override
	public void findPwd() {
		
		System.out.println("������ ��Ű����� ���̵� �Է��ϼ���");
		String findId = sc.next();
		/*System.out.println("������ ��Ű����� ��ȭ��ȣ�� �Է��ϼ���");
		String findTel = sc.next();*/
		
		Iterator<DaumVO> it = list.iterator();
		
		while (it.hasNext()) {
			DaumVO daumVO = it.next();
			if (daumVO.getId().equals(findId)) {
				System.out.println("���̵� �����մϴ�");
				System.out.println();
				System.out.println(daumVO.toString());
				break;
			}else{
				System.out.println("���̵� �������� �ʽ��ϴ�");
				break;
			}
		}
		
		while (it.hasNext()) {
			DaumVO daumVO = it.next();
			if (daumVO.getId().equals(findId)) {
				System.out.println("���̵� �����մϴ�");
				System.out.println();
				System.out.println(daumVO.toString());
				break;
			}else{
				System.out.println("���̵� �������� �ʽ��ϴ�");
				break;
			}
		}
		
		
	}

	
	
	
}
