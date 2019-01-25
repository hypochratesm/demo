package com.day6;

import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args){
		
	//주민번호 검색
	//index : 01234567890123
    //jumin : 941231-2053128
    //check : 234567 892345(체크값)
		
	//합 = (9*2)+(4*3)+...+(2*5)
	//합 = 11-합%11
	//합 = 합%10
    //합 ==8
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		int[] chk = {2,3,4,5,6,7,8,9,2,3,4,5};
		int i,tot,su;
		
		System.out.print("주민번호[xxxxxx-xxxxxxx]?:");
		str = sc.next();
		
		if(str.length()!=14){//배열의 렝스에만 괄호가 없다
			
			System.out.println("입력오류!!");
		    return;//main메소드를 빠져나감(stop)//여기까지만 하고 검증은 하지마! 라는 뜻
		    
		    
		}
		
		tot = 0;
		for(i=0;i<12;i++){//tot라는 그릇은 하나다.
			
			if(i>=6){//뒷자리를 비교하는 것
				tot+=chk[i]*
				Integer.parseInt(str.substring(i+1 , i+2));//string으로 읽은 것은 무조건 문자다.
				
			}else{//생년월일
				tot+=chk[i]*
				Integer.parseInt(str.substring(i , i+1));//0에서부터 0까지/ 서브스트링은 반드시 -1을 해주어야 하기 떄문에 +1을 해준다.
			}
		}
		
	    su = 11 - tot %11;
	    su = su%10;
	    
	    if(su==Integer.parseInt(str.substring(13))){
	    	System.out.println("정확한 주민번호!!");
	    }else{
	    	System.out.println("틀린 주민번호!!");
	    }
	}
	
	

}



/*//주민번호 검색

		String str = "seoul korea";//string은 문자를 저장하는 자료형이지만 클래스다.
		//            01234567890
		
		System.out.println(str.substring(0,3));//seo
		System.out.println(str.substring(6,8));
		System.out.println(str.substring(6));//서브스트링은 문자열을 추출하는 것//내가 원하는 범위를 추출해내라....*/