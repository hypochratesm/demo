package exam;

import java.util.HashSet;
import java.util.Iterator;

public class Test5 {
	
	public void hashExam() {
		
		HashSet<String> hs01 = new HashSet<String>();
		HashSet<String> hs02 = new HashSet<String>();
		//add()메소드를 이용한 요소의 저장
		
		hs01.add("홍길동");
		hs01.add("이순신");
		
		//새로 입력한다면 true를 반환
		System.out.println(hs01.add("임꺽정"));
		System.out.println();
		//이미 입력된 값이 있다면 false == 중복된 값이 있다면
		System.out.println(hs01.add("임꺽정"));
		
		System.out.println();
		System.out.println("포문으로 출력한다");
		System.out.println();
	    for (String e : hs01) {
			System.out.println(e+" ");
		}
	    
	    //iterator()메소드를 이용한 요소의 출력
	    System.out.println();
		System.out.println("이터레이터로 출력한다");
		System.out.println();
		
		hs02.add("김밥");
		hs02.add("떡볶이");
		hs02.add("마시쪙!");
		hs02.add("가래떡");
	    
		Iterator<String> it2 = hs02.iterator();
		
		while (it2.hasNext()) {

			System.out.println(it2.next()+ " ");
			
		}
		
		System.out.println();
		System.out.println("집합의 크기1:" + hs01.size());
		System.out.println("집합의 크기2:" + hs02.size());
		System.out.println();
		
		
	}
	
	public static void main(String[] args) {
		
		Test5 ts5 = new Test5();
		ts5.hashExam();
	}
	
	
}
