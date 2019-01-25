package com.collect;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Test4 {

	public static void main(String[] args) {

		//set : 중복을 허용하지 않음

		Set<String> s = new HashSet<String>();

		s.add("서울");
		s.add("부산");
		s.add("대구");

		System.out.println(s);

		Iterator<String> it = s.iterator();
		while(it.hasNext()){

			String str = it.next();
			System.out.println(str + " ");
		}
		System.out.println();

		//중복을 허용안함

		s.add("서울");
		System.out.println(s);

		System.out.println("-----------------------------------");

		//Stack
		Stack<String> st = new Stack<String>();

		st.push("서울");
		st.add ("부산");
		st.push("대구");
		st.push("광주");

		//출력 후 st에 있는 데이터는 삭제 된다.

		while(!st.empty()){//st의 내용이 비어있지 않으면 실행하라.//while문의 실행문이 하나라 중괄호가 생략 가능
			System.out.println(st.pop() + " ");//들어간 순서 역순으로 인쇄된다.
		}
		System.out.println("\n-------------------------------------------"); 

		//Queue
		Queue<String> q = new LinkedList<String>();
		q.offer("서울");
		q.add("부산");
		q.offer("대구");
		q.offer("광주");

		while(q.peek()!=null){

			System.out.println(q.poll());
		}

		System.out.println("\n--------------------------");

		List<String> lists1 = new LinkedList<String>();

		lists1.add("A");
		lists1.add("B");
		lists1.add("C");
		lists1.add("D");
		lists1.add("E");
		lists1.add("F");
		lists1.add("G");
		lists1.add("H");
		lists1.add("I");


		List<String> lists2 = new LinkedList<String>();

		lists2.add("서울");
		lists2.add("부산");
		lists2.add("대구");


		lists2.addAll(lists1);

		for(String ss : lists1)
			System.out.print(ss + " ");
		System.out.println();

		for(String ss : lists2)
			System.out.print(ss + " ");
		System.out.println();
		
		
		
		lists2.subList(2,5).clear();  //-1
		for(String ss : lists2)
			System.out.print(ss + " ");
		System.out.println();
        
		String[] str = {"라","나","마","가","다"};
		
		for(String ss: str)
			System.out.print(ss + " ");
		System.out.println();
		//정렬
		
		Arrays.sort(str);
		for(String ss: str)
			System.out.println(ss+ " ");
		
		

	}
}
