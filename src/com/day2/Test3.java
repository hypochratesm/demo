package com.day2;

import java.io.*;

class Test3 {

	public static void main(String[] args) throws IOException{

       //char ch ='a'; 초기화는 이렇게 시킨다//반드시 작은 따옴표로 작성
	   //char은 기호를 담는 그릇, ASCII(이 값은 나라별로 다름),UNICODE를 저장한다.
	   //"a"는 우리가 알고 있는 a
	   //'aa'의 입력이 불가능 하다. 무조건 한 문자만 저장 할 수 있다.

	   char ch,result;

	   System.out.print("한문자?");//a(97)

	   ch = (char)System.in.read();//반환값이 int
	   
	   //자동으로 97이라는 정수로 형변화를 하고 ch로 넣어버린다. int를 char로 넣으려고 하니 들어가지 않는다.

	   result = ch>=65 && ch<=92?(char)(ch+32):
		   (ch>='a'&& ch<='z'?(char)(ch-32):ch);

		

	
	   System.out.println(ch+":"+result);
	
	   System.out.println(ch);
	   System.out.println(Integer.toString(ch)); //97이라는 숫자가 문자화 되서 보여지는것.
	   
	   //65= A , 92= Z

	   //result는 기호를 저장한다.

  
        

       
		
	}
}
