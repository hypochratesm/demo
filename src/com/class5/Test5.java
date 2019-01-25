package com.class5;


//Singleton - 클래스에서 단 하나의 객체만을 생성하게 하는 방법.//하나의 클래스 자체를 메모리상에 올려놓고 사용하는 기법
//Calendar now = Calendar.getInstance();//대표적인 싱글텀의 예시

class Sing{
	
	private static Sing ob;//클래스는 초기값이 무조건 nullㅋㅋㅋㅋ
    
	public static Sing getInstance(){
		
		if(ob==null)
			ob = new Sing();
		
		//코딩
		
		return ob;
		
	}
	
	
}


public class Test5 {

	public static void main(String[] args){
		
		Sing ob1 = Sing.getInstance();
		Sing ob2 = Sing.getInstance();
		
		if(ob1==ob2){//==는 주소를 비교한다.
			System.out.println("동일객체...");
		}else{
			System.out.println("안동일객체...");
		}
		
	}
}
