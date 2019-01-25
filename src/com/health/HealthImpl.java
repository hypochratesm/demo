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

		System.out.println("ȸ���ڵ�?");
		cod = sc.next();

		if(searchCod(cod)){
			System.out.println("ȸ���� �����մϴ�.");
			return;
		}

		HealthVO vo = new HealthVO();

		System.out.println("�̸�?");
		vo.setName(sc.next());

		System.out.println("����");
		vo.setAge(sc.next());

		System.out.println("����");
		vo.setGender(sc.next());

		System.out.println("�ּ�");
		vo.setAddr(sc.next());

		System.out.println("�����ȣ");
		vo.setZip(sc.next());

		System.out.println("������");
		vo.setWeight(sc.nextFloat());

		System.out.println("Ű");
		vo.setHeight(sc.nextFloat());


		hMap.put(cod, vo);

		System.out.println("�߰��Ϸ�");







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
			HealthVO vo = hMap.get(key);//KEY�� ȸ�� ��ȣ

			System.out.println(key + " " + vo.toString());

		}
	}

	@Override
	public void delete() {

		System.out.println("ȸ����ȣ�� �Է��ϼ���");
		cod =sc.next();

		if(hMap.containsKey(cod)){
			h.remove(cod);

			System.out.println("�����Ϸ�");
		}else{
			System.out.println("�Էµ� �����͸� ã�� �� �����ϴ�");

		}
	}

	@Override
	public void update() {

		System.out.println("������ ȸ�� ��ȣ?");
		cod = sc.next();

		if(searchCod(cod)){
			System.out.println("��������");
			return;
		}

		HealthVO preVO = hMap.get(cod);
		String preName = preVO.getName();

		HealthVO vo = new HealthVO();


		System.out.println("����");
		vo.setAge(sc.next());

		System.out.println("����");
		vo.setGender(sc.next());

		System.out.println("�ּ�");
		vo.setAddr(sc.next());

		System.out.println("�����ȣ");
		vo.setZip(sc.next());

		System.out.println("������");
		vo.setWeight(sc.nextFloat());

		System.out.println("Ű");
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
		
		System.out.println("ã�� �ּ�?");
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
	public void ascAge() {//��Ʈ�� �񱳴� ��� �����?
		
		
		Comparator<HealthVO> comp =new Comparator<HealthVO>() {
			
			@Override
			public int compare(HealthVO o1, HealthVO o2) {
				return o1.getAge().compareTo(o2.getAge());
			}
			
			
		};
		
		
		
		
	}

	



}
