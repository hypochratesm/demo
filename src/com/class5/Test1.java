package com.class5;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test1 {
	

	
	public static void main(String[] args){
		
		 
		 //현재 시스템의 날짜 및 시간을 관리
		
		Calendar now =Calendar.getInstance();
		//Calendar now1 = new GregorianCalendar();
		//자식을 통해서 부모의 객체를 생성해줄 수 있다..
		
		int y = now.get(Calendar.YEAR);//year는 static에 올라가 있다.
		int m = now.get(Calendar.MONTH)+1;//넣을때는 +1, 꺼낼때는 -1을 해준다.//0부터 11까지 저장되어 있다.
		int d = now.get(Calendar.DATE);
		int w = now.get(Calendar.DAY_OF_WEEK);//1-7
		
		System.out.println(y + "-" + m + "-" + d);
        System.out.println(w);
		 
		String[] week = {"일","월","화","수","목","금","토"};
		
	System.out.println(y+"-" + m + "-" + d + "-" + week[w-1]);//배열의 시작은 0부터이기 때문에 -1을 해준다.
	
	int startDAY = now.getActualMinimum(Calendar.DATE);
	int endDAY = now.getActualMaximum(Calendar.DATE);
	
	System.out.println("첫날:" + startDAY);
	System.out.println("말일:" + endDAY);
	
    System.out.printf("%tF\n",now);
    System.out.printf("%tT\n",now);
    
    System.out.printf("%1$tF %1$tT\n",now);//%뒤에 1$를 써주게 되면 분배법칙이 적용된다.
    
    now.set(2019, 10-1, 10);//날짜를 집어넣어 주는 것.
    
    
    //*****cal.add*****

	y = now.get(Calendar.YEAR);
    m = now.get(Calendar.MONTH)+1;
	d = now.get(Calendar.DATE);
	w = now.get(Calendar.DAY_OF_WEEK);//1-7
	
	System.out.println(y+"-" + m + "-" + d + "-" + week[w-1]);
	
	}
}

	/*
	 
	int a;
	double b;
	
	a=10;
	
	b=a;           -O(암시적 형변환)
	b = (double)a; -O(명시적 형변환) 
	
	a = b;         -X
	a = (int)b;    -O(명시적 형변환) 
	--------------------------------
	부모(b) - 자식(a)
	
	부모 = 자식;       -O(UPCAST)
	부모 =(부모)자식;  -O
	
	자식 = 부모;       -X
	자식 = (자식)부모; -O(DOWNCAST)
	//부모를 자식으로 형변환 해서 자식에 넣을 수 있다.*/
	 
	 