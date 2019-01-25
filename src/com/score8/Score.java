package com.score8;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class Score {

	Scanner sc = new Scanner(System.in);
	ScoreDAO1 dao = new ScoreDAO1();


	//1.�߰�

	public void insert(){//�� �༮�� ���ο��� ȣ���ؾ� �Ѵ�.


		ScoreDTO dto = new ScoreDTO();
		//�� �༮�� insert�޼ҵ� ������ �����ٸ� 1���� �Է��� �Ǵ°��̱� ������ �ݺ������� ������ �߻��� ���� �ִ�.

		System.out.println("�й�?");
		dto.setHak(sc.next());

		System.out.println("�̸�?");
		dto.setName(sc.next());

		System.out.println("����?");
		dto.setKor(sc.nextInt());

		System.out.println("����?");
		dto.setEng(sc.nextInt());

		System.out.println("����?");
		dto.setMat(sc.nextInt());

		int result = dao.insertData(dto); //��ȯ���� ���� �ʾƵ� �ȴ�.

		if(result!=0){
			System.out.println("�߰�����");
		}else{
			System.out.println("�߰�����");
		}

	}

	public void update(){

		ScoreDTO dto = new ScoreDTO();


		System.out.println("������ �й�?");
		dto.setHak(sc.next());

		System.out.println("����?");
		dto.setKor(sc.nextInt());

		System.out.println("����?");
		dto.setEng(sc.nextInt());

		System.out.println("����?");
		dto.setMat(sc.nextInt());

		int result = dao.updateData(dto);

		if(result!=0)
			System.out.println("���� ����!!");
		else
			System.out.println("���� ����!!");


	}
	public void delete(){

		System.out.println("������ �й�?");
		String searchHak = sc.next();

		int result = dao.deleteData(searchHak);

		if(result!=0){
			System.out.println("��������");
		}else{
			System.out.println("��������");
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
		
		
		System.out.println("�й�");
		String searchHak = sc.next();
		
		ScoreDTO dto = dao.getList(searchHak);
		
		if(dto!=null){
			System.out.println(dto.toString());
		}else{
			System.out.println("ã���й��� �����ϴ�.");
			
		}
		
		
		
	}
	
	
	
}
