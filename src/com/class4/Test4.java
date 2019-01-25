package com.class4;


//String을 보조해주는 클래스
//StringBUFFER : 느림, 동기화를 지원
//StringBuilder:속도가 빠름,동기화를 미지원
//우리가 생각하는 일반적인 클래스와 유사하다. 


//**동기화**: 자료의 데이터를 서로 맞추는것.

public class Test4 {
        public void stringTime(){
		
		System.out.println("StringTime...");
		
		//long start = System.currentTimeMillis();//밀리세컨
       long start = System.nanoTime();//10^-9 10의 마이너스 9승
       
       String str = new String("a");
       
       for(int i=0;i<=50000;i++){
    	      str += "a";
			
       }
       
       long end = System.nanoTime();
       
       System.out.println("실행시간:" + (end-start));
	}
	
	
	
	public void stringBufferTime(){
		
		System.out.println("StringBufferTime...");
		
		//long start = System.currentTimeMillis();//밀리세컨
       long start = System.nanoTime();//10^-9 10의 마이너스 9승
       
       StringBuffer str = new StringBuffer("a");
       
       for(int i=0;i<=50000;i++){
    	   str.append("a");
       }
       
       long end = System.nanoTime();
       
       System.out.println("실행시간:" + (end-start));
	}
	
public void stringBuilderTime(){
		
		System.out.println("StringBuilderTime...");
		
		//long start = System.currentTimeMillis();//밀리세컨
       long start = System.nanoTime();//10^-9 10의 마이너스 9승
       
       StringBuilder str = new StringBuilder("a");
       
       for(int i=0;i<=50000;i++){
    	   str.append("a");
       }
       
       long end = System.nanoTime();
       
       System.out.println("실행시간:" + (end-start));
	}

	public static void main(String[] args) {
		
		Test4 ob = new Test4();
		
		
	    ob. stringTime();
		ob. stringBufferTime();
		ob. stringBuilderTime();

	}

}
