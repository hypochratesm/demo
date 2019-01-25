package com.collect;

import java.util.Hashtable;
import java.util.Iterator;



//Collection
//Map<키(Set - 중복값을 넣을 수 없다.),값>//arraylist보다 빠르다.
//Hashtable : 동기화를 지원(Vector)
//HashMap : 동기화를 지원안함(ArrayList) - > 순서대로 출력된다.

//키는 중복적인 값을 가질 수 없다.(키는 Set)
//키가 중복적인 값이면 마지막 값이 저장된다.(수정)
//Map은 Iterator가 없다.//친척의 Iterator를 가져다가 쓴다.//친척 keyset의 데이터를 가져다 쓴다.
//put: 추가
//get: 가져오기



public class Test3 {


	public static final String name[] = 
		{"배수지","천송이","전지현","송지효","박신혜"};

	public static final String tel[] = 
		{"111-111","222-222","333-333","111-111","444-444"};



	public static void main(String[] args) {

		Hashtable<String, String> h = //MAP에 데이터를 넣는다
				new Hashtable<String, String>();

		for(int i =0;i<name.length;i++){


			h.put(tel[i], name[i]);//키가 중복되면 수정된다.//키와 밸류값
               // key    , value
		}
		System.out.println(h);
		//map의 출력은 랜덤이다.

		String str;

		str = h.get("111-111"); // key를 주면 값을 가져옴
		if(str==null) //앞의 이퀄이 적용이 안될때가 있어서 비교를 두번 해준다.
			System.out.println("자료없음");
		else
			System.out.println(str);
		/* || str.equals("")*/


		//키가 존재하는지 검사

		if(h.containsKey("222-222"))
			System.out.println("222있다");
		else
			System.out.println("222없다");

		//데이터가 존재하는지 검사

		if(h.containsValue("천송이")){

			System.out.println("송이 있다");
		}else{
			System.out.println("송이 없다");
		}
		//삭제
		h.remove("222-222");

		if(h.containsKey("222-222"))
			System.out.println("222있다");
		else
			System.out.println("222없다");


		//전체출력
		Iterator<String> it = h.keySet().iterator();
		//키의 자료형을 괄호안에 넣어 준다
		while(it.hasNext()){

			String key = it.next();//key를 반환
			String value = h.get(key);//value를 반환

			System.out.println(key + ":" + value);
	

	}

}

	}
