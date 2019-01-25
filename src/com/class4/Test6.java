package com.class4;

public class Test6 {
	
	public static void main(String[] args){
		
		
		String s1 ="서울,부산,대구";
		String[] ss = s1.split(",");//spilt해서 배열을 만들어라..//칸을 만들어
		//서울,부산,대구를 배열한다.
		
		for(String s : ss){
			System.out.println(s);		
		}
		String s2 = "seoul";
		String s3 = "SEOUL";
		
		System.out.println(s2.equals(s3));
		System.out.println(s2.equalsIgnoreCase(s3));//대소문자 관계없이 비교하라.//true
		
		String s4 = "abc.def.hij";
		//           01234567890
		System.out.println(s4.indexOf("."));//3 //index는 일련번호//어떠한 인덱스도 0부터 시작한다.
	    System.out.println(s4.lastIndexOf("."));//7
	    System.out.println(s4.indexOf("def"));//4
	    System.out.println(s4.indexOf("x"));//-1
	    System.out.println(s4.indexOf("x")!=-1);
	    //시작값이 0부터이기 때문에 없을때의 숫자를 표시해야만 한다. 가장 가까운 숫자인
	    //-1을 표시해준다.
	    
	    String s5 = "우리나라 대한민국 좋은나라 대한민국";
	    String s6 = s5.replaceAll("대한", "大韓"); 
	    System.out.println(s6);
	    
	    String s7 = "  a  b  c  ";//오른쪽 끝에 enter값이 있다.
	    System.out.println(s7);
	    System.out.println(s7.trim());//trim은 앞뒤에 공백을 지워준다.
	    System.out.println(s7.replaceAll(" ", ""));
	    System.out.println(s7.replaceAll("\\s",""));//정규화 표현식
	    
	    char ch = "abcdefg".charAt(2);//c
	    System.out.println(ch);//c
	    
	    System.out.println("abcdefg".startsWith("abc"));//true
	    
	    System.out.println("abcdefg".length());//배열의 length는 괄호가 없다.
	    
	    String s8 = "abcedfg";//101
	    String s9 = "abcddfg";//100
	    
	    //사전식 배열
	    
	    System.out.println(s8.compareTo(s9));//1
	    System.out.println(s9.compareTo(s8));//-1
	}

}
