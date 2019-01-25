package com.score4;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;





public class ScoreImpl implements Score {

	//���� �ʺ��� �����
	/*	private Map<String, ScoreVO> hMap = new HashMap<String, ScoreVO>();*/

	private Map<String, ScoreVO> hMap = new TreeMap<String, ScoreVO>();//�������� ����

	Scanner sc = new Scanner(System.in);
	String hak;//�ν��Ͻ� ������ ������ �ʱ�ȭ�� ���� �ʴ´�.

	Hashtable<String, String> h = //MAP�� �����͸� �ִ´�
			new Hashtable<String, String>();



	@Override
	public void input() {

		System.out.println("�й�?");
		hak =sc.next();

		//������ �� �ִ� �����Ϳ� �񱳸� �ؾ��Ѵ�.
		if(searchHak(hak)){
			System.out.println("�й��� �����մϴ�!!");
			return;//stop
		}


		ScoreVO vo = new ScoreVO();

		System.out.println("�̸�?");//�й��� �������� �ʾ����� 
		vo.setName(sc.next());

		System.out.println("����?");
		vo.setKor(sc.nextInt());

		System.out.println("����?");
		vo.setEng(sc.nextInt());

		System.out.println("����?");
		vo.setMat(sc.nextInt());
		//��������� vo���� �װ��� �����Ͱ� ���� �ȴ�.

		hMap.put(hak, vo);

		System.out.println("�߰�����!!");

	}




	@Override
	public boolean searchHak(String hak) {

		if(hMap.containsKey(hak)){//�ִ� ����;
			return true;//�ִ�.
		}
		return false;//����.

		/*return hMap.containsKey(hak);*/
	}

	@Override
	public void print() {

		Iterator<String> it = hMap.keySet().iterator();

		while(it.hasNext()){

			String key = it.next();//key�� �й� 
			ScoreVO vo =hMap.get(key);

			System.out.println(key + " " + vo.toString());
		}



	}

	@Override
	public void delete() {

		System.out.println("�й��� �Է��ϼ���" );
		hak =sc.next();
		h.remove(hak);
		if(hMap.containsKey(hak)){//�ִ� ����;
			h.remove(hak);
			System.out.println("��������");
		}else{
			System.out.println("��������");





		}
	}



	@Override
	public void update() {

		System.out.println("������ �й�?");
		hak =sc.next();

		if(searchHak(hak)){
			System.out.println("��������!");
			return;
		}

		ScoreVO preVO =hMap.get(hak);
		String preName = preVO.getName();


		ScoreVO vo = new ScoreVO();

		vo.setName(preName);

		System.out.println("����?");
		vo.setKor(sc.nextInt());

		System.out.println("����?");
		vo.setMat(sc.nextInt());

		System.out.println("����?");
		vo.setEng(sc.nextInt());
		//��������� vo���� �װ��� �����Ͱ� ���� �ȴ�.

		hMap.put(hak, vo);



	}






	@Override
	public void findHak() {

		System.out.println("ã�� �й�?");
		hak = sc.next();

		/*	Iterator<String> it = hMap.keySet().iterator();

		while(it.hasNext()){

			String key= it.next();

			if(hak.equals(key));

			System.out.println(key.toString());
			break;


		}*/

		if(!searchHak(hak)){//ã�� �ڵ��� ��� ������ false�� ���� �˻��ϰ� �Ѵ�
			//
			System.out.println("�й��� �����ϴ�!");
			return;
		}
		ScoreVO vo = hMap.get(hak);

		System.out.println(hak + " "+ vo.toString());
	}




	@Override
	public void findName() {

		System.out.println("ã�� �̸�?");
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
			System.out.println("�̸��� �����ϴ�!");

	}
}





