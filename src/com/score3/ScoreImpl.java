package com.score3;

import java.util.ArrayList; //����
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class ScoreImpl implements Score {
	
	private ArrayList<ScoreVO> lists = new ArrayList<ScoreVO>();//ScoreVO ���¸� �� �� �ִ�. �ѹ� ������ �ڷ����� ������ �ʴ´�.
	
	//�ڽ��� ��ü�� �����ؼ� �θ�ȭ ��Ų��.
	//ArrayList�� �迭�� ���� ������ ����.
	//ScoreVO�� ��ü�� new�� ���� ����
	//private List<ScoreVO> lists = new ArrayList<ScoreVO>();
	//list�� ������ �Ǿ����� ������ ���� ����....
	//List �θ�� �ڽ� �����ε� �ڽ��� ���� ��ü�� �����ߴ�.
	
	
	Scanner sc = new Scanner(System.in);
	@Override
	public int input() {//Ŭ�������� �����͸� 1��и� ���� �� �� �ձ� ������ 10���� �����͸� �����Ϸ��� 10���� Ŭ������ �ʿ��ϴ�.
		
		//int�� �������� ������ �Է��� �־��� ������ �ʱ�ȭ�� �ʿ��ϴ�.
		int result = 0;
		
		
		ScoreVO vo = new ScoreVO();//1���� �����͸� �����Ѵ�.����� �ο��� �ü��� �Է��ؾ��ϴ� VO�� �þ��.
		
		
		
		System.out.println("�й�?");
		vo.setHak(sc.next());  
		
		System.out.println("�̸�?");
		vo.setName(sc.next());
		
		System.out.println("����?");
		vo.setKor(sc.nextInt());
		
		System.out.println("����?");
		vo.setEng(sc.nextInt());
		
		System.out.println("����?");
		vo.setMat(sc.nextInt());
		
		
		lists.add(vo);
		
		
		return 0;//�ǹ̴� ������ DB���� ����Ѵ�.
	}

	public void print() {
		
	Iterator<ScoreVO> it = lists.iterator();
	
	System.out.printf("%2s %6s %s %s %s %s %s\n" , "�й�","�̸�","����","����","����","����","���");
	System.out.println("---------------------------------------");
	
	while(it.hasNext()){
	
	   ScoreVO vo = it.next();
       System.out.println(vo.toString());
       
	}

	}

	@Override
	public void searchHak() {//�˻��� �й��� �������� ��������Ѵ�.
		
		System.out.println("ã�� �й�?");//111
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
		

		System.out.println("�˻��� �̸�?");//111
		String name = sc.next();
		
		Iterator<ScoreVO> it = lists.iterator();
		
		while(it.hasNext()){
			
			   ScoreVO vo = it.next();
			   
			   if(vo.getName().equals(name)){
			   
		           System.out.println(vo.toString());
		           //������ ���ƾ� �Ѵ�. �̸��� ��ĥ���� �ֱ� ������
	          }
			
		   }
	}

	@Override
	public void descSortTot() {//�������� ����
		
		//������ �Ҷ���? comparator - �ڹ� ��ƿ�� �ִ�. - > ������ �������̵� �ؾ��Ѵ�.
		//������ Ŭ����
		
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				return vo1.getTot()<vo2.getTot()?1:-1;
			}//<��������     >��������  ->�����̱� ������ �ε�ȣ�� ���Ѵ�.
			
		};
		
		Collections.sort(lists, comp);
		
		print();//�״�� ȣ�����ش�.
		
	}

	@Override
	public void ascSorthak() {//�������� ����
		
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				return vo1.getHak().compareTo(vo2.getHak());
			}//<��������     >��������  ->�����̱� ������ �ε�ȣ�� ��ȯ�Ѵ�.
			//compareTo
			
		};
			Collections.sort(lists, comp);
			
	
}
	
	

}
