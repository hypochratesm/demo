package com.class7;

import java.util.Iterator;
import java.util.Vector;

public class Test6 {
	
	private static final String city[]= {"서울","부산","대구","인천","광주","대전","울산"};
	
	public static void main(String[] args){
		
		Vector<String> v = new Vector<String>();
		
		//어떤 데이터만 저장할 수 있다!//String 형태의 컬렉션
		
		
		for(String c: city){//확장 for문
			v.add(c);
		}
		
		//생성된 객체 v에 city 요소들을 넣어주었다.
		
		//v.add(10);
		String str;
		
		str = v.firstElement();//첫번쨰값 가지고 와라~
		System.out.println("첫번째요소:" + str);
		
		str = v.lastElement();
		System.out.println("마지막요소:" + str);
		
		str = v.get(2);//0.1.2
		System.out.println("세번째요소:" + str);
		
		System.out.println();
		
		str = v.get(3);
		System.out.println("네번째요소:\r" + str);
		
		System.out.println();
		
		
		for(int i = 0;i<v.size();i++){
			System.out.println(v.get(i));
		}
		System.out.println();
		
		for(String s:v){
			
			System.out.print(s + " ");
			
		}
		System.out.println();
		//자바에서의 확장포문 배열과 콜렉션
		
		//Iterator:반복자(출력기)
        
	    Iterator<String> it = v. iterator();
	    
	    while(it.hasNext()){ //벡터에 얼마만큼의 데이터가 들어가는지 알 수 없기 때문에 while을 쓴다/	
	    	str = it.next(); // 두 번 꺼낼 수 없다. // it 안에 데이터는 한번 꺼내면 사라지기 때문에.
	    	System.out.print(str + " ");
	    	
	    	//while문은 암기하자!!!!!
	    	
	    }
		
	
		
		
		
		
		
		
		
	}    
	

}
