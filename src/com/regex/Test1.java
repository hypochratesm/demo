package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



//java.util.regex
//정규화 표현식
//단어바꾸기,메일주소 검색,파일 제어문자 제거

/*c[a~z]* : c로 시작하는 영단어(c,ca,cbvf)

 * 
c[a-z] : c로 시작하는 두단어(ca,cg)


c[a-zA-Z0-9] : ca,cA,c4


c. :c로 시작하는 두 글자 (ca,cB,c&)


c.* : c로 시작하는 모든문자


c.*t : ct,chh7hhht,c775458777t


[b|c].* 또는[bc].* 또는[b-c].* : b,c,bbb,cad


[^b|c] 또는 [^bc].* 또는[^b-c].*:b또는 c로 시작하지 않는 문자.


.*c.*: c가 포함된 문자열(s45c78g)


[\\d]+또는 [0-9]+ : 하나이상의 숫자가 나와야 한다.









 */



public class Test1 {

	public static void main(String[] args){


		String[] str = {"bat", "baby", "bonus", "c","cA","ca","c","c0","car","combat","count","date","disc"};

		Pattern p;

		p= Pattern.compile("c[a-z]*");//패턴정의 - c로 시작하는 영단어,뒤에 대문자나 숫자가 입력되면 단어로 인식하지 못한다.
		for(String s : str){

			Matcher m = p.matcher(s);

			if(m.matches()){

				System.out.println(s);

			}


		}
		System.out.println("-------------------------------");

		p =Pattern.compile("c[a-z]+");//c로 시작해서 알파벳이 두 개 이상으로 이루어진 단어들....
		for(String s:str){


			Matcher m = p.matcher(s);

			if(m.matches()){

				System.out.println(s);



			}

		}
		System.out.println("-------------------------------");

		p =Pattern.compile("c.");//c로 시작하는 두 글자 문자나 단어는 이에 속하지 않는다.
		for(String s:str){


			Matcher m = p.matcher(s);

			if(m.matches()){

				System.out.println(s);
		
			}
		}
		
		System.out.println("-----------");
        //메일확인
		
		String[] mail = {"aaa@aaa.com","@aaa.co.kr","@bbb.com","aaa@vvv.co.kr","sss.co.kr","abc@bbb"};
		
		/*[\\w]+ : 한글자 이상의 영,숫자
		@
		(\\.[\\w]+) : 괄호안에 있는것은 반드시 한번은 사용해라
		 \\. : dot반드시 사용해야한다.
*/		
		String pat = "[\\w]+@[\\w]+(\\.[\\w]+)+";
		
		for(String s : mail){
			
			if(Pattern.matches(pat, s))
				System.out.println(s);
			
		}
		
		
		}
	}
