package com.class7;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Test7 {
	
	private static final String city[]= {"서울","부산","대구","인천","광주","대전","울산"};
	
	
	
	
	
	

	public static void main(String[] args) {
		
		
		Vector<String> v = new Vector<String>();
		String str;
		
		System.out.println("벡터의 초기용량" + v.capacity());
		
		for(String c : city){
			v.add(c);
		}
		System.out.println("[Iterator를 사용한 전체 출력...]");
		//iterator로 반복적으로 하나씩 읽어옴
		Iterator<String> it = v.iterator();//저장소
		while(it.hasNext()){
			
			str = it.next();
			System.out.println(str + " ");
			
		}
		System.out.println();
		System.out.println("데이터(요소) 갯수:" +v.size());
		
		
		//변경하기. -> 데이터 변경//override
		v.set(0,"Seoul");
		v.set(1,"Pusan");
		
		System.out.println("[전체출력...]");
		for(String s: v){
			System.out.println(s + " ");
		}
		System.out.println();
		System.out.println();
		
		//끼워넣기
		v.insertElementAt("대한민국", 0);//set과 다르게 괄호안에 입력변수의 순서가 다르다.

		for(String c : city){
			v.add(c);
		}
		
		System.out.println();
		System.out.println();
		
		
		//검색
		int index = v.indexOf("대구");
		if(index!=-1){//인덱스로 찾았을때 없으면 나오는 값이 -1
			System.out.println("검색성공:" + index);//3
			
		}else{
			
			System.out.println("검색실패:" + index);// -1
		}
		
		//오름차순(1~10,a~z,ㄱ~ㅎ)
		Collections.sort(v);
		for(String s: v){
			System.out.println(s + " ");
		}
		
		System.out.println();
		
		
		//내림차순(10~1,z~a,ㅎ~ㄱ)
		Collections.sort(v,Collections.reverseOrder());
		
		for(String s: v){
			System.out.println(s + " ");
		}
		
		System.out.println();
		
		//삭제
		
		v.remove("Pusan");// v.remove(7);
		for(String s: v){
			System.out.println(s + " ");
		}
		System.out.println();
		
		
		//용량증가
		for(int i =0;i<20;i++){//기본배열이 10개이기 때문에 20개로 용량을 증가시켜줌
			v.add(Integer.toString(i));
		}
		for(String s: v){
			System.out.println(s + " ");
		}
		System.out.println();
		
		System.out.println("벡터의 용량" + v.capacity());
		System.out.println("데이터 갯수:" +v.size());
		
		//범위삭제
		
		//v.removeRange(5,20);-X
		for(int i=1;i<10;i++){
			v.remove(5);//10번을 삭제...
		}
		for(String s: v){
			System.out.println(s + " ");
		}
		System.out.println();
		
		
		
		System.out.println("벡터의 용량" + v.capacity());
		System.out.println("데이터 갯수:" +v.size());
		
		//빈공간 삭제
		v.trimToSize();
		System.out.println("벡터의 용량" + v.capacity());
		System.out.println("데이터 갯수:" +v.size());
		
		//전체삭제
		v.clear();		
		System.out.println("벡터의 용량" + v.capacity());
		System.out.println("데이터 갯수:" +v.size());
		
      	v.trimToSize();
		System.out.println("벡터의 용량" + v.capacity());
		System.out.println("데이터 갯수:" +v.size());
		
		
	}
	   
}
