package com.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.print.DocFlavor.STRING;




//List(i) - ArrayList(C)
//Vector���� ������ ����(����ȭ�� �ȵ�)
//Vector�� ����ȭ�� ��


public class Test2 {

	public static void main(String[] args) {
		
		ArrayList<String> lists = new ArrayList<String>();
		lists.add("����");
		lists.add("�λ�");
		lists.add("�뱸");
		
		Iterator<String> it1 = lists.iterator();
		while(it1.hasNext()){
			String str = it1.next();
					System.out.println(str + " ");
			
		}
		System.out.println();
		
		ListIterator<String> it2 = lists.listIterator();
		while(it2.hasNext()){
			
			System.out.println(it2.next() + " ");
			
		}
		
		System.out.println();
		while(it2.hasPrevious()){//�������� ������.
			System.out.println(it2.previous() + " ");
			//��ü������ ī���� ����
		}
		//upcast // �θ��� ������ �־��ش�.
		List<String> lists1 = new ArrayList<String>();
		
		lists1.addAll(lists);
		lists1.add("��õ");
		
		int n = lists1.indexOf("�λ�");
		lists1.add(n+1,"����");
        
		for(String c: lists1)
			System.out.print(c + " ");
		
		lists1.add("�ڹ����α׷���");
		lists1.add("�����ӿ�ũ");
		lists1.add("��Ʈ����");
		lists1.add("�ڹٶ�?");
		lists1.add("������");
		
		String str;
		
	    Iterator<String> it3 = lists.iterator();
	    while(it3.hasNext()){
	    	
	    	str = it3.next();
	    	if(str.startsWith("�ڹ�")){
	    		System.out.println(str + " ");
	    	}	
	    	
	    }

		//list - vector(����ȭo) array(����ȭx) - ��ĳ��Ʈ�� �ƴϴ�
	}

}
