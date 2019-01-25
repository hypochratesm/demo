package com.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.print.DocFlavor.STRING;




//List(i) - ArrayList(C)
//Vector보다 성능이 좋다(동기화가 안됨)
//Vector는 동기화가 됨


public class Test2 {

	public static void main(String[] args) {
		
		ArrayList<String> lists = new ArrayList<String>();
		lists.add("서울");
		lists.add("부산");
		lists.add("대구");
		
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
		while(it2.hasPrevious()){//역순으로 꺼낸다.
			System.out.println(it2.previous() + " ");
			//전체적으로 카피의 개념
		}
		//upcast // 부모의 변수에 넣어준다.
		List<String> lists1 = new ArrayList<String>();
		
		lists1.addAll(lists);
		lists1.add("인천");
		
		int n = lists1.indexOf("부산");
		lists1.add(n+1,"광주");
        
		for(String c: lists1)
			System.out.print(c + " ");
		
		lists1.add("자바프로그래머");
		lists1.add("프레임워크");
		lists1.add("스트럿츠");
		lists1.add("자바란?");
		lists1.add("스프링");
		
		String str;
		
	    Iterator<String> it3 = lists.iterator();
	    while(it3.hasNext()){
	    	
	    	str = it3.next();
	    	if(str.startsWith("자바")){
	    		System.out.println(str + " ");
	    	}	
	    	
	    }

		//list - vector(동기화o) array(동기화x) - 업캐스트가 아니다
	}

}
